package com.xiaoshan.xsgmall0218.publisher.service.impl;

import com.xiaoshan.xsgmall0218.publisher.mapper.DauMapper;
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

}
