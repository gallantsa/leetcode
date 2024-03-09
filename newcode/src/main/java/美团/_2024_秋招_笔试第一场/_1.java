package 美团._2024_秋招_笔试第一场;

import java.util.Scanner;

public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double sum1 = 0;
        double sum2 = 0;
        while (n > 0) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            if (b <= 0|| b > a) {
                System.out.println("error");
                return;
            }
            sum1 += a;
            sum2 += b;
            n --;
        }
        double x = sc.nextInt();
        double y = sc.nextDouble();
        if (y > x || y <= 0) {
            System.out.println("error");
            return;
        }
        if (sum1 > x) sum1 -= y;
        if (sum1 > sum2) System.out.printf("%.2f", sum2);
        else System.out.printf("%.2f", sum1);
    }
}
