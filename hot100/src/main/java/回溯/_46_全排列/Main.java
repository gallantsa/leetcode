package 回溯._46_全排列;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));// 这里需要添加track的副本, 因为直接添加track实际是添加track的引用, 如果后续track更改, 集合中保存的track也会跟着更改
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            track.addLast(nums[i]);
            used[i] = true;
            backtrack(nums);
            used[i] = false;
            track.removeLast();
        }
    }
}