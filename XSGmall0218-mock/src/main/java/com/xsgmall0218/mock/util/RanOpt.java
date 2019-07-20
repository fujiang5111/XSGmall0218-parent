package com.xsgmall0218.mock.util;

/**
 * @author xiao-shan
 * @create 2019-07-19 15:27
 */
public class RanOpt<T> {

    T value ;
    int weight;

    public RanOpt ( T value, int weight ){
        this.value=value ;
        this.weight=weight;
    }

    public T getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}
