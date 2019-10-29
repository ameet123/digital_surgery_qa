package com.jnj.surgery.qa.util

object CommonUtils {

  def fileToString(filename: String): String = {
    scala.io.Source.fromResource(filename).getLines().mkString
  }
}
