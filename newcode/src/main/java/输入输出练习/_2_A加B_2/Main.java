package 输入输出练习._2_A加B_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();;
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}
