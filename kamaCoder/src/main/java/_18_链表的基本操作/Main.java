package _18_链表的基本操作;

import java.util.LinkedList;
import java.util.Scanner;

// ⼀组输⼊数据，第⼀⾏为n+1个整数，逆序插⼊n个整数，第⼆⾏为⼀个整数m, 接下来有m⾏字符串，并根据字符串内容输⼊不同个数的数据
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        while (n-- > 0) {
            list.addFirst(sc.nextInt());
        }
        int m = sc.nextInt();
        sc.nextLine();
        while (m-- > 0) {
            String[] s = sc.nextLine().split(" ");
            switch (s[0]) {
                case "show" -> {
                    if (list.isEmpty()) {
                        System.out.print("Link list is empty");
                        break;
                    }
                    for (Integer num : list) {
                        System.out.print(num + " ");
                    }
                }
                case "get" -> {
                    int index = Integer.parseInt(s[1]) - 1;
                    if (index < 0 || index >= list.size()) {
                        System.out.print("get fail");
                    } else {
                        System.out.print(list.get(index));
                    }
                }
                case "delete" -> {
                    int index = Integer.parseInt(s[1]) - 1;
                    if (index < 0 || index >= list.size()) {
                        System.out.print("delete fail");
                    } else {
                        list.remove(index);
                        System.out.print("delete OK");
                    }
                }
                case "insert" -> {
                    int index = Integer.parseInt(s[1]) - 1;
                    if (index < 0 || index > list.size()) {
                        System.out.print("insert fail");
                    } else {
                        list.add(index, Integer.parseInt(s[2]));
                        System.out.print("insert OK");
                    }
                }

            }
            System.out.println();
        }
    }
}
