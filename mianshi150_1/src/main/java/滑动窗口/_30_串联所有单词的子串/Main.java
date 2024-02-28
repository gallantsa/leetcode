package 滑动窗口._30_串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // wordCount 用来统计words数组中, 每个单词出现的个数
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        // 计算最终串联所有单词的子串的长度
        int allWordLength = wordLength * words.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= s.length() - allWordLength; i++) {
            // currentWordCount 统计当前子串单词出现的次数
            Map<String, Integer> currentWordCount = new HashMap<>();
            String currentWord = s.substring(i, i + allWordLength);

            for (int j = 0; j < currentWord.length(); j += wordLength) {
                String word = currentWord.substring(j, j + wordLength);
                currentWordCount.put(word, currentWordCount.getOrDefault(word, 0) + 1);
            }

            // 如果两个hash表的内容完全相同, 则是所有单词串联的子串
            if (wordCount.equals(currentWordCount)) {
                res.add(i);
            }
        }
        return res;
    }
}

