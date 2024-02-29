package 哈希表._202_快乐数;

import java.util.HashSet;
import java.util.Set;

public class Main {
}

// 简单题
class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            n = getSum(n);
            if (set.contains(n)) {
                return false;
            }
        }
        return true;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}