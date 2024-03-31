package 回溯算法._47_全排列II;

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
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
        // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
        for (int i = 0; i < nums.length; i++) {
            // 前一个树枝，使用了nums[i - 1]，也就是说同一树层使用过nums[i - 1]
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            // 如果同一树枝使用了, continue
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            used[i] = false;
            path.removeLast();
        }
    }
}