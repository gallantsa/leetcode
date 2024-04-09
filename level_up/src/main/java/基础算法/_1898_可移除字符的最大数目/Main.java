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
        // 返回r, l记录的是最后一个包含子序列p的下标
        return r;
    }

    /**
     * 判断在移除 removable 中的前 mid + 1 个元素后，字符串 s 是否包含字符串 p 作为子序列
     */
    private boolean check(String s, String p, int[] removable, int mid) {
        int m = s.length(), n = p.length(), i = 0, j = 0;
        // 使用 Set 来记录要移除的字符的索引
        Set<Integer> ids = new HashSet<>();
        // 这里改为了<=
        for (int k = 0; k <= mid; ++k) {
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