package com.xsgmall.common.util

import java.util.ResourceBundle

import com.alibaba.fastjson.{JSON, JSONObject}

/**
  * @author xiao-shan
  * @create 2019-07-21 10:09
  */
object ConfigUtil {

  private val bundle: ResourceBundle = ResourceBundle.getBundle("config")
  private val condBundle: ResourceBundle = ResourceBundle.getBundle("condition")

  def main(args: Array[String]): Unit = {
    //    println(getValueByKey("hive.database"))
    println(getValueByJsonKey("startDate"))

  }

  def getValueByJsonKey(jsonKey: String): String ={
    val jsonString: String = condBundle.getString("condition.params.json")
    val jsonObj: JSONObject = JSON.parseObject(jsonString)
    jsonObj.getString(jsonKey)
  }

  def getValueByKey(key : String): String = {
    /*val stream: InputStream = Thread.currentThread().getContextClassLoader.getResourceAsStream("config.properties")

    val properties = new Properties()

    properties.load(stream)

    properties.getProperty(key)*/
    bundle.getString(key)
  }
}
