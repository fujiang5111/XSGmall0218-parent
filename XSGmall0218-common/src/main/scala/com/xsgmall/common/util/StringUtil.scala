package com.xsgmall.common.util

/**
  * @author xiao-shan
  * @create 2019-07-21 10:09
  */
object StringUtil {

  def isNotEmpty(startDate: String): Boolean = {
    startDate != null && !"".equals(startDate.trim)
  }
}
