package validate_binary_search_tree;

import model.TreeNode;
import utils.Tree;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((max != null && root.val >= max) ||
                (min != null && root.val <= min))
            return false;

        return dfs(root.left, min, root.val)
                && dfs(root.right, root.val, max);
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        boolean result;

//        result = instance.isValidBST(Tree.of(new Integer[]{5, 4, 6, null, null, 3, 7}));
//        System.out.println("Result: " + result);

//        result = instance.isValidBST(Tree.of(new Integer[]{5, 1, 4, null, null, 3, 6}));
//        System.out.println("Result: " + result);

        result = instance.isValidBST(Tree.of(new Integer[]{2_147_483_647}));
        System.out.println("Result: " + result);


    }
}
