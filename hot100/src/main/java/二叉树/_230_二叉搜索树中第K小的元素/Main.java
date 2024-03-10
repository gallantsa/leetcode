package 二叉树._230_二叉搜索树中第K小的元素;

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
class Solution {
    List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        return res.get(k - 1);
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}