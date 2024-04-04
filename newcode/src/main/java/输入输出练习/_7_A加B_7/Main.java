package 输入输出练习._7_A加B_7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            int sum = 0;
            for (String string : s) {
                sum += Integer.parseInt(string);
            }
            System.out.println(sum);
        }
    }
}
