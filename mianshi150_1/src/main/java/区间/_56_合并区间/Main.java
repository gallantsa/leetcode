package 区间._56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
}

class Solution {
    public int[][] merge(int[][] intervals) {
        // 先根据区间左侧的数升序排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // 获得当前区间
            int[] cur = intervals[i];

            // 获得结果中的最后一个区间
            int[] last = res.get(res.size() - 1);
            // 如果最后一个区间的右值大于等于当前区间的左值, 说明两个区间有相交的部分, 可以合并, 更新最后一个区间的右值
            if (last[1] >= cur[0]) {
                last[1] = Math.max(cur[1], last[1]);
            } else {
                res.add(cur);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}