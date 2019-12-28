package com.kotlin

fun main() {
    val input = arrayOf("Flight", "Flower", "Flood")
    println(longestCommonPrefix(input))
}

fun longestCommonPrefix(input: Array<String>): String {
    if(input.isEmpty()) return ""
    if(input.size == 1) return input[0]

    var prefix = input[0]
    for(i in 1 until input.size) {
        while(input[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length-1)
            if(prefix.isEmpty()) return ""
        }
    }

    return prefix
}


