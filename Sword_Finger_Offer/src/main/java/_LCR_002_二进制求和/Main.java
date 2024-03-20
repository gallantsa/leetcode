package _LCR_002_二进制求和;

public class Main {
}

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        // 字符串 a 和 b 只要有一个没遍历完，那么就继续遍历；
        // 如果字符串 a 和 b 都遍历完了，但是最后留下的进位 carry != 0，那么需要把进位也保留到结果中。
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            carry += i >= 0 ? a.charAt(i) - '0' : 0;
            carry += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(carry % 2);
            carry /= 2;
        }
        return ans.reverse().toString();
    }
}