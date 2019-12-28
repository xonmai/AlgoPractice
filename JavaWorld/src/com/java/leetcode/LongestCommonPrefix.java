package com.java.leetcode;

public class LongestCommonPrefix {

    public static void main(String... args) {
        String[] input = {"Flight", "Flower", "Fly", "Fortunate", "Flood"};
        System.out.println(longestCommonPrefix(input));
    }

    public static String longestCommonPrefix(String[] input) {
        if(input == null || input.length < 1) return "";
        if(input.length == 1) return input[0];

        String ret = input[0];
        int idx = 1;
        while(!ret.isEmpty() && idx < input.length) {
            if(input[idx].indexOf(ret) != 0) {
                ret = ret.substring(0, ret.length()-1);
            } else {
                idx++;
            }
        }

        return ret;
    }
}
