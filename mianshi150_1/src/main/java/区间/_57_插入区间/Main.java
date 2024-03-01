package 区间._57_插入区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
}

// 解题思路: 先将新的区间插入到要计算的区间列表, 然后根据区间起点大小对所要计算的区间列表升序排序, 最后进行区间合并就行了
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        ArrayList<int[]> intervals2 = new ArrayList<>();
        for (int[] interval : intervals) {
            intervals2.add(interval);
        }

        intervals2.add(newInterval);
        intervals = intervals2.toArray(new int[intervals2.size()][]);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = res.get(res.size() - 1);

            if (last[1] >= cur[0]) {
                last[1] = Math.max(cur[1], last[1]);
            } else {
                res.add(cur);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}