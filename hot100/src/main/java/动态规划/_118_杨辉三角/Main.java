package 动态规划._118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

// 递归地从第一层开始构造
class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            res.add(firstRow);
            return res;
        }

        List<List<Integer>> res = generate(numRows - 1);

        List<Integer> bottomRow = res.get(res.size() - 1);
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        for (int i = 0; i < bottomRow.size() - 1; i++) {
            newRow.add(bottomRow.get(i) + bottomRow.get(i + 1));
        }
        newRow.add(1);
        res.add(newRow);
        return res;
    }
}

// 再来一遍
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            res.add(firstRow);
            return res;
        }

        List<List<Integer>> res = generate(numRows - 1);

        List<Integer> bottomRow = res.get(res.size() - 1);
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        for (int i = 0; i < bottomRow.size() - 1; i++) {
            newRow.add(bottomRow.get(i) + bottomRow.get(i + 1));
        }
        newRow.add(1);
        res.add(newRow);
        return res;
    }
}