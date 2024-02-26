package 数组_字符串._28_找出字符串中第一个匹配项的下标;

public class Main {
}

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == n) return haystack.equals(needle) ? 0 : -1;

        // 暴力匹配
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == m) return i;
        }
        return -1;
    }
}