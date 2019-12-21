package com.kotlin

fun main(args: Array<String>) {
    val arr = arrayOf(10,5,19,7,0,15,29,23,10)

    println(mergeSort(arr).contentToString())
}

fun mergeSort(arr: Array<Int>): Array<Int> {
    if (arr.size <= 1) return arr
    val mid = arr.size / 2
    val first = arr.filterIndexed{ idx, _ -> idx < mid }.toTypedArray()
    val second = arr.filterIndexed{ idx, _ -> idx >= mid }.toTypedArray()

    return merge(mergeSort(first), mergeSort(second))
}

fun merge(first: Array<Int>, second: Array<Int>): Array<Int> {
    println("Merge ${first.contentToString()} + ${second.contentToString()}")
    var i = 0
    var j = 0
    var arr = arrayOf<Int>()

    while(i<first.size || j<second.size) {
        if(i == first.size) {
            arr += second[j++]
            continue
        }
        if(j == second.size) {
            arr += first[i++]
            continue
        }

        arr += if(first[i] > second[j]) second[j++] else first[i++]
    }
    return arr
}