package com.java.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Romanizer {

    public static Map<Integer, String> map = new HashMap();

    static {
        map.put(0, "");
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    public static void main(String ...args) {
        List<Integer> lst = new ArrayList<>();

        lst.add(1000);
        lst.add(999);
        lst.add(997);
        lst.add(978);
        lst.add(915);
        lst.add(911);
        lst.add(910);
        lst.add(909);
        lst.add(0);
        lst.add(1);

        System.out.println(romanizer(lst));
    }

    public static List<String> romanizer(List<Integer> numbers) {
        List<String> ret = new ArrayList<>();
        for (Integer i : numbers) {
            ret.add(convertRoman(i));
        }

        return ret;
    }

    public static String convertRoman(Integer number) {
        if (number == 1000) {
            return map.get(number);
        } else if (number >= 900) {
            return map.get(900) + convertRoman(number - 900);
        } else if (number >= 500) {
            return map.get(500) + convertRoman(number - 500);
        } else if (number >= 400) {
            return map.get(400) + convertRoman(number - 400);
        }else if (number >= 100) {
            return map.get(100) + convertRoman(number - 100);
        }else if (number >= 90) {
            return map.get(90) + convertRoman(number - 90);
        }else if (number >= 50) {
            return map.get(50) + convertRoman(number - 50);
        }else if (number >= 40) {
            return map.get(40) + convertRoman(number - 40);
        }else if (number >= 10) {
            return map.get(10) + convertRoman(number - 10);
        } else {
            return map.get(number);
        }
    }
}
