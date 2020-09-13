package com.bupt.weeklycontest;

import java.util.HashMap;

/**
 * 周赛206_2:统计不开心的朋友
 * @author Administrator
 */
public class W206_2 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        if (n == 2){
            return 0;
        }
        int result = 0;
        int pLen = n / 2;
        HashMap<Integer,Integer>[] maps =new HashMap[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < n-1; j++) {
                maps[i].put(preferences[i][j],j);
            }
        }

        for (int i = 0; i < pLen; i++) {
            for (int j = 0; j < 2; j++) {
                int x = 0, y = 0, u = 0 ,v = 0;
                x = pairs[i][j];
                if (j == 0){
                    y = pairs[i][1];
                }else {
                    y = pairs[i][0];
                }
                for (int k = 0; k < pLen; k++) {
                    if (k != i){
                        u = pairs[k][j];
                        if (j == 0){
                            v = pairs[k][1];
                        }else {
                            v = pairs[k][0];
                        }
                        if (maps[x].get(u) < maps[x].get(y) && maps[u].get(x) < maps[u].get(v)){
                            result++;
                            break;
                        }
                        int temp = u;
                        u = v;
                        v = temp;
                        if (maps[x].get(u) < maps[x].get(y) && maps[u].get(x) < maps[u].get(v)){
                            result++;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
