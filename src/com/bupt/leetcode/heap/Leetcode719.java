package com.bupt.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode719:找出第k小的距离对
 * @author Administrator
 */

class Node {
    int root;
    int nei;
    Node(int r, int n) {
        root = r;
        nei = n;
    }
}

public class Leetcode719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Node> heap = new PriorityQueue<Node>(nums.length,
                Comparator.<Node> comparingInt(node -> nums[node.nei] - nums[node.root]));
        for (int i = 0; i + 1 < nums.length; ++i) {
            heap.offer(new Node(i, i+1));
        }

        Node node = null;
        for (; k > 0; --k) {
            node = heap.poll();
            if (node.nei + 1 < nums.length) {
                heap.offer(new Node(node.root, node.nei + 1));
            }
        }
        return nums[node.nei] - nums[node.root];
    }
}
