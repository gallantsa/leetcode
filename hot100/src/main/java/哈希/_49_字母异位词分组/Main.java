package 哈希._49_字母异位词分组;

import java.util.*;

public class Main {
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> codeToGroup = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            String encode = encode(strs[i]);
            codeToGroup.putIfAbsent(encode, new LinkedList<>());
            codeToGroup.get(encode).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : codeToGroup.values()) {
            res.add(value);
        }
        return res;
    }

    private String encode(String str) {
        char[] chars = new char[26];
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            chars[index] ++;
        }
        return new String(chars);
    }
}