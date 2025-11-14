package com.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author 东鑫
 */
public class lc1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        String s = null;
        for (List li : paths) {
            set.add(String.valueOf(li.get(0)));
            set.add(String.valueOf(li.get(1)));
            list.add(String.valueOf(li.get(0)));
        }
        for (String a:set){
            if (!list.contains(a)){
                s = a;
            }
        }

//        List<String> list2 = list1.stream().filter(t -> !list.contains(t)).collect(toList());
        return s;
    }

    public static void main(String[] args) {
        List<List<String>> lists  = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("B");
        list.add("C");
        List<String> list1 = new ArrayList<>();
        list1.add("D");
        list1.add("B");
        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("A");
        lists.add(list);
        lists.add(list1);
        lists.add(list2);
        String s = new lc1436().destCity(lists);
        System.out.println(s);
    }
}
