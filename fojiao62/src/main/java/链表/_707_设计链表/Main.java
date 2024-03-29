package 链表._707_设计链表;

import java.util.LinkedList;

public class Main {
}

class MyLinkedList {

    LinkedList<Integer> list;

    public MyLinkedList() {
        list = new LinkedList<>();
    }

    public int get(int index) {
        if (!isValid(index)) {
            return -1;
        }
        return list.get(index);
    }

    public void addAtHead(int val) {
        list.addFirst(val);
    }

    public void addAtTail(int val) {
        list.addLast(val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > list.size()) return;
        list.add(index, val);
    }

    public void deleteAtIndex(int index) {
        if (isValid(index)) {
            list.remove(index);
        }
    }

    private boolean isValid(int index) {
        if (index < 0 || index >= list.size()) {
            return false;
        }
        return true;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */