package 链表._146_LRU_缓存;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
}

class LRUCache {

    int cap;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecently(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecently(key);
            return; // 别忘了返回
        }
        if (map.size() < cap) {
            map.put(key, value);
            return; // 别忘了返回
        }
        int oldestKey = map.keySet().iterator().next();
        map.remove(oldestKey);
        map.put(key, value);
    }

    private void makeRecently(int key) {
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */