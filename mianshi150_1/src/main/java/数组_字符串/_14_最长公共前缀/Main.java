package 数组_字符串._14_最长公共前缀;

public class Main {
}

//class Solution {
//    public String longestCommonPrefix(String[] strs) {
//        boolean flag;
//        int count = 0;
//        for (int col = 0; col < strs[0].length(); col++) {
//            flag = true;
//            for (int row = 0; row < strs.length; row++) {
//                if (strs[row].charAt(col) != strs[row + 1].charAt(col)) {
//                    flag = false;
//                    return strs[0].substring(0, count);
//                }
//            }
//            count++;
//        }
//        return "";
//    }
//}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int col = 0; col < strs[0].length(); col++) {
            // 获取字符串数组的第一个字符串的列字符
            char c = strs[0].charAt(col);
            for (int row = 1; row < strs.length; row++) {
                // 如果列号为当前字符串的长度或者当前字符串的列字符与其他的字符串的列字符不同, 返回
                if (col == strs[row].length() || strs[row].charAt(col) != c) {
                    return strs[0].substring(0, col);
                }
            }
        }
        return strs[0];
    }
}