package 链表._2_两数相加;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        int flag = 0;
        int num;
        while (l1 != null && l2 != null) {
            num = l1.val + l2.val + flag;
            flag = 0;
            if (num >= 10) {
                num %= 10;
                flag = 1;
            }
            p.next = new ListNode(num);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            num = flag + l1.val;
            flag = 0;
            if (num >= 10) {
                num %= 10;
                flag = 1;
            }
            p.next = new ListNode(num);
            p = p.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            num = flag + l2.val;
            flag = 0;
            if (num >= 10) {
                num %= 10;
                flag = 1;
            }
            p.next = new ListNode(num);
            p = p.next;
            l2 = l2.next;
        }

        if (flag == 1) p.next = new ListNode(1);

        return dummy.next;
    }
}