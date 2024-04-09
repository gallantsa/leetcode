package 基础算法.快速排序._785_快速排序;

import java.util.Scanner;

/**
 * @author gallantsa
 * @date 2024年04月09日 13:53
 */
public class Main {

    static int[] q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        quickSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(q[i] + " ");
        }
    }

    private static void quickSort(int l, int r) {
        if (l == r) return;
        int x = q[(l + r) >> 1];
        int i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSort(l, j);
        quickSort(j + 1, r);
    }
}
