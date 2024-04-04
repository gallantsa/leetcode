package 输入输出练习._11_自测本地通过提交为0;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            Long sum = 0L;
            for (String string : s) {
                sum += Long.parseLong(string);
            }
            System.out.println(sum);
        }
    }
}
