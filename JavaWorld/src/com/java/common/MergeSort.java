package com.java.common;

import java.util.Arrays;

class MergeSort {

    public static void main(String... args) {
        int[] arr = {5, 10, 15, 0, -9, 20, 99, 17, 14};

        System.out.println(Arrays.toString(merge_sort(arr)));
    }

    private static int[] merge_sort(int[] arr) {
        if(arr.length <= 1) return arr;
        int mid = arr.length / 2;

        int[] first = new int[mid];
        int[] second = new int[arr.length - mid];
        for(int i = 0; i < arr.length; i++) {
            if(i < mid) {
                first[i] = arr[i];
            } else {
                second[i-mid] = arr[i];
            }
        }

        return merge(merge_sort(first), merge_sort(second));
    }

    private static int[] merge(int[] first, int[] second) {
        System.out.println("Merge: " + Arrays.toString(first) + " & " + Arrays.toString(second));
        int[] arr = new int[first.length + second.length];
        int i=0, j=0, idx=0;

        while (i<first.length || j<second.length) {
            if(i == first.length) {
                arr[idx++] = second[j++];
                continue;
            }

            if(j == second.length) {
                arr[idx++] = first[i++];
                continue;
            }

            arr[idx++] = first[i] > second[j] ? second[j++] : first[i++];
        }

        return arr;
    }
}
