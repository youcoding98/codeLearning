package com.bupt.signin;

/**
 * Leetcode134:加油站
 * @author Administrator
 */
public class signIn1118 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int begin = -1;
        boolean flag = false;
        int oil = 0;
        int next = -1;
        for (begin = 0; begin < gas.length; begin++) {
            oil = gas[begin] - cost[begin];
            if (oil < 0){
                continue;
            }
            if (begin == gas.length - 1){
                next = 0;
            }else{
                next = begin + 1;
            }

            while (begin != next){
                oil = oil + gas[next] - cost[next];
                if (oil < 0){
                    break;
                }
                if (next == gas.length - 1){
                    next = 0;
                }else{
                    next = next + 1;
                }
            }
            if (oil > 0){
                return begin;
            }
        }
        return -1;
    }
}
