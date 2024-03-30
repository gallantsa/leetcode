package 二叉树._700_二叉搜索树中的搜索;

import common.TreeNode;

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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        }
        return null;
    }
}