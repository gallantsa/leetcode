package 双指针._125_验证回文串;

public class Main {
}

// 学习正则表达式
class Solution {
    public boolean isPalindrome(String s) {
        // [^\\p{Alnum}] 表示匹配所有不是字母或数字的字符。
        // \\W 是一个正则表达式，用于匹配所有非单词字符。在Java中，单词字符是指所有字母、数字和下划线。所以，\\W 就是匹配所有不是字母、数字和下划线的字符。
        s = s.replaceAll("[^\\p{Alnum}]", "").toLowerCase();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}