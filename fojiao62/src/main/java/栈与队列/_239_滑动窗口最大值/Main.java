package 栈与队列._239_滑动窗口最大值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    // 单调队列实现
    // 双链表，支持头部和尾部增删元素
    // 维护其中的元素自尾部到头部单调递增
    class MonotonicQueue {
        LinkedList<Integer> maxQ = new LinkedList<>();

        public void push(int n) {
            while (!maxQ.isEmpty() && maxQ.getLast() < n) {
                maxQ.removeLast();
            }
            maxQ.addLast(n);
        }

        public int max() {
            return maxQ.getFirst();
        }

        public void pop(int n) {
            if (n == maxQ.getFirst()) {
                maxQ.removeFirst();
            }
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满窗口 ,先填入 k - 1 个元素
                window.push(nums[i]);
            } else {
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        // 需要转成 int[] 数组再返回
        int[] resArray = new int[res.size()];
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}