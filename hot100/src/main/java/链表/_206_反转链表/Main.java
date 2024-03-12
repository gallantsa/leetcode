package 链表._206_反转链表;

import 链表.ListNode;

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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;// 这里一定要先判断head == null不然后面的可能空指针异常

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}