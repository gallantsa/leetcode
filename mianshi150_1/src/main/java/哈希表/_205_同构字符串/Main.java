package 哈希表._205_同构字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        // 先建立两个字符串之间的映射关系
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), t.charAt(i));
        }

        // 如果键值之间相互唯一映射, 且能够根据映射规则复原字符串, 满足条件
        if (isUniqueMapping(map)) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(map.get(c));
            }
            if (sb.toString().equals(t)) {
                return true;
            }
        }
        return false;
    }

    // 判断键值之间是否相互唯一映射
    private boolean isUniqueMapping(Map<Character, Character> map) {
        Set<Character> keys = new HashSet<>();
        Set<Character> values = new HashSet<>();

        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            // 如果键或者值, 已经有了映射关系, 返回false
            if (!keys.add(entry.getKey()) || !values.add(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}