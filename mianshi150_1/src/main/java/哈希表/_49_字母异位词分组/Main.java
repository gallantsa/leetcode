package 哈希表._49_字母异位词分组;

import java.util.*;

public class Main {
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> codeToGroup = new HashMap<>();
        for (String str : strs) {
            // 对字符串进行编码
            String code = encode(str);
            // 把编码相同的字符串放在一起
            // 如果 code 还没有被映射到任何值，那么就会将 code 映射到一个新的 LinkedList。如果 code 已经被映射到了某个值，那么 putIfAbsent 方法就不会做任何事情
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(str);
        }

        // 获取结果
        List<List<String>> res = new LinkedList<>();
        for (List<String> group : codeToGroup.values()) {
            res.add(group);
        }

        return res;
    }

    private String encode(String str) {
        char[] count = new char[26];
        for (char c : str.toCharArray()) {
            int delta = c - 'a';
            count[delta]++;
        }
        return new String(count);
    }
}