package com.kotlin


fun main() {
    val arr = arrayOf(0,10,5,19,7,0,15,29,23,10)
    println(arr.sortedArray().contentToString())

    println(quickSelect(arr, 5, 0, arr.size-1))
}

fun partition(arr: Array<Int>, l: Int, r: Int): Int {
    val pivot = arr[r]
    var i = l
    for(j in l..r) {
        if(arr[j] > pivot) {
            var temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            i++
        }
    }

    //Swap pivot
    var temp = arr[i]
    arr[r] = arr[i]
    arr[i] = temp

    return i
}

fun quickSelect(arr: Array<Int>, k: Int, l: Int, r: Int): Int {
    println("Find ${k}-th in ${arr.take(r-l)}")
    if(l == r) return arr[l]
    val pi = partition(arr, l ,r)
    return if(pi < k) {
        quickSelect(arr, k, pi+1, r)
    } else {
        quickSelect(arr, k, l, pi-1)
    }
}


