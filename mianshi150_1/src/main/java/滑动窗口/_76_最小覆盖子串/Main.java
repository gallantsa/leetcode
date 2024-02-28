package 滑动窗口._76_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("aa", "aa"));
    }
}

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> countS = new HashMap<>();

        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        // 符合要求的字母
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            // 扩大窗口
            right++;

            // 如果目标串中包含该字母并且数目和滑动窗口中的数量一样, valid++
            if (countT.containsKey(c)) {
                countS.put(c, countS.getOrDefault(c, 0) + 1);
                if (countT.get(c).equals(countS.get(c)))
                    valid++;
            }

            // 所有字母满足开始缩小窗口
            while (valid == countT.size()) {
                // 更新最小覆盖子串长度, 以及子串开始下标
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }

                // 缩小窗口
                char ch = s.charAt(left);
                left ++;

                // 如果目标串包含该字母并且该字母数量和滑动窗口中的数量一致, valid--
                if (countT.containsKey(ch)) {
                    if (countT.get(ch).equals(countS.get(ch)))
                        valid--;
                    countS.put(ch, countS.get(ch) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}