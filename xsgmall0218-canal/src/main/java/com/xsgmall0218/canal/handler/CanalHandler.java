package com.xsgmall0218.canal.handler;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xsgmall0218.canal.MyKafkaSender;
import com.xsgmall0218.common.constant.GmallConstant;

import java.util.List;

/**
 * @author xiao-shan
 * @create 2019-07-23 19:11
 */
public class CanalHandler {
    String tableName;
    CanalEntry.EventType eventType;
    List<CanalEntry.RowData> rowDataList;

    public CanalHandler(String tableName, CanalEntry.EventType eventType, List<CanalEntry.RowData> rowDataList) {
        this.tableName = tableName;
        this.eventType = eventType;
        this.rowDataList = rowDataList;
    }

    public void handler(){
        if(tableName.equals("order_info") && eventType == CanalEntry.EventType.INSERT ){ //下单操作
            for (CanalEntry.RowData rowData : rowDataList) { //rowData 行集
                List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList(); //修改后的列集
                JSONObject jsonObject = new JSONObject(); //类似HashMap
                for (CanalEntry.Column column : afterColumnsList) { // 遍历列集,遍历后形成一行数据

                    System.out.println(column.getName()+"|||||"+column.getValue());
                    jsonObject.put(column.getName(),column.getValue());

                }

                MyKafkaSender.send(GmallConstant.KAFKA_TOPIC_ORDER,jsonObject.toJSONString()); // 发送kafka
            }
        }
    }
}
