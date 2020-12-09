package com.bupt.signin;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode860:柠檬水找零
 * @author Administrator
 */
public class signIn1210 {
    public static boolean lemonadeChange(int[] bills) {
        if (bills.length == 0 || bills == null){
            return true;
        }
        if (bills[0] != 5){
            return false;
        }
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5){
                sum += 5;
                map.put(bills[i],map.getOrDefault(bills[i],0) + 1);
            }else if (bills[i] == 10){
                if (map.containsKey(5) && map.get(5) > 0){
                    sum += 5;
                    map.put(bills[i],map.getOrDefault(bills[i],0) + 1);
                    map.put(5,map.getOrDefault(5,0) - 1);
                }else {
                    return false;
                }
            }else if (bills[i] == 20){
                if (sum < 15){
                    return false;
                }else {
                    if (map.containsKey(5) && map.get(5) > 0){
                        if (map.containsKey(10) && map.get(10) > 0){
                            map.put(5,map.getOrDefault(5,0) - 1);
                            map.put(10,map.getOrDefault(10,0) - 1);
                            sum += 5;
                            map.put(bills[i],map.getOrDefault(bills[i],0) + 1);
                        }else{
                            if (map.get(5) >= 3){
                                map.put(5,map.getOrDefault(5,0) - 3);
                                sum += 5;
                                map.put(bills[i],map.getOrDefault(bills[i],0) + 1);
                            }else {
                                return false;
                            }
                        }

                    }else {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,5,5,10,20,20,20};
        lemonadeChange(bills);
    }
}
