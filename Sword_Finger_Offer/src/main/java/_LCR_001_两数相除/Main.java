package _LCR_001_两数相除;

public class Main {
}

// 第一题就被薄纱了
class Solution {
    public int divide(int a, int b) {
        if (b == 1) {
            return a;
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (a > 0 && b > 0) || (a < 0 && b < 0);
        a = a > 0 ? -a : a;
        b = b > 0 ? -b : b;
        int ans = 0;
        while (a <= b) {
            // x 为 b 的倍数
            int x = b;
            // cnt 为倍数的个数
            int cnt = 1;
            // x >= (Integer.MIN_VALUE >> 1)：这部分判断条件是为了避免溢出。
            // 判断当前的被除数a是否还可以继续减去除数的倍数x
            while (x >= (Integer.MIN_VALUE >> 1) && a <= (x << 1)) {
                x <<= 1;
                cnt <<= 1;
            }
            ans += cnt;
            a -= x;
        }
        return sign ? ans : -ans;
    }
}