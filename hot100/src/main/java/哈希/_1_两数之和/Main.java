package 哈希._1_两数之和;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // 如果存在target - nums[i], 且target - nums[i]的下标不和当前元素下标相同, 获得目标
            if (hashMap.containsKey(target - nums[i]) && hashMap.get(target - nums[i]) != i) {
                res[0] = i;
                res[1] = hashMap.get(target - nums[i]);
                return res;
            }
        }
        return res;
    }
}
