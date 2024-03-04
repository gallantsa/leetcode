package 二叉树._129_求根节点到叶节点数字之和;

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
// 本题的节点数至少有一个
class Solution {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        help(root, 0);
        return res;
    }

    // 函数定义: root为当前节点, sum为从根节点到当前节点路径表示的数
    private void help(TreeNode root, int sum) {

        // 前序位置, 在进入节点时, 做一些操作
        sum = root.val + sum * 10;
        // 遍历到叶子结点
        if (root.left == null && root.right == null)  res += sum;

        if (root.left != null) help(root.left, sum);
        if (root.right != null) help(root.right, sum);
    }
}