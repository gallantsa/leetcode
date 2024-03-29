package 链表._203_移除链表元素;

import common.ListNode;

public class Main {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy;
        ListNode q = p.next;

        while (q != null) {
            if (q.val == val) {
                p.next = q.next;
            } else {
                p = q;
            }
            q = q.next;
        }
        return dummy.next;
    }
}