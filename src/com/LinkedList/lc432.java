package com.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。
 * 实现 AllOne 类：
 * AllOne() 初始化数据结构的对象。
 * inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key
 * 那么插入计数为 1 的 key 。
 * dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0
 * 那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中。
 * getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。
 *
 * @author 东鑫
 */
public class lc432 {
    class AllOne {
        public Map<String, Integer> map = null;

        public AllOne() {
            map = new HashMap<>();
        }

        public void inc(String key) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        public void dec(String key) {
            if (map.get(key) > 1) {
                map.put(key, map.get(key) - 1);
            } else if (map.get(key)==1){
                map.remove(key);
            }
        }

        public String getMaxKey() {

            int max = Integer.MIN_VALUE;
            for (String key : map.keySet()) {
               max = Math.max(max,map.get(key));
            }
            for (String key : map.keySet()) {
                if (map.get(key)==max){
                    return key;
                }
            }
            return "null";
        }

        public String getMinKey() {
            int min = Integer.MAX_VALUE;
            for (String key : map.keySet()) {
                min = Math.min(min,map.get(key));
            }
            for (String key : map.keySet()) {
                if (map.get(key)==min){
                    return key;
                }
            }
            return "null";
        }
    }
    public void is(){
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMinKey()); // 返回 "leet"
        allOne.dec("a");
        System.out.println(allOne.getMaxKey()); // 返回 "leet"
        System.out.println(allOne.getMinKey()); // 返回 "leet"
    }
    public static void main(String[] args) {
        new lc432().is();
    }

}
