package com.bupt.jianzhioffer;

/**
 * Offer036:二叉搜索树与双向链表
 * @author Administrator
 */

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};


public class Offer036 {
    Node head,pre;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    public void dfs(Node cur){
        if (cur == null){
            return;
        }
        dfs(cur.left);

        //pre用于记录双向链表中位于cur左侧的节点
        if (pre == null){
            head = cur;
        }else {
            pre.right = cur;
        }
        cur.left = pre;

        pre = cur;

        dfs(cur.right);
    }
}
