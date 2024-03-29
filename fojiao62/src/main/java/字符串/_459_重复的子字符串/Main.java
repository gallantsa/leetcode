package 字符串._459_重复的子字符串;

public class Main {
}

// 情况一：如果字符串 str 可以由它的一个子串重复多次构成
//
// str = s + s
//
// str + str = [s + s] + [s + s] = s + [s + s] + s
//
// 情况二：如果字符串 str 不可以由它的一个子串重复多次构成
//
// str = s1 + s2
//
// str + str = [s1 + s2] + [s1 + s2] = s1 + [s2 + s1] + s2 != s1 + [s1 + s2] + s2

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String string = s + s;
        return string.substring(1, string.length() - 1).contains(s);
    }
}

