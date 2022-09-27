package com.shuzu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class lc599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        Map<Integer, String> m3 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            l1.add(list1[i]);
            m1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            l2.add(list2[i]);
            m2.put(list2[i], i);
        }
        List<String> l3 = l1.stream().filter(item -> l2.contains(item)).collect(toList());
        int i = 0;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < l3.size(); j++) {
            int m = m1.get(l3.get(j)) + m2.get(l3.get(j));

            min = Math.min(min, m1.get(l3.get(j)) + m2.get(l3.get(j)));
            m3.put(m, l3.get(j));
        }

        String[] s = {m3.get(min)};
        return s;
    }

    public static void main(String[] args) {
        String[] list = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] restaurant = new lc599().findRestaurant(list, list2);
        for (String s : restaurant) {
            System.out.println(s);
        }
    }
}
