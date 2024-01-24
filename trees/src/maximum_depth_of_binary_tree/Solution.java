package maximum_depth_of_binary_tree;

import model.TreeNode;
import utils.Tree;

public class Solution {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int depth) {
        if (node == null) return depth;

        depth += 1;
        int depthLeft = maxDepth(node.left, depth);
        int depthRight = maxDepth(node.right, depth);

        return Math.max(depthLeft, depthRight);
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.maxDepth(Tree.of(new int[]{1, 2}));
        System.out.println("Result: " + result);


    }
}
