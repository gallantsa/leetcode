package _6_A加B问题VIII;

import java.util.Scanner;

// 多组n⾏数据，每⾏先输⼊⼀个整数N，然后在同⼀⾏内输⼊M个整数,每组输出之间输出⼀个空⾏。
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            while (n -- > 0) {
                int m = sc.nextInt();
                int sum = 0;
                while (m-- > 0) {
                    sum += sc.nextInt();
                }
                System.out.println(sum);
                if (n > 0) System.out.println();
            }
        }
    }
}
