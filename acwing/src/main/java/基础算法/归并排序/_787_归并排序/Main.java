package 基础算法.归并排序._787_归并排序;

import java.util.Scanner;

/**
 * @author gallantsa
 * @date 2024年04月09日 14:12
 */
public class Main {
    static int[] q;
    static int[] tmp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        q = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        mergeSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(q[i] + " ");
        }
    }

    private static void mergeSort(int l, int r) {
        if (l == r) return;

        int mid = (l + r) >> 1;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] < q[j]) tmp[k++] = q[i++];
            else tmp[k++] = q[j++];
        }

        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];

        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[j];
        }
    }
}
