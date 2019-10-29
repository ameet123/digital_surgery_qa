package com.jnj.surgery.qa.unitTest

import com.jnj.surgery.qa.config.DSPConstants
import com.jnj.surgery.qa.util.CommonUtils
import org.scalatest.FlatSpec

class CommonTester extends FlatSpec {

  "read resource file" should "get string" in {
    val jwtStr = CommonUtils.fileToString("ameet.jwt")
    println(jwtStr)
  }
  "Read bearer token" should "get authorize header" in {
    println(DSPConstants.AMEET_JWT)
  }
}
