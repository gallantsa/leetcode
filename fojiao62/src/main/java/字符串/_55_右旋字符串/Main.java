package 字符串._55_右旋字符串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(str.substring(str.length() - n) + str.substring(0, str.length() - n));
    }
}
