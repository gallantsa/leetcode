package 滑动窗口._438_找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gallantsa
 * @date 2024年04月10日 9:52
 */
public class Main {
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int l = 0, r = p.length();
        List<Integer> res = new ArrayList<>();
        String encode = encode(p);
        while (r <= s.length()) {
            String substring = s.substring(l, r);
            String encode1 = encode(substring);
            if (encode.equals(encode1)) res.add(l);
            l++;
            r++;
        }
        return res;
    }

    private String encode(String str) {
        char[] chars = new char[26];
        for (char c : str.toCharArray()) {
            chars[c - 'a']++;
        }
        return new String(chars);
    }
}