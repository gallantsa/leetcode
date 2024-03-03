package 二叉树._117_填充每个节点的下一个右侧节点指针II;

import 二叉树.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
}

/*
// Definition for a Node.
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
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            Node cur = queue.poll(); // cur为二叉树每一层的第一个节点

            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);

            // 接下来要连线, 一直连到每一层最后一个节点
            for (int i = 1; i < len; i++) {
                Node next = queue.poll();
                if (next.left != null) queue.add(next.left);
                if (next.right != null) queue.add(next.right);

                cur.next = next;
                cur = next;
            }
        }
        return root;
    }
}