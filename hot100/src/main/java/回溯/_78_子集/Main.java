package 回溯._78_子集;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}