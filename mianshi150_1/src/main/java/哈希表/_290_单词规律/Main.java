package 哈希表._290_单词规律;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("jquery", "dog cat cat dog"));
    }
}

// 和同构字符串那题几乎一样
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] s1 = s.split(" ");
        if (s1.length != pattern.length()) return false;
        int i = 0;
        for (char c : pattern.toCharArray()) {
            map.put(c, s1[i++]);
        }

        if (isUniqueMapping(map)) {
            StringBuilder sb = new StringBuilder();
            for (char c : pattern.toCharArray()) {
                sb.append(map.get(c) + " ");
            }
            if (sb.toString().trim().equals(s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUniqueMapping(Map<Character, String> map) {
        Set<Character> keys = new HashSet<>();
        Set<String> values = new HashSet<>();

        for (Map.Entry<Character, String> entry : map.entrySet()) {
            if (!keys.add(entry.getKey()) || !values.add(entry.getValue())) {
                return false;
            }
        }

        return true;
    }
}
