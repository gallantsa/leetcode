package 二叉树._450_删除二叉搜索树中的节点;

import common.TreeNode;

public class Main {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // 方法解释: 删除以root为根节点的二叉树中值为key的节点, 并返回根节点
    public TreeNode deleteNode(TreeNode root, int key) {
        // 没找到节点
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // 找到节点
            // 如果该节点没有左孩子, 直接返回右孩子
            if (root.left == null) return root.right;
            // 如果该节点没有右孩子, 直接返回左孩子
            if (root.right == null) return root.left;
            // 如果既有右孩子, 又有左孩子
            TreeNode tmp = root.right;
            // 找到右孩子的最小节点
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            // 将右子树的最小节点赋给要删除的节点
            root.val = tmp.val;
            // 递归地删除右子树的最小节点
            root.right = deleteNode(root.right, tmp.val);
        }
        return root;
    }
}