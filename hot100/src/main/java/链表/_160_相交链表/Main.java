package 链表._160_相交链表;

import 链表.ListNode;

public class Main {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;

        while (p != q) {
            if (p != null) p = p.next;
            else p = headB;
            if (q != null) q = q.next;
            else q = headA;
        }
        return p; // 这里直接返回p, 如果有交点就不为null, 否则都到达了链表的结尾null
    }
}