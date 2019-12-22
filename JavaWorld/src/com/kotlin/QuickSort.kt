package com.kotlin

fun main(args: Array<String>) {
    val arr = arrayOf(0,10,5,19,7,0,15,29,23,10)

    println(quickSort(arr).contentToString())
}

fun quickSort(arr: Array<Int>): Array<Int> {
    if(arr.size <= 1) return arr

    val pivot = arr[0]
    val smaller = arr.filter{i -> i < pivot}.toTypedArray()
    val greater = arr.filter{i -> i > pivot}.toTypedArray()
    val equal = arr.filter{i -> i == pivot}.toTypedArray()

    println("Quick sort for ${smaller.contentToString()} + ${equal.contentToString()} + ${greater.contentToString()}")
    return quickSort(smaller) + equal + quickSort(greater)
}