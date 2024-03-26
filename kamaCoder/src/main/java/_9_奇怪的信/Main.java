package _9_奇怪的信;

import java.util.Scanner;

// 多组测试数据，每组数据只有⼀个整数，对于每组输⼊数据，输出⼀⾏，每组数据下⽅有⼀个空⾏
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            while (n > 0) {
                int tmp = n % 10;
                if (tmp % 2 == 0) sum += tmp;
                n /= 10;
            }
            System.out.println(sum);
            System.out.println();
        }
    }
}
