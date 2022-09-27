package com.LinkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，
 * 则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @author 东鑫
 */
public class lc146 {

    class LRUCache {
        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node() {
            }

            public Node(int keys, int values) {
                this.key = keys;
                this.value = values;
            }
        }
        private Map<Integer,Node> cache = new HashMap<>();
        private int size;
        private int capacity;
        private Node head,tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null){
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node==null) {
                Node node1 = new Node(key, value);

                cache.put(key, node1);
                addToHead(node1);
                ++size;
                if (size > capacity) {
                    //超出容量
                    Node tail = removeTail();
                    //删除hash表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            }else {
                node.value = value;
                moveToHead(node);
            }
        }
        private void addToHead(Node node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        private void removeNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private void moveToHead(Node node){
            removeNode(node);
            addToHead(node);
        }
        private Node removeTail(){
            Node res = tail.prev;
            removeNode(res);
            return res;
        }

//LinkedHashMap
    }
}

