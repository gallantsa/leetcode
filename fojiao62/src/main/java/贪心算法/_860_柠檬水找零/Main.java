package 贪心算法._860_柠檬水找零;

public class Main {
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            if (bill == 10) {
                if (five <= 0) return false;
                five--;
                ten++;
            }
            if (bill == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                    continue;
                }
                if (five >= 3) {
                    five -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}