package 二叉树._124_二叉树中的最大路径和;

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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    // 函数定义: 返回以root为根节点的最大路径和
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        // 返回左子树的最大路径和
        int left = Math.max(0, dfs(root.left));
        // 返回右子树的最大路径和
        int right = Math.max(0, dfs(root.right));
        // 更新最大路径和
        res = Math.max(res, left + right + root.val);
        // 返回以root为根节点的最大路径和
        return root.val + Math.max(left, right);
    }
}