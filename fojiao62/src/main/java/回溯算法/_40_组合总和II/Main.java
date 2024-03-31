package 回溯算法._40_组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int startIndex, int sum) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            path.add(candidates[i]);
            used[i] = true;
            // 和39.组合总和的区别1：这里是i+1，每个数字在每个组合中只能使用一次
            backtrack(candidates, target, i + 1, sum + candidates[i]);
            used[i] = false;
            path.removeLast();
        }
    }
}