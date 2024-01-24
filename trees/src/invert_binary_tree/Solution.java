package invert_binary_tree;

import model.TreeNode;
import utils.Tree;

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
public class Solution {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertNodes(root.left);
        invertNodes(root.right);

        return root;

    }

    private TreeNode invertNodes(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertNodes(root.left);
        invertNodes(root.right);

        return root;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        TreeNode result;

        result = instance.invertTree(Tree.of(new int[]{4, 2, 7, 1, 3, 6, 9}));
        System.out.println("Result: " + result);


    }
}
