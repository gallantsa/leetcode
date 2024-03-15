package 技巧._136_只出现一次的数字;

public class Main {
}

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}