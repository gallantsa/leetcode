package 数组_字符串._274_H指数;

public class Main {
}

// 我们需要找到满足条件「引用次数至少为 x 次的 x 篇论文」中的最大 x 值
// 满足二段性
// 少于等于 x 的数值必然满足条件；
// 大于 x 的数值必然不满足。
// 因此我们可以通过二分在 [0,n) 范围内找分割点 xxx。
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        // [l, r)
        int l = 0, r = n;
        while (l < r) {
            // r初始化为n, mid = .. + 1 >> 1 使得解趋于区间右侧
            int mid = l + r + 1 >> 1;
            // 通过移动l来逼近解, 不会漏解
            if (check(citations, mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    private boolean check(int[] citations, int mid) {
        int ans = 0;
        for (int citation : citations) {
            if (citation >= mid) ans ++;
        }
        return ans >= mid;
    }
}