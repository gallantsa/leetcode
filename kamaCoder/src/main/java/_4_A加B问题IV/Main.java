package _4_A加B问题IV;

import java.util.Scanner;

// 若干行输入, 遇0停止, 每行第一个数为n, 表示本行后面有N个数
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;

            int sum = 0;
            while (n-- > 0) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
