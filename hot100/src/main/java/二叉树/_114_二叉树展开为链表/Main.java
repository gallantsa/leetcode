package 二叉树._114_二叉树展开为链表;

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
    public void flatten(TreeNode root) {
        traverse(root);
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        traverse(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null; // 注意root的左子树置空
        TreeNode p = root;

        while (p.right != null) {
            p = p.right;
        }

        p.right = temp;
    }
}