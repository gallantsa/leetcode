package 链表._234_回文链表;

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        // 找中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 奇数个节点
        if (fast != null && fast.next == null) {
            slow = slow.next;
        }
        ListNode mid = reserve(slow);
        slow = head;
        while (mid != null) {
            if (slow.val != mid.val) return false;
            slow = slow.next;
            mid = mid.next;
        }
        return true;
    }

    private ListNode reserve(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = reserve(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}