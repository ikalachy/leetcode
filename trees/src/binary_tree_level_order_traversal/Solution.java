package binary_tree_level_order_traversal;

import model.TreeNode;
import utils.Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        dfs(root, results, 0);
        return results;
    }

    private void dfs(TreeNode root, List<List<Integer>> results, int level) {
        if (root == null) return;
        if (level >= results.size())
            results.add(new ArrayList<>());

        results.get(level).add(root.val);
        dfs(root.left, results, level + 1);
        dfs(root.right, results, level + 1);

    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        List<List<Integer>> result;

        result = instance.levelOrder(Tree.of(new Integer[]{3, 9, 20, null, null, 15, 7}));
        System.out.println("Result: " + result);

        result = instance.levelOrder(Tree.of(new Integer[]{1}));
        System.out.println("Result: " + result);

    }
}
