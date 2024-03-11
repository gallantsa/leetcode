package 二叉树._437_路径总和III;

import 二叉树.TreeNode;

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
    int res, t;
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        dfs1(root);
        return res;
    }

    private void dfs1(TreeNode root) {
        if (root == null) return;
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    private void dfs2(TreeNode root, long val) { // 注意开long
        if (t == val) res ++;
        if (root.left != null) dfs2(root.left, root.left.val + val);
        if (root.right != null) dfs2(root.right, root.right.val + val);
    }
}