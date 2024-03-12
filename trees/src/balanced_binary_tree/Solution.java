package balanced_binary_tree;

import model.TreeNode;
import utils.Tree;

import java.util.function.Function;

public class Solution {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root, 0);
        return isBalanced;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null || !isBalanced)
            return 0;

        int left = dfs(node.left, depth);
        int right = dfs(node.right, depth);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        boolean result;

        // true
        result = instance.isBalanced(Tree.of(new Integer[]{3, 9, 20, null, null, 15, 7}));
        System.out.println("Result: " + result);

        //false
        result = instance.isBalanced(Tree.of(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4}));
        System.out.println("Result: " + result);


    }


}
