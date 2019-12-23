package com.java.common;

import java.util.*;

class QuickSort {

    public static void main(String... args) {
        int[] arr = {5, 10, 15, 0, -9, 20, 99, 17, 14};

        quick_sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for(int j=left; j<right; j++) {
            if(arr[j] < pivot) {
//                System.out.println("Pivot = " + pivot);
                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }

    public static void quick_sort(int[] arr, int left, int right) {
        if(left < right) {
            int pi = partition(arr, left, right);
            quick_sort(arr, left, pi-1);
            quick_sort(arr, pi+1, right);
        }
    }
}
