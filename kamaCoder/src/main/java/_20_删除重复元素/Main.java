package _20_删除重复元素;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            if (Integer.parseInt(s[0]) == 0) {
                System.out.println("list is empty");
                continue;
            }

            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            for (int i = 1; i < s.length; i++) {
                p.next = new ListNode(Integer.parseInt(s[i]));
                p = p.next;
            }

            p = dummy.next;
            while (p != null) {
                System.out.print(p.val + " ");
                p = p.next;
            }
            System.out.println();

            dummy.next = deduplication(dummy.next);

            p = dummy.next;
            while (p != null) {
                System.out.print(p.val + " ");
                p = p.next;
            }
            System.out.println();
        }
    }

    private static ListNode deduplication(ListNode head) {
        if (head == null) return head;
        ListNode p = head, q = head.next;
        while (q != null) {
            while (q != null && p.val == q.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
            if (q != null) q = q.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode node) {
        this.val = val;
        this.next = node;
    }
}