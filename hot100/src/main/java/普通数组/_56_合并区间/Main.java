package 普通数组._56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] cur = intervals[i];
            if (cur[0] <= last[1]) last[1] = Math.max(last[1], cur[1]); // 注意这里cur[1]可能比last[1]小
            else res.add(cur);
        }
        return res.toArray(new int[res.size()][]);
    }
}