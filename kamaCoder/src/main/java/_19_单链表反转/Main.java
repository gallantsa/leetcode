package _19_单链表反转;

import java.util.Scanner;

// 多组测试数据，每⾏为n+1个数字， 输出链表或对应的字符串
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            if (Integer.parseInt(s[0]) == 0) {
                System.out.println("list is empty");
                continue;
            }

            // 构造链表
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            for (int i = 1; i < s.length; i++) {
                p.next = new ListNode(Integer.parseInt(s[i]));
                p = p.next;
            }

            // 输出原链表
            p = dummy.next;
            while (p != null) {
                System.out.print(p.val + " ");
                p = p.next;
            }
            System.out.println();

            // 反转链表
            // dummy.next = reverse1(dummy.next); // 爆栈
            dummy.next = reverse(dummy.next);

            // 输出反转后链表
            p = dummy.next;
            while (p != null) {
                System.out.print(p.val + " ");
                p = p.next;
            }
            System.out.println();
        }
    }

    // 爆栈了
    private static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    private static ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = head;

        while (p != null) {
            ListNode node = new ListNode(p.val, dummy.next);
            dummy.next = node;
            p = p.next;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}