package com.java.leetcode;

public class MedianArrays {
    public static void main(String... args) {
        int[] arr1 = {1, 5, 7};
        int[] arr2 = {2, 3};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int size = arr1.length + arr2.length;
        int i = 0;
        int j = 0;
        int med1 = 0;
        int med2 = 0;
        for (int idx = 0; idx <= size / 2; idx++) {
            med1 = med2;
            if (i == arr1.length) {
                med2 = arr2[j++];
                continue;
            }
            if (j == arr2.length) {
                med2 = arr1[i++];
                continue;
            }

            med2 = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }
        if (size % 2 == 1) med1 = med2;

        return ((double) med1 + med2) / 2;
    }
}
