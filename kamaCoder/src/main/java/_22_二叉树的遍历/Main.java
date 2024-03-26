package _22_二叉树的遍历;

import java.util.Scanner;

// ⼀组多⾏数据，第⼀⾏为数字n, 表示后⾯有n⾏，后⾯每⾏为1个字符加2个整数，输出树节点的后序遍历字符串
public class Main {
    static TreeNode[] node;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            node = new TreeNode[n + 1];
            for (int i = 0; i < n; i++) {
                // 获取字符和左右节点
                char val = sc.next().charAt(0);
                int left = sc.nextInt();
                int right = sc.nextInt();
                node[i + 1] = new TreeNode(val, left, right);
            }
            preOrderTraversal(1);
            System.out.println();
            inOrderTraversal(1);
            System.out.println();
            postOrderTraversal(1);
            System.out.println();
        }

    }

    private static void postOrderTraversal(int root) {
        if (root == 0) return;

        postOrderTraversal(node[root].left);
        postOrderTraversal(node[root].right);
        System.out.print(node[root].val);
    }

    private static void inOrderTraversal(int root) {
        if (root == 0) return;

        inOrderTraversal(node[root].left);
        System.out.print(node[root].val);
        inOrderTraversal(node[root].right);
    }

    private static void preOrderTraversal(int root) {
        if (root == 0) return;

        System.out.print(node[root].val);
        preOrderTraversal(node[root].left);
        preOrderTraversal(node[root].right);
    }
}

class TreeNode {
    char val;
    int left;
    int right;

    public TreeNode(char val) {
        this.val = val;
    }

    public TreeNode(char val, int left, int right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}