package 二叉树._108_将有序数组转换为二叉搜索树;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return traverse(nums, 0, nums.length - 1);
    }

    private TreeNode traverse(int[] nums, int l, int r) {
        if (l > r) return null;

        int mid = (l + r) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        // 构建左子树
        root.left = traverse(nums, l, mid - 1);
        // 构建右子树
        root.right = traverse(nums, mid + 1, r);

        return root;
    }
}