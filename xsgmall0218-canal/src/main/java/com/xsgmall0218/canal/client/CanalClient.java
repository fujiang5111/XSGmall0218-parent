package com.xsgmall0218.canal.client;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.InvalidProtocolBufferException;
import com.xsgmall0218.canal.handler.CanalHandler;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author xiao-shan
 * @create 2019-07-23 18:25
 */
public class CanalClient {
    public static void main(String[] args) {
        //创建连接器
        CanalConnector canalConn = CanalConnectors.newSingleConnector(
                new InetSocketAddress("hadoop102", 11111),
                "example1", "", "");

        //实时监控，所以该进程启动后，不会自动停止，除非手动
        while(true){
            //连接
            canalConn.connect();
            //抓取的表  抓取所有表
            canalConn.subscribe("xsgmall0218.*");

            //抓取，能抓100个，首先服务器有个存储。每个MySQL对应一个消息队列。
            Message message = canalConn.get(100);
            if(message.getEntries().size() == 0){
                System.out.println("没有数据，休息一会！");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else{
                for (CanalEntry.Entry entry : message.getEntries()) {
                    //每一个entry对应一个SQL，不是真实的SQL，会将变化的数据放到entry里面
                    //过滤entry ，因为不是每个SQL都是对数据进行修改的写操作 如：开关事物
                    if(entry.getEntryType().equals(CanalEntry.EntryType.ROWDATA)){
                        //entry.getStoreValue() //二进制序列化的值
                        CanalEntry.RowChange rowChange = null;
                        try {
                            //把storeValue进行反序列化，得到rowChange
                            rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();

                        }
                        List<CanalEntry.RowData> rowDatasList = rowChange.getRowDatasList(); // 行集 数据
                        CanalEntry.EventType eventType = rowChange.getEventType(); // insert update delete drop
                        String tableName = entry.getHeader().getTableName();// 表名

                        CanalHandler canalHandler = new CanalHandler(tableName,eventType,rowDatasList);
                        canalHandler.handler();
                    }

                }
            }

        }


    }
}
