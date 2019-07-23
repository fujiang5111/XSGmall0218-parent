package com.xiaoshan.xsgmall0218.publisher.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xiao-shan
 * @create 2019-07-22 19:52
 */
public interface PublisherService {

    public Integer getDauTotal(String date);

    Map getDauHour(String todayDate);
}
