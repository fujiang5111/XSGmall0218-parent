package com.xiaoshan.xsgmall0218.publisher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xiaoshan.xsgmall0218.publisher.mapper")
public class Xsgmall0218PublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(Xsgmall0218PublisherApplication.class, args);
    }

}
