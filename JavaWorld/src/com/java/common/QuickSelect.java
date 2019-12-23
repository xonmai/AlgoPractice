package com.java.common;

import java.util.Arrays;

public class QuickSelect {

    public static void main(String... args) {
        int[] arr = {5, 10, 15, 0, -9, 20, 99, 17, 14};


        System.out.println(quickSelect(arr, 0, 0, arr.length - 1));
    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;
        for(int j=l; j<=r; j++) {
            if(arr[j] > pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        //Swap i and pivot
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }

    public static int quickSelect(int[] arr, int k, int l, int r) {
        if (l == r) return arr[l];

        int pi = partition(arr, l, r);
        if(k == pi) {
            return arr[k];
        } else if(k < pi) {
            return quickSelect(arr, k, l, pi-1);
        } else {
            return quickSelect(arr, k, pi+1, r);
        }
    }
}
