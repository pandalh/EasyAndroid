package com.chen.app.k_line.formatter

import com.chen.app.k_line.base.IValueFormatter
import java.util.*

/**
 * 对较大数据进行格式化
 * Created by tifezh on 2017/12/13.
 */
class BigValueFormatter : IValueFormatter {
    //必须是排好序的
    private val values = intArrayOf(10000, 1000000, 100000000)
    private val units = arrayOf("万", "百万", "亿")
    override fun format(value: Float): String? {
        var value = value
        var unit = ""
        var i = values.size - 1
        while (i >= 0) {
            if (value > values[i]) {
                value /= values[i]
                unit = units[i]
                break
            }
            i--
        }
        return String.format(Locale.getDefault(), "%.2f", value) + unit
    }
}