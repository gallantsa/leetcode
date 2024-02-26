package 数组_字符串._380_O1时间插入_删除和获取随机元素;

import java.util.*;

public class Main {
}

// 因为需要在O(1)的时间内, 执行getRandom方法, 因此底层只能选择数组, 用哈希表对数组中的值和下标进行映射
class RandomizedSet {

    List<Integer> nums;

    Map<Integer, Integer> valToIndex;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        // 先获取待删除值对应的下标
        int index = valToIndex.get(val);
        // 再将数组中最后一个元素的下标改为数组中待删除元素的下标
        valToIndex.put(nums.get(nums.size() - 1), index);
        // 交换数组中最后一个元素与待删除元素的位置
        Collections.swap(nums, index, nums.size() - 1);
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */