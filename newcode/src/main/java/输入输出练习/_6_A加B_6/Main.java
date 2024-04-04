package 输入输出练习._6_A加B_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            while (n-- > 0) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
