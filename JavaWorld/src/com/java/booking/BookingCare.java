package com.java.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by skyne on 12/1/2019.
 */
public class BookingCare {

    public static void main(String... args) {
        List<Integer> one = new ArrayList<>();
        one.add(1 );
        one.add(50);
        one.add(65);

        List<Integer> two = new ArrayList<>();
        two.add(1 );
        two.add(70);
        two.add(90);

        List<Integer> three = new ArrayList<>();
        three.add(1 );
        three.add(100);
        three.add(120);

        List<Integer> four = new ArrayList<>();
        four.add(2);
        four.add(100);
        four.add(120);

        List<Integer> five = new ArrayList<>();
        five.add(3 );
        five.add(100);
        five.add(120);

        List<Integer> six = new ArrayList<>();
        six.add(3 );
        six.add(125);
        six.add(130);


        List<List<Integer>> first = new ArrayList<>();
        first.add(one);
        first.add(two);
        first.add(three);
        first.add(four);
        first.add(five);
        first.add(six);

        System.out.println(employeeWithLesserThanKBreaks(first, 2));

    }

    public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
        // Write your code here
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> lastCall = new HashMap<>();
        Map<Integer, Integer> breakCount = new HashMap<>();
        for (List<Integer> lst : employeeCalls) {
            if(lst.size() == 3) {
                Integer id = lst.get(0);
                if(lastCall.get(id) == null) {
                    breakCount.put(id, 0);
                } else {
                    Integer lastCallTime = lastCall.get(id);
                    if (lastCallTime < lst.get(1)) {
                        breakCount.put(id, breakCount.get(id) + 1);
                    }
                }

                lastCall.put(id, lst.get(2));
            }
        }

        breakCount.forEach((key, value) -> {
            if (value < k) {
                List<Integer> employee = new ArrayList<>();
                employee.add(key);
                employee.add(value);
                ret.add(employee);
            }
        });

        return ret;
    }
}
