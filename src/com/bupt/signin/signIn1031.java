package com.bupt.signin;

import java.util.*;

/**
 * Leetcode381:O(1)时间插入、删除和获取随机元素
 * @author gy
 */
public class signIn1031 {

    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random random;
    /** Initialize your data structure here. */
    public signIn1031() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    //向集合中插入元素val
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains){
            map.put(val,new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !contains;
    }

    //当val存在时，从集合中移除一个val
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }

        Integer index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (map.get(val).size() == 0){
            map.remove(val);
        }
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()){
            list.set(index,lastVal);
            map.get(lastVal).remove(list.size());
            map.get(lastVal).add(index);
        }
        return true;
    }

    //从现有集合中随机获取一个元素
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
