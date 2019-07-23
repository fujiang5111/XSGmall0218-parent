package com.xiaoshan.xsgmall0218.publisher.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xiao-shan
 * @create 2019-07-22 19:27
 */
public interface DauMapper {

    public Integer getDauTotal(String date);

    public List<Map> getDauHour(String date);

}
