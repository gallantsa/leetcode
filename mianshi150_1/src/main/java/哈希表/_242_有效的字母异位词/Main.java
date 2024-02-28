package 哈希表._242_有效的字母异位词;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

// 卡了个样例, 把样例复制过来差点把电脑搞炸了
class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (!map2.containsKey(c) || map1.get(c) != map2.get(c)) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a'] += 1;
            ints[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) return false;
        }
        return true;
    }
}