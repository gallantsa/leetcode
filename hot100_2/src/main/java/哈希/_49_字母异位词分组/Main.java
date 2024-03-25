package 哈希._49_字母异位词分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            map.putIfAbsent(encode(str), new ArrayList<>());
            map.get(encode(str)).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String encode(String str) {
        char[] res = new char[26];
        for (char c : str.toCharArray()) {
            res[c - 'a']++;
        }
        return new String(res);
    }
}