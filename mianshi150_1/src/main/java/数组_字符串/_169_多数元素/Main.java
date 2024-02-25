package 数组_字符串._169_多数元素;

import java.util.Collections;
import java.util.HashMap;

public class Main {
}

// 哈希表解法
class Solution1 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计每个元素出现的个数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 找出出现次数最多的元素, 并返回
        int max = Collections.max(map.values());
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                return key;
            }
        }
        return -1;
    }
}

// 数组
class Solution {
    public int majorityElement(int[] nums) {
        // 寻找的目标值
        int target = 0;
        // 电性判断
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果电性为中性, 设置为当前元素电性
            if (count == 0) {
                target = nums[i];
                count = 1;
            // 如果当前元素电性和目标电性相同, 电性强度加一
            } else if (target == nums[i]) {
                count ++;
            } else {
                count --;
            }
        }
        // 返回最终电性
        return target;
    }
}
