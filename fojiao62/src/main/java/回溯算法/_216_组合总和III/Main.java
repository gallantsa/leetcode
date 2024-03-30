package 回溯算法._216_组合总和III;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(n, k, 1, 0);
        return res;
    }

    private void backtrack(int targetSum, int k, int startIndex, int sum) {
        if (path.size() == k) {
            if (sum == targetSum) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (sum > targetSum) {
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(targetSum, k, i + 1, sum + i);
            path.removeLast();
        }
    }
}