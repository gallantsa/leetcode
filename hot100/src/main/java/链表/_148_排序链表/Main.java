package 链表._148_排序链表;

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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        // 当head.next==null时 说明当前链表只有一个元素 无序再排序, 且fast是从head.next开始的
        if (head == null || head.next == null) return head;

        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(next);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (left != null && right != null) {
            if (left.val > right.val) {
                p.next = right;
                right = right.next;
            } else {
                p.next = left;
                left = left.next;
            }
            p = p.next;
        }
        if (left != null) {
            p.next = left;
        }
        if (right != null) {
            p.next = right;
        }
        return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        // 这里fast必须从head.next开始, 如果只有两个节点, fast从head开始, slow会直接到最后一个节点, 上面的mergeSort会报空指针异常
        ListNode slow = head, fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // 快慢指针的作用是找到链表的中间节点，以便将链表分成两部分进行归并排序。当链表节点个数为偶数时，如果快指针从 head 开始移动，最终慢指针会指向中间两个节点的前一个节点。这样做的好处是，在归并排序中，我们需要将链表分成两部分，左边部分以中间节点的前一个节点结束，右边部分以中间节点结束。这样可以确保左右两部分的长度差不超过 1，便于后续的归并操作。
}