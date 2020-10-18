package com.bupt.signin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode116：填充每个节点的下一个右侧节点指针
 * @author Administrator
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


public class signIn1015 {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node nodeTemp = queue.poll();
                if (i < size - 1){
                    nodeTemp.next = queue.peek();
                }
                if (nodeTemp.left != null){
                    queue.add(nodeTemp.left);
                }
                if (nodeTemp.right != null){
                    queue.add(nodeTemp.right);
                }
            }
        }
        return root;
    }
}
