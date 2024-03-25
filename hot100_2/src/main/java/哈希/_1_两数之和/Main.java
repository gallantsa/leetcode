package 哈希._1_两数之和;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历一次即可
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) return new int[]{map.get(num), i};
            map.put(nums[i], i);
        }
        return null;
    }
}