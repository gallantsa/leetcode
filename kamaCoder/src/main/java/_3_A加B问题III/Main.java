package _3_A加B问题III;

import java.util.Scanner;

// 以0作为结束输入标记
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(a + b);
        }
    }
}
