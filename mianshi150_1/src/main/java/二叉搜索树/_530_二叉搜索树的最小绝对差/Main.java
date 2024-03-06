package 二叉搜索树._530_二叉搜索树的最小绝对差;

import 二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size() - 1; i++) {
            int sub = res.get(i + 1) - res.get(i);
            if (sub < min) {
                min = sub;
            }
        }

        return min;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}