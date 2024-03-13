package 堆._215_数组中的第K个最大元素;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> dump = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            dump.add(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            dump.poll();
        }
        return dump.peek();
    }
}