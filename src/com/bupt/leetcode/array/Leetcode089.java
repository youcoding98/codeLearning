package com.bupt.leetcode.array;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode089:格雷编码
 * @author gy
 */
public class Leetcode089 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if(n == 0){
            return result;
        }
        int head = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = result.size() - 1; j >= 0 ; j--) {
                result.add(head + result.get(j));
            }
            head = head << 1;
        }
        return result;
    }
}
