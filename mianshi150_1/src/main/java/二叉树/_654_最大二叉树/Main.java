package 二叉树._654_最大二叉树;

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
// 最大二叉树定义: 个节点的值都大于其左子树中任意节点的值，且大于其右子树中任意节点的值。换句话说，最大二叉树的根节点是数组中的最大元素，根据该最大元素将数组分成左右两部分，然后分别对这两部分递归构建左右子树。
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        // 找到最大值, 以及其下标
        int index = -1, maxNum = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxNum) {
                index = i;
                maxNum = nums[i];
            }
        }

        // 构建二叉树顺序: 根节点 -> 左子树 -> 右子树
        TreeNode root = new TreeNode(maxNum);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }
}