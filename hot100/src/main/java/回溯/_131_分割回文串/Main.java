package 回溯._131_分割回文串;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int start) {
        if (start == s.length()) {
            res.add(new LinkedList<>(track));
        }

        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) continue;
            track.addLast(s.substring(start, i + 1));
            backtrack(s, i + 1);
            track.removeLast();
        }
    }

    boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo ++;
            hi --;
        }
        return true;
    }
}