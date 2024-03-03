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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        int myDiameter = leftMax + rightMax;
        // 后序遍历位置顺便计算最大直径
        max = Math.max(myDiameter, max);
        return 1 + Math.max(leftMax, rightMax);
    }
}