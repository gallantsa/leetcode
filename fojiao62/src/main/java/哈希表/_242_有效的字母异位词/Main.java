package 哈希表._242_有效的字母异位词;

public class Main {
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (encode(s).equals(encode(t))) {
            return true;
        }
        return false;
    }

    private String encode(String s) {
        char[] chars = new char[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        return new String(chars);
    }
}