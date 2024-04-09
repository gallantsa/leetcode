package 基础算法.快速排序._786_第k个数;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gallantsa
 * @date 2024年04月09日 14:08
 */
public class Main {
    static int[] q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        Arrays.sort(q);
        System.out.println(q[k - 1]);
    }
}
