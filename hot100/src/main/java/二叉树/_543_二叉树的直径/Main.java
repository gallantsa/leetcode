package 二叉树._543_二叉树的直径;

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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return res;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;

        int leftMax = traverse(root.left);
        int rightMax = traverse(root.right);
        res = Math.max(res, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }
}