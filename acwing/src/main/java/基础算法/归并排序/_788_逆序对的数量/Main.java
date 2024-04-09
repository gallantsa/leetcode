package 基础算法.归并排序._788_逆序对的数量;

import java.util.Scanner;

/**
 * @author gallantsa
 * @date 2024年04月09日 14:28
 */
public class Main {
    static int[] tmp;
    static int[] q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        q = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        int res = mergeSort(0, n - 1);
        System.out.println(res);
    }

    private static int mergeSort(int l, int r) {
        if (l == r) return 0;
        int mid = (l + r) >> 1;
        int res = mergeSort(l, mid) + mergeSort(mid + 1, r);

        // 归并
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) tmp[k++] = q[i++];
            else {
                tmp[k++] = q[j++];
                // 若 a[i] > a[j]，则a[i] 和它后面的元素都大于 a[j]，a[i] 构成逆序对数量
                res += mid - i + 1;
            }
        }

        while (i <= mid) tmp[k++] = q[i++];;
        while (j <= r) tmp[k++] = q[j++];

        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[j];
        }
        return res;
    }
}
