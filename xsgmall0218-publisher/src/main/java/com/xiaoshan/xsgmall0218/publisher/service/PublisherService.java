package com.xiaoshan.xsgmall0218.publisher.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xiao-shan
 * @create 2019-07-22 19:52
 */
public interface PublisherService {

    /*
    查询日活总数
     */
    public Integer getDauTotal(String date);

    /*
    查询日活分时明细
     */
    public Map getDauHour(String todayDate);

    /*
    查询总交易额
     */
    public double getOrderAmountTotal(String date);

    /*
    查询分时交易额
     */
    public Map getOrderAmountHour(String date);

}
