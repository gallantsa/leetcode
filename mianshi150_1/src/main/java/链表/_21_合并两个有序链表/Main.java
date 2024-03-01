package 链表._21_合并两个有序链表;

import 链表.ListNode;

import java.util.List;

public class Main {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = list1, q = list2;
        ListNode head = new ListNode(-1);
        ListNode index = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                index.next = new ListNode(p.val);
                p = p.next;
            } else {
                index.next = new ListNode(q.val);
                q = q.next;
            }
            index = index.next;
        }

        while (p != null) {
            index.next = new ListNode(p.val);
            p = p.next;
            index = index.next;
        }
        while (q != null) {
            index.next = new ListNode(q.val);
            q = q.next;
            index = index.next;
        }
        return head.next;
    }
}