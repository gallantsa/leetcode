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

// 深拷贝, 当前链表的节点地址做key, 创建新的节点
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        for (Node p = head; p != null; p = p.next) {
            map.put(p, new Node(p.val));
        }

        for (Node p = head; p != null; p = p.next) {
            if (p.next != null) {
                map.get(p).next = map.get(p.next);
            }

            if (p.random != null) {
                map.get(p).random = map.get(p.random);
            }
        }
        return map.get(head);
    }
}