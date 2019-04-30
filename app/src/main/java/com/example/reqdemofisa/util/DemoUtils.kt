package com.example.reqdemofisa.util


import java.math.RoundingMode
import java.text.DecimalFormat

object DemoUtils {
fun doubleToString(value: Double, pattern: String): String {
  val decimalFormat = DecimalFormat(pattern)
  decimalFormat.roundingMode = RoundingMode.FLOOR
  return decimalFormat.format(value)
}
}