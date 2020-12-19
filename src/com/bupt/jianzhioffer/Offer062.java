package com.bupt.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Offer062:圆圈中最后剩下的数字
 * @author Administrator
 */
public class Offer062 {
    public static int lastRemaining(int n, int m) {
        if (n == 1){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1){
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        lastRemaining(5,3);
    }
}
