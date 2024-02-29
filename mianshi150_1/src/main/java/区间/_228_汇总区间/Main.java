package 区间._228_汇总区间;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
                list.add(nums[i]);
            }
            lists.add(list);
        }
        for (List<Integer> list : lists) {
            if (list.size() == 1) res.add("" + list.get(0));
            else {
                res.add(list.get(0) + "->" + list.get(list.size() - 1));
            }
        }

        return res;
    }
}