package _5_A加B问题VII;

import java.util.Scanner;

//若⼲⾏输⼊，每⾏包括两个整数a和b，由空格分隔，每⾏输出后接⼀个空⾏。
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
            System.out.println();
        }
    }
}