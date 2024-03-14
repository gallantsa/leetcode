package 贪心算法._763_划分字母区间;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        // map记录每个字母最远位置的下标
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            // 找到分割区间分界
            r = Math.max(r, map.get(s.charAt(i)));
            // 当i == r时, 刚好到达分界处
            if (i == r) {
                res.add(r - l + 1); // 为什么+1, 因为最终结果是把下标为0的位置, 当做1
                l = r + 1; // 更新左边界
            }
        }
        return res;
    }
}