package binary_tree_maximum_path_sum;

import model.TreeNode;
import utils.Tree;

public class Solution {
    int maxPathSum = 0;

    public int maxPathSum(TreeNode root) {
        maxPathSum = root.val;
        return Math.max(maxPathSum, dfs(root));
    }

    public int dfs(TreeNode root) {

        if (root == null) return 0;

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        int sum = root.val + left + right;
        maxPathSum = Math.max(maxPathSum, sum);

        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.maxPathSum(Tree.of(new Integer[]{-1, null, 9, -6, 3, null, null, null, -2}));
        System.out.println("Result: " + result);

    }
}
