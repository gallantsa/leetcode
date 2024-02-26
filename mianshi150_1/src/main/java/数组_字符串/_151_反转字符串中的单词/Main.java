package 数组_字符串._151_反转字符串中的单词;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("a good   example"));
    }
}

// 练习API
class Solution {
    public String reverseWords(String s) {
        // 删除句子中单词之间多余的空格并去掉首尾的空格 \\s+匹配一个或多个空格
        s = s.replaceAll("\\s+", " ").trim();
        // 以空格分割字符串, 并生成字符串数组
        String[] s1 = s.split(" ");
        // 将字符串数组转换成list进行翻转
        List<String> list = Arrays.asList(s1);
        Collections.reverse(list);
        // 将list重新转换成字符串数组
        s1 = list.toArray(new String[0]);
        // 连接字符串数组中每一个字符串, 并以空格分隔
        return String.join(" ", s1);
    }
}