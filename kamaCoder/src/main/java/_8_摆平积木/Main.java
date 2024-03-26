package _8_摆平积木;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int temp = n;
            if (n == 0) break;
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            while (n-- > 0) {
                int num = sc.nextInt();
                list.add(num);
                sum += num;
            }
            int avg = sum / temp;
            int res = 0;
            for (int m : list) {
                if (m < avg) res += avg - m;
            }
            System.out.println(res);
            System.out.println();
        }
    }
}
