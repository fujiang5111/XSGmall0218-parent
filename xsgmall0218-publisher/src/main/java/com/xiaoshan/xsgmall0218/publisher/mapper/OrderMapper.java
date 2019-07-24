package com.xiaoshan.xsgmall0218.publisher.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xiao-shan
 * @create 2019-07-24 8:17
 */
public interface OrderMapper {

    // 返回交易额总数
    public double getOrderAmountTotal(String date);

    public List<Map> getOrderAmountHour(String date);

}
