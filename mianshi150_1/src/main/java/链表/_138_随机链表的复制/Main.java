package 链表._138_随机链表的复制;


import 链表.Node;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // hash表建立节点一一映射
        Map<Node, Node> resMap = new HashMap<>();

        // 第一遍遍历拷贝所有节点
        for (Node p = head; p != null; p = p.next) {
            resMap.put(p, new Node(p.val));
        }

        // 第二遍遍历构建链表结构
        for (Node p = head; p != null; p = p.next) {
            if (p.next != null) {
                resMap.get(p).next = resMap.get(p.next);
            }
            if (p.random != null) {
                resMap.get(p).random = resMap.get(p.random);
            }
        }
        return resMap.get(head);
    }
}