package com.bupt.winterholiday;

import java.util.*;

/**
 * Leetcode146:LRU缓存机制
 * @author gy
 */
public class LRUCache {
    /**
     * 双向链表
     */
    class DoubleLinkedNode{
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        public DoubleLinkedNode(){}
        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Map<Integer,DoubleLinkedNode> cache = new HashMap<>();
    private DoubleLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        //使用伪头部和伪尾部节点
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        //如果key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        //如果key不存在，创建一个新的节点
        if(node == null){
            DoubleLinkedNode newNode = new DoubleLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            size++;
            if(size > capacity){
                DoubleLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }else{
           //如果key存在，先通过哈希表定位，再修改value,最后移到头部
           node.value = value;
           moveToHead(node);
        }
    }

    private void addToHead(DoubleLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoubleLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DoubleLinkedNode removeTail(){
        DoubleLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
