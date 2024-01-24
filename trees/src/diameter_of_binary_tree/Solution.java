package diameter_of_binary_tree;

import model.TreeNode;
import utils.Tree;

public class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int dfs = dfs(root);
        return diameter;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return -1;

        int left = dfs(root.left);
        int right = dfs(root.right);
        diameter = Math.max(diameter, 2 + left + right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

//        Integer[] array = {4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2};
//        result = instance.diameterOfBinaryTree(Tree.of(array));
//        System.out.println("Result: " + result);

        result = instance.diameterOfBinaryTree(Tree.of(new int[]{1, 2, 3, 4, 5}));
        System.out.println("diameter: " + result);
////
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        result = instance.diameterOfBinaryTree(root);
//        System.out.println("Result: " + result);
//
//        result = instance.diameterOfBinaryTree(Tree.of(new int[]{1, 2}));
//        System.out.println("Result: " + result);

    }

    public static class MyClass {
        public TreeNode getClient() {
            return client;
        }

        private final TreeNode client;

        public MyClass(TreeNode client) {
            this.client = client;
        }
    }
}
