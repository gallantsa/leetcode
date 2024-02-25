package 数组_字符串._13_罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    Map<Character, Integer> map = new HashMap<>();
    // "IX"
    public int romanToInt(String s) {
        initMap();
        int sum = 0;
        int preNum = map.get(s.charAt(0)); // 1
        for (int i = 1; i < s.length(); i++) {
            int num = map.get(s.charAt(i)); // 10
            if (preNum < num) {
                sum -= preNum; // sum = -1
            } else {
                sum += preNum;
            }
            preNum = num; // preNum = 10
        }
        sum += preNum; // sum = 9
        return sum;
    }

    private void initMap() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}