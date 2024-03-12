package binary_tree_right_side_view;

import model.TreeNode;
import utils.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        levelOrderTraversal(root, levelOrder, 0);

        for (List<Integer> level : levelOrder) {
            result.add(level.getLast());
        }

        return result;
    }

    private void levelOrderTraversal(TreeNode root, List<List<Integer>> results, int level) {
        if (root == null) return;
        if (level >= results.size())
            results.add(new ArrayList<>());

        results.get(level).add(root.val);
        levelOrderTraversal(root.left, results, level + 1);
        levelOrderTraversal(root.right, results, level + 1);
    }


    public static void main(String[] args) {
        Solution instance = new Solution();
        List<Integer> result;

        result = instance.rightSideView(Tree.of(new Integer[]{1, 2, 3, 4}));
        System.out.println("Result: " + result);


    }
}
