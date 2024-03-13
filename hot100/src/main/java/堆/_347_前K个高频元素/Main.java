package 堆._347_前K个高频元素;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> dump = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (int num : map.keySet()) {
            dump.add(num);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = dump.poll();
        }
        return res;
    }
}