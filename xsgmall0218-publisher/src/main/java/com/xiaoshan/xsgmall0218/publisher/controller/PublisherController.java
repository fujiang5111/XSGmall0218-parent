package com.xiaoshan.xsgmall0218.publisher.controller;

import com.alibaba.fastjson.JSON;
import com.xiaoshan.xsgmall0218.publisher.service.PublisherService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xiao-shan
 * @create 2019-07-22 19:55
 */
@RestController
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @GetMapping("realtime-total")
    public String getRealtimeTotal(@Param("date") String date){
        Integer dauTotal = publisherService.getDauTotal(date);
        List list = new ArrayList();
        Map dauMap = new HashMap();
        dauMap.put("id","dau");
        dauMap.put("name","新增日活");
        dauMap.put("value",dauTotal);
        list.add(dauMap);

        Map midMap = new HashMap();
        midMap.put("id","new_mid");
        midMap.put("name","新增设备");
        midMap.put("value",233);
        list.add(midMap);

        return JSON.toJSONString(list);
    }

    @GetMapping("realtime-hour")
    public String getRealtimeHour(@RequestParam("id")String id , @RequestParam("date") String todayDate ) {
        if (id.equals("dau")) {
            //日活
            Map dauHourTDMap = publisherService.getDauHour(todayDate);
            String yesterdayDate = getYdateString(todayDate);
            Map dauHourYDMap = publisherService.getDauHour(yesterdayDate);

            Map<String, Map> hourMap = new HashMap();
            hourMap.put("today", dauHourTDMap);
            hourMap.put("yesterday", dauHourYDMap);

            return JSON.toJSONString(hourMap);

        }
        return  null;
    }

    private String getYdateString(String todayDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ydateString="";
        try {
            Date tdate = simpleDateFormat.parse(todayDate);

            Date ydate = DateUtils.addDays(tdate, -1);
            ydateString=simpleDateFormat.format(ydate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ydateString;

    }
}
