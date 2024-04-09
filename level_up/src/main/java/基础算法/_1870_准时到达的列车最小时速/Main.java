package 基础算法._1870_准时到达的列车最小时速;

/**
 * @author gallantsa
 * @date 2024年04月09日 10:28
 */
public class Main {
}

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = -1, r = (int)(1e7 + 1);
        while (l + 1 != r) {
            int mid = (l + r) >> 1;
            // 找到第一个能准时到达的时速
            if (check(dist, mid, hour)) r = mid;
            else l = mid;
        }
        return r == (int)(1e7 + 1) ? -1 : r;
    }

    private boolean check(int[] dist, int speed, double hour) {
        double res = 0;
        for (int i = 0; i < dist.length; i++) {
            double cost = dist[i] * 1.0 / speed;
            res += i == dist.length - 1 ? cost : Math.ceil(cost);
        }
        return res <= hour;
    }
}