package 滑动窗口._3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int res = 0;

        Map<Character, Integer> windows = new HashMap<>();
        while (right < s.length()) {
            // 获取当前字符
            char c = s.charAt(right);
            // 将当前字符加入到哈希表, 并记录字符出现次数
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            // 扩大窗口
            right ++;

            // 当前字符出现次数大于1, 缩小窗口
            while (windows.get(c) > 1) {
                char d = s.charAt(left);
                left ++;
                windows.put(d, windows.get(d) - 1);
            }
            // 此时窗口中没有重复的字符, 更新最长子串长度
            res = Math.max(res, right - left);
        }
        return res;
    }
}