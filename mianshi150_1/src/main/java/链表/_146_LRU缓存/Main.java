package 链表._146_LRU缓存;

import java.util.LinkedHashMap;

public class Main {
}

class LRUCache1 {

    int cap;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache1(int capacity) {
        this.cap = capacity;
        cache = new LinkedHashMap();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            makeRecently(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        cache.put(key, value);
        if (cache.size() > this.cap) {
            // 迭代器获取cache的key集合的下一个值, 因为LinkedHashMap是按照访问顺序排序的，所以第一个元素就是最旧的键。
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }

    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}

class LRUCache {

    int cap;

    LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
        }

        cache.put(key, value);
        if (cap < cache.size()) {
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
    }

    private void makeRecently(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */