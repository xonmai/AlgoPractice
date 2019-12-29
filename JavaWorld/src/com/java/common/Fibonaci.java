package com.java.common;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Fibonaci {

    private static Map<Integer, Long> cache = new HashMap();

    public static void main(String... args) {
        int k = 30;

        long start = new Date().getTime();
        // 0ms for k = 50
        System.out.println(fibonaciDP(k));
        System.out.println("Execution time: " + (new Date().getTime() - start) + "ms");

        System.out.println(formula(k));
        System.out.println(fibonaci(k));
    }

    private static long fibonaci(int k) {
        if (k < 3) return 1L;
        return fibonaci(k-1) + fibonaci(k-2);
    }

    private static long fibonaciWithCache(int k) {
        if (k < 3) return 1L;
        if (cache.get(k) != null) {
            return cache.get(k);
        }
        cache.put(k-2, fibonaci(k-2));
        cache.put(k-1, fibonaci(k-1));
        return fibonaci(k-1) + fibonaci(k-2);
    }

    private static long fibonaciDP(int k) {
        long n1 = 1;
        long n2 = 1;
        long temp;
        for(int i=2; i<k; i++) {
            temp = n2;
            n2 = n1 + n2;
            n1 = temp;
        }

        return n2;
    }

    private static int formula(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(phi, n)
                / Math.sqrt(5));
    }

}
