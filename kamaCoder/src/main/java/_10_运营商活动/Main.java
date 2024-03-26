package _10_运营商活动;

import java.util.Scanner;

// 多组测试数据，每个测试实例包括2个整数M，K（2<=k<=M<=1000)。M=0，K=0代表输⼊结束
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int k = sc.nextInt();
            if (m == 0 && k == 0) return;
            int day = m;
            while (m >= k) {
                int keep = m / k;
                day += keep;
                m = keep + m % k;
            }
            System.out.println(day);
        }
    }
}
