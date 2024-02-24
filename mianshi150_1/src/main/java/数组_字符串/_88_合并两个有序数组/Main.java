package 数组_字符串._88_合并两个有序数组;

public class Main {
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针指到两个数组的最后一个元素
        int i = m - 1, j = n - 1;
        // 令p指到nums1的末尾(因为是向nums1中添加元素)
        int p = nums1.length - 1;
        // 开始比较两个数组的元素, 从后向前比, 把大的元素放到nums1数组的尾部
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[p] = nums2[j];
                p --;
                j --;
                continue;
            }
            nums1[p] = nums1[i];
            p --;
            i --;
        }

        // 最后可能会有数组剩余, 因为是向nums1数组中添加元素, 所以只需要考虑nums2数组中是否剩余元素
        while (j >= 0) {
            nums1[p] = nums2[j];
            j --;
            p --;
        }
    }
}