package _12_打印数字图形;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print(j);
                }
                for (int j = i - 1; j >= 1; j--) {
                    System.out.print(j);
                }
                System.out.println();
            }
            for (int i = 1; i <= n - 1; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(j);
                }
                for (int j = n - i - 1; j >= 1; j--) {
                    System.out.print(j);
                }
                System.out.println();
            }
        }
    }
}