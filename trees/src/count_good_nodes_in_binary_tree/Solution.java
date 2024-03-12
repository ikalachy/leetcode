package count_good_nodes_in_binary_tree;

import model.TreeNode;
import utils.Tree;

public class Solution {

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) return 0;

        max = Math.max(max, root.val);
        int res = 0;
        if (root.val >= max) {
            res = 1;
        }

        return dfs(root.left, max) + dfs(root.right, max) + res;
    }


    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.goodNodes(Tree.of(new Integer[]{3, 1, 4, 3, null, 1, 5}));
        System.out.println("Result: " + result); // 4
        result = instance.goodNodes(Tree.of(new Integer[]{3, 3, null, 4, 2}));
        System.out.println("Result: " + result); // 3


    }
}
