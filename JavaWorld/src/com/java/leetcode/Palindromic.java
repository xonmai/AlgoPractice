package com.java.leetcode;

public class Palindromic {

    public static void main(String... args) {
        String input = "aba555";

        System.out.println(resolve(input));
    }

    public static String resolve(String input) {
        if(input.length() == 1) return input;
        int max = 1;
        int start = 0;
        for(int i=0; i<input.length(); i++) {
            int len = 1;
            for(int j=1; j<=i || i+j<input.length(); j++ ) {
                if(input.charAt(i-j) == input.charAt(i+j)) {
                    len += 2;
                    if (len > max) {
                        max = len;
                        start = i-j;
                    }
                }
            }
        }

        return input.substring(start, start+max);
    }
}
