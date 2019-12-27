package com.java.leetcode;


public class SuperUgly {

    public static void main(String[] args) {
        int N = 12;
        int[] primes = {2,7,13,19};

        System.out.println(nthSuperUglyNumber(N, primes));
    }


    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] ret = new int[n];
        ret[0] = 1;
        int[] multiple_of = new int[primes.length];
        // Arrays.fill(multiple_of, 1);

        for(int i=1; i<n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<primes.length; j++) {
                int idx = ret[multiple_of[j]];
                if (min > primes[j] * idx) {
                    min = primes[j] * idx;
                }
            }

            ret[i] = min;

            for(int j=0; j<primes.length; j++) {
                if (ret[multiple_of[j]] * primes[j] == min) {
                    multiple_of[j]++;
                }
            }
        }

        return ret[n-1];
    }
}
