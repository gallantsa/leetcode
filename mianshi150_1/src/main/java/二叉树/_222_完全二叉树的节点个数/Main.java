package 二叉树._222_完全二叉树的节点个数;

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
    public int countNodes(TreeNode root) {
        int lh = 0, rh = 0;
        TreeNode l = root, r = root;

        // 计算左子树高度(包含根节点)
        while (l != null) {
            l = l.left;
            lh ++;
        }

        // 计算右子树高度(包含根节点)
        while (r != null) {
            r = r.right;
            rh ++;
        }

        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}