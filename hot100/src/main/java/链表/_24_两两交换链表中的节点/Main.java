package 链表._24_两两交换链表中的节点;

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
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode others = head.next.next;

        // 先把前两个元素翻转
        second.next = first;
        // 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first.next = swapPairs(others);
        // 现在整个链表都成功翻转了，返回新的头结点
        return second;
    }
}