package 二叉树._98_验证二叉搜索树;

import 二叉树.TreeNode;

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
// 二叉搜索树定义
// 节点的左 子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 并没有节点相等的一说
class Solution {
    List<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        traverse(root);

        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}