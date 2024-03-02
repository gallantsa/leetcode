package 链表._92_反转链表II;

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
// 弃用方案: 单链表不能走回头路
//class Solution {
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode p = head, q = head;
//
//        for (int i = 0; i < left - 1; i++) {
//            p = p.next;
//        }
//
//        for (int i = 0; i < right - 1; i++) {
//            q = q.next;
//        }
//
//        for (int i = 0; i < (right - left) / 2; i++) {
//            int temp = p.val;;
//            p.val = q.val;
//            q.val = temp;
//            p = p.next;
//            q = q.next;
//        }
//        return head;
//    }
//}

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
// 递归翻转链表
class Solution {
    ListNode successor = null; // 后驱节点
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // 定义: 翻转前n个节点, 返回新的头结点
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = successor;
        return last;
    }
}