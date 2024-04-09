package 基础算法._1898_可移除字符的最大数目;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gallantsa
 * @date 2024年04月09日 10:56
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumRemovals("qlevcvgzfpryiqlwy", "qlecfqlw", new int[]{12,5}));
    }
}

class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int n = removable.length;
        int l = -1, r = n;
        while (l + 1 != r) {
            int mid = (l + r) >> 1;
            if (check(s, p, removable, mid)) l = mid;
            else r = mid;
        }
        // 如果l指向最后一个元素, 并且以最后一个元素为结尾的字符串包含p, 就返回l + 1, 否则返回l
        return (l == n - 1  && check(s, p, removable, l + 1)) ? l + 1 : l;
    }

    /**
     * 判断在移除 removable 中的前 mid 个元素后，字符串 s 是否包含字符串 p 作为子序列
     */
    private boolean check(String s, String p, int[] removable, int mid) {
        int m = s.length(), n = p.length(), i = 0, j = 0;
        // 使用 Set 来记录要移除的字符的索引
        Set<Integer> ids = new HashSet<>();
        for (int k = 0; k < mid; ++k) {
            ids.add(removable[k]);
        }
        while (i < m && j < n) {
            if (!ids.contains(i) && s.charAt(i) == p.charAt(j)) {
                ++j;
            }
            ++i;
        }
        return j == n;
    }
}