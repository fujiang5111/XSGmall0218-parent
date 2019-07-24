package com.xiaoshan.xsgmall0218.publisher.service.impl;

import com.xiaoshan.xsgmall0218.publisher.mapper.DauMapper;
import com.xiaoshan.xsgmall0218.publisher.mapper.OrderMapper;
import com.xiaoshan.xsgmall0218.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author xiao-shan
 * @create 2019-07-22 19:53
 */
@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    DauMapper dauMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Integer getDauTotal(String date) {

        return dauMapper.getDauTotal(date);
    }

    @Override
    public Map getDauHour(String date) {
        List<Map> dauHourMap = dauMapper.getDauHour(date);
        Map dauMap = new HashMap();
        for (Map map : dauHourMap) {
            Long ct = (Long) map.get("CT");
            String loghour = (String) map.get("LOGHOUR");
            dauMap.put("ct",ct);
            dauMap.put("loghour",loghour);
        }

        return dauMap;
    }

    @Override
    public double getOrderAmountTotal(String date) {
        return orderMapper.getOrderAmountTotal(date);
    }

    @Override
    public Map getOrderAmountHour(String date) {
        List<Map> orderAmountHour = orderMapper.getOrderAmountHour(date);
        Map orderAmountMap = new HashMap();

        for (Map map : orderAmountHour) {
            orderAmountMap.put(map.get("CREATE_HOUR"),map.get("ORDER_AMOUNT"));
        }
        return orderAmountMap;
    }

}
