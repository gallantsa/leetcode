package 链表._19_删除链表的倒数第N个结点;

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
// 解题思路: (为了方便删除节点创建虚拟头结点) 先让p走n步, 之后p和q一起走, p走到头(这里的头指的是null节点), q正好走到倒数第n个节点的位置(注意头结点也可能被删除, 这时又体现了虚拟头结点的好处了)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy, q = dummy;
        while (n != 0) {
            p = p.next;
            n--;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return dummy.next;
    }
}