package _13_镂空三角形;

import java.util.Scanner;

// 多⾏输⼊，每⾏输⼊为⼀个字符和⼀个整数，遇到特殊字符结束
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("@")) return;
            String[] split = s.split(" ");
            char c = split[0].charAt(0);
            int n = Integer.parseInt(split[1]);

            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                System.out.print(c);
                for (int j = 1; j <= 2 * (i - 1) - 1; j++) {
                    System.out.print(" ");
                }

                if (i != 1) {
                    System.out.print(c);
                }
                System.out.println();
            }
            for (int i = 1; i <= 2 * n - 1; i++) {
                System.out.print(c);
            }
            System.out.println();
            System.out.println();
        }
    }
}
