package 回溯._39_组合总和;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new LinkedList<>(track));
        }

        // 剪枝
        if (target < 0) return;

        // 外层循环横向控制分支的选择
        for (int i = start; i < candidates.length; i++) {
            // 选择分支
            track.addLast(candidates[i]);
            backtrack(candidates, target - candidates[i], i); // start参数用来限制下一层回溯树的分支数
            // 回溯分支, 回到上一层回溯树, 从新选择上一层的分支
            track.removeLast();
        }
    }
}