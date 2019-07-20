package com.xsgmall0218.mock.util;

import java.util.Random;

/**
 * @author xiao-shan
 * @create 2019-07-19 15:27
 */
public class RandomNum {
    public static final  int getRandInt(int fromNum,int toNum){
        return   fromNum+ new Random().nextInt(toNum-fromNum+1);
    }
}
