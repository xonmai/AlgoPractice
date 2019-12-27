package com.java.booking;

import java.util.*;


public class ListReservation {

    public static void main(String... args) {
        List<Integer> one = new ArrayList<>();
        one.add(1234 );
        one.add(532632);

        List<Integer> two = new ArrayList<>();
        two.add(234 );
        two.add(632633);

        List<Integer> three = new ArrayList<>();
        two.add(456 );
        two.add(632639);

        List<List<Integer>> first = new ArrayList<>();
        first.add(one);
        first.add(two);

        List<List<Integer>> second = new ArrayList<>();
        second.add(one);
        second.add(two);
        second.add(three);


        System.out.println(missingReservations(first, second));

    }

    public static List<Integer> missingReservations(List<List<Integer>> firstReservationList, List<List<Integer>> secondReservationList) {
        // Write your code here
        LinkedHashSet<Integer> ret = new LinkedHashSet<>();
        Map<Integer, Integer> firstMap = new HashMap<>();
        for(List<Integer> lst : firstReservationList) {
            if(lst.size() > 0) {
                firstMap.put(lst.get(0), lst.get(1));
            }
        }

        for(List<Integer> lst : secondReservationList) {
            if(lst.size() > 0) {
                if(firstMap.get(lst.get(0)) == null) {
                    ret.add(lst.get(0));
                }
            }
        }

        return new ArrayList<>(ret);
    }
}
