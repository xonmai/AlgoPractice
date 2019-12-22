package com.java.common;

import java.util.*;

class QuickSort {

    public static void main(String... args) {
        Integer[] arr = {5, 10, 15, 0, -9, 20, 99, 17, 14};

        System.out.println(quick_sort(arr));
    }

    private static List<Integer> quick_sort(Integer[] arr) {
        if (arr.length <= 1) return Arrays.asList(arr);

        int pivot = arr[0];
        List<Integer> left = new ArrayList();
        List<Integer> mid = new ArrayList();
        List<Integer> right = new ArrayList();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] < pivot) {
                left.add(arr[i]);
            } else if(arr[i] > pivot) {
                right.add(arr[i]);
            } else {
                mid.add(arr[i]);
            }
        }

        System.out.println("Quick sort: " + left + " + " + mid + " + " + right);

        List<Integer> ret = new ArrayList<>();
        ret.addAll(quick_sort(left.toArray(new Integer[0])));
        ret.addAll(mid);
        ret.addAll(quick_sort(right.toArray(new Integer[0])));
        return ret;
    }
}
