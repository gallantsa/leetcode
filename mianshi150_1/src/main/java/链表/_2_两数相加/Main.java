package 链表._2_两数相加;

import 链表.ListNode;

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
// 卡示例了, 过
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;

        int num1 = 0;
        int i = 0;
        while (p != null) {
            num1 += Math.pow(10, i) * p.val;
            i++;
            p = p.next;
        }
        p = l2;
        i = 0;
        while (p != null) {
            num1 += Math.pow(10, i) * p.val;
            i++;
            p = p.next;
        }
        if (num1 == 0) return new ListNode(0);
        ListNode res = new ListNode(-1);
        p = res;
        while (num1 != 0) {
            p.next = new ListNode((int) (num1 % 10));
            p = p.next;
            num1 /= 10;
        }
        return res.next;
    }
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode head = new ListNode(-1);
        ListNode o = head;
        int num;
        int flag = 0;
        // 如果p和q都不为空计算, 注意进位用flag表示
        while (p != null && q != null) {
            num = p.val + q.val + flag;
            if (num >= 10) {
                o.next = new ListNode(num % 10);
                flag = 1;
            } else {
                o.next = new ListNode(num);
                flag = 0;
            }
            o = o.next;
            p = p.next;
            q = q.next;
        }

        // 计算l1或l2没有计算完的数
        while (p != null) {
            num = p.val + flag;
            if (num >= 10) {
                o.next = new ListNode(num % 10);
                flag = 1;
            } else {
                o.next = new ListNode(num);
                flag = 0;
            }
            o = o.next;
            p = p.next;
        }
        while (q != null) {
            num = q.val + flag;
            if (num >= 10) {
                o.next = new ListNode(num % 10);
                flag = 1;
            } else {
                o.next = new ListNode(num);
                flag = 0;
            }
            o = o.next;
            q = q.next;
        }
        // 最后看看flag是不是还有进位
        if (flag == 1) {
            o.next = new ListNode(1);
        }
        return head.next;
    }
}