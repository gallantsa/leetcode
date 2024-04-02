package 基础算法.二分._789_数的范围;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        while (q-- > 0) {
            int target = sc.nextInt();
            int l = -1, r = n;
            while (l + 1 != r) {
                int mid = (l + r) >> 1;
                if (arr[mid] >= target) r = mid;
                else l = mid;
            }

            if (r == n || arr[r] != target) System.out.println("-1 -1");
            else {
                System.out.print(r + " ");
                int ll = -1, rr = n;
                while (ll + 1 != rr) {
                    int mid = (ll + rr) >> 1;
                    if (arr[mid] <= target) ll = mid;
                    else rr = mid;
                }
                System.out.println(ll);
            }
        }
    }
}
