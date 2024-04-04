package 输入输出练习._8_字符串排序_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        Arrays.sort(s);
        String join = String.join(" ", s);
        System.out.println(join);
    }
}
