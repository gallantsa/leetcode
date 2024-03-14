package 动态规划._139_单词拆分;

import java.util.Arrays;
import java.util.List;

public class Main {
}

// 超时
class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s, 0, wordDict);
    }

    private boolean dp(String s, int i, List<String> wordDict) {
        if (i == s.length()) {
            return true;
        }
        // 遍历所有单词，尝试匹配 s[i..] 的前缀
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) {
                continue;
            }
            String subStr = s.substring(i, i + len);
            if (subStr.equals(word)) {
                // s[i..] 的前缀被匹配，去尝试拼出 s[i+len..]
                if (dp(s, i + len, wordDict)) {
                    // s[i..] 可以被拼出
                    return true;
                }
            }
        }
        // s[i..] 无法被拼出
        return false;
    }
}


// 备忘录
class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0, wordDict);
    }

    private boolean dp(String s, int i, List<String> wordDict) {
        // 如果拼完直接返回true
        if (i == s.length()) {
            return true;
        }

        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 1;
        }

        // 遍历所有单词尝试匹配s的前缀
        for (String word : wordDict) {
            int len = word.length();
            // 如果长度超出, 进入下一轮
            if (i + len > s.length()) {
                continue;
            }
            // 获取s的前缀
            String substring = s.substring(i, i + len);
            // 前缀不相等, 进入下一轮
            if (!substring.equals(word)) {
                continue;
            }
            // 前缀想等后, 递归地判断s前缀后的字符串, 是否能被拼出来, 如果能备忘录记录下来
            if (dp(s, i + len, wordDict)) {
                memo[i] = 1;
                return true;
            }
        }
        // 不能匹配, 备忘录记录下来, 返回false
        memo[i] = 0;
        return false;
    }
}