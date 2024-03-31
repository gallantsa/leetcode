package 回溯算法._78_子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
}

// 子集是收集树形结构中树的所有节点的结果。
// 而组合问题、分割问题是收集树形结构中叶子节点的结果。
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}