package 双指针._392_判断子序列;

public class Main {
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int i = 0;
        for (int k = 0; k < t.length(); k++) {
            if (chars1[i] == chars2[k]) {
                i ++;
                // 注意这里要判断一下, s有可能提前匹配完, 这时不退出循环, 就会数组越界
                if (i == s.length()) break;
            }
        }
        return i == s.length();
    }
}