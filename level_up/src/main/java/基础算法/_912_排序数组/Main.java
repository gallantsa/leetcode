package 基础算法._912_排序数组;

/**
 * @author gallantsa
 * @date 2024年04月09日 12:57
 */
public class Main {
}

// 快速排序
class Solution1 {
    int[] nums;

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        numsuickSort(0, nums.length - 1);
        return nums;
    }

    private void numsuickSort(int l, int r) {
        // 由于是闭区间, 当l == r 说明还剩一个元素, 一个元素不需要排序
        if (l == r) {
            return;
        }
        // 分界线
        int x = nums[(l + r) >> 1];
        int i = l - 1, j = r + 1;
        while (i < j) {
            // 从左找到第一个比分界线元素大的元素
            while (nums[++i] < x) {
            }

            // 从右找到一个比分界线元素小的元素
            while (nums[--j] > x) {
            }
            // 交换两个元素
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        numsuickSort(l, j);
        numsuickSort(j + 1, r);
    }
}

// 归并排序
class Solution {
    int[] nums;
    int[] tmp;

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        mergeSort(0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int l, int r) {
        if (l == r) return;
        int mid = (l + r) >> 1;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        //分两边l-mid, (mid+1)-r
        while (i <= mid && j <= r)
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];

        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];

        //把得到的数组重新赋给nums
        for (i = l, j = 0; i <= r; i++, j++) nums[i] = tmp[j];
    }
}