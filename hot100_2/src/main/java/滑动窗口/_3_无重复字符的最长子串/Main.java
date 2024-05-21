package 滑动窗口._3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gallantsa
 * @date 2024年04月10日 9:30
 */
public class Main {
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windows = new HashMap<>();

        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);

            while (windows.get(c) > 1) {
                char cur = s.charAt(l);
                windows.put(cur, windows.get(cur) - 1);
                l++;
            }
            res = Math.max(r - l, res);
        }
        return res;
    }
}