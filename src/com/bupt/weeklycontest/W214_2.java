package com.bupt.weeklycontest;

import javafx.scene.effect.SepiaTone;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class W214_2 {
    public static int minDeletions(String s) {
        if (s == null || s.length() == 0 || s.length() == 1){
            return 0;
        }
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            array[c - 'a']++;
        }
        Arrays.sort(array);
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > 0){
                if (set.contains(array[i])){
                    while (array[i] > 0 && set.contains(array[i])){
                        array[i]--;
                        count++;
                    }
                    if (array[i] > 0){
                        set.add(array[i]);
                    }
                }else {
                    set.add(array[i]);
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("ceabaacb"));
    }
}
