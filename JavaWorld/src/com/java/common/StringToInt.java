package com.java.common;

public class StringToInt {

    public static void main(String... args){
        String[] input = {"-1", "10", "0", "02019", "RandomString", null, "", "-237192321937219192", "-055", "0.5"};
        for(String i : input) {
            try {
                System.out.println(String.format("Convert %s to %d", i, convertToInt(i)));
            } catch(Exception ex) {
                System.out.println("Invalid format: " + i);
            }
        }
    }

    public static int convertToInt(String str) throws Exception {
        if(str == null || str.isEmpty()) throw new Exception();
        int signed = str.charAt(0) == '-' ? -1 : 1;
        int idx = signed == -1 ? 1 : 0;
        long ret = 0;
        for (;idx < str.length(); idx++) {
            if(str.charAt(idx) < '0' || str.charAt(idx) > '9') {
                throw new Exception();
            }

            ret = ret*10 + (str.charAt(idx) - '0');
            if(ret > Integer.MAX_VALUE) {
                if(signed == -1) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
        }

        return (int) ret*signed;
    }
}
