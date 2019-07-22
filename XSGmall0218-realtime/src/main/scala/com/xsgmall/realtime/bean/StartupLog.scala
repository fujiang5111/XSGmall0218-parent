package com.xsgmall.realtime.bean

/**
  * @author xiao-shan
  * @create 2019-07-21 10:27
  */
case class StartupLog(mid:String,
                      uid:String,
                      appid:String,
                      area:String,
                      os:String,
                      ch:String,
                      logType:String,
                      vs:String,
                      var logDate:String,
                      var logHour:String,
                      ts:Long
                     )