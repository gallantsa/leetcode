package 数组_字符串._58_最后一个单词的长度;

public class Main {
}

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }
}