package 哈希表._383_赎金信;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> countRansomNote = new HashMap<>();
        Map<Character, Integer> countMagazine = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            countRansomNote.put(c, countRansomNote.getOrDefault(c, 0) + 1);
        }
        for (char c : magazine.toCharArray()) {
            countMagazine.put(c, countMagazine.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            // 防止countMagazine.get(c)为空, 导致空指针异常
            if (!countMagazine.containsKey(c) || countRansomNote.get(c) > countMagazine.get(c)) {
                return false;
            }
        }
        return true;
    }
}