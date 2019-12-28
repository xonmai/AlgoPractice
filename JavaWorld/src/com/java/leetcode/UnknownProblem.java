package com.java.leetcode;

import java.util.Arrays;


public class UnknownProblem {

    public static void main(String[] args) {
        int[] nums = {10,22,9,33,21,50,41,60,80};

        System.out.println(longestCommonPrefix(nums));
    }

    public static int longestCommonPrefix(int[] nums) {
        if(nums.length <= 1) return nums.length;

        int longest = 1;
        int a[] = new int[nums.length];
        Arrays.fill(a, 1);
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<=i; j++) {
                if(nums[i] > nums[j] && a[i] <= a[j]) {
                    a[i] = a[j] + 1;
                    longest = Math.max(longest, a[i]);
                }
            }
        }

        return longest;
    }

    // Longest common
    public static int binary(int[] nums) {;
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

}
