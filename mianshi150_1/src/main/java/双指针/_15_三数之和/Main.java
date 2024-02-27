package 双指针._15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, -nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    // 定义: 返回数组中和为target的元祖集合
    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int l = start, r = nums.length - 1;
        while (l < r) {
            int num = nums[l] + nums[r];

            if (num < target) {
                l++;
            } else if (num > target) {
                r--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[l]);
                list.add(nums[r]);
                res.add(list);
                // 跳过重复的元素
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                l++;
                r--;
            }
        }
        return res;
    }
}
