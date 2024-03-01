package 区间._452_用最少数量的箭引爆气球;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
}

// 这题不能用合并区间的想法去做，要让区间尽可能地有重叠的部分，用贪心算法
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        // 至少有一个区间不重叠
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) res++;
            else points[i][1] = Math.min(points[i][1], points[i - 1][1]);
        }
        return res;
    }
}