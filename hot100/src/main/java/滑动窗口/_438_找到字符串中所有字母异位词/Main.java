package 滑动窗口._438_找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 获取匹配字符串编码
        String encode = encode(p);

        int n = p.length();
        int left = 0, right = n;
        List<Integer> res = new ArrayList<>();
        while (right <= s.length()) {
            String substring = s.substring(left, right);
            String encode1 = encode(substring);
            // 如果窗口内的字符串编码等于匹配字符串的编码, 将其的左下标加入到答案
            if (encode.equals(encode1)) {
                res.add(left);
            }
            left++;
            right++;
        }
        return res;
    }

    private String encode(String str) {
        char[] c = new char[26];
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - 'a';
            c[ch] ++;
        }
        return new String(c);
    }
}