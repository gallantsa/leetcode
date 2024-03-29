package 字符串._151_反转字符串中的单词;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
}

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] s1 = s.split("\\s+");
        List<String> list = Arrays.asList(s1); // 会作用到原来的数组
        Collections.reverse(list);
        String join = String.join(" ", s1);
        return join;
    }

    private static void test1() {
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(array);
        Collections.reverse(list);
        array = list.toArray(new Integer[0]); // 列表转数组, 不能是基本数据类型
        System.out.println(Arrays.toString(array));
    }
}