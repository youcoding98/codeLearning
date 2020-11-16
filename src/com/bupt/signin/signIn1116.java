package com.bupt.signin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode406：根据身高重建队列
 * @author Administrator
 */
public class signIn1116 {
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0){
            return new int[][]{};
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] people1, int[] people2) {
                if (people1[0] == people2[0]){
                    return people1[1] - people2[1];
                }else{
                    return people2[0] - people1[0];
                }
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int[] person: people) {
            list.add(person[1],person);
        }
        return list.toArray(people);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);
    }
}
