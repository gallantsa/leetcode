package 基础算法.二分._790_数的三次方根;

import java.util.Scanner;

public class Main {
    private static final double EPS = 1e-8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double target = sc.nextDouble();

        double l = -10001D, r = 10001D;
        // 一般比所求精度高 2
        while (EPS < r - l) {
            double mid = (l + r) / 2;
            if (check(mid) >= target) r = mid;
            else l = mid;
        }
        System.out.printf("%.6f", r);
    }

    private static double check(double mid) {
        return mid * mid * mid;
    }
}
