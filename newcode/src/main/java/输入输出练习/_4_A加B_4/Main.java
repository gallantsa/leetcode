package 输入输出练习._4_A加B_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) return;
            int sum = 0;
            while (n-- > 0) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
