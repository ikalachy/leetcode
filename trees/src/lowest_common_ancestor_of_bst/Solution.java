package lowest_common_ancestor_of_bst;

import model.TreeNode;
import utils.Tree;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        TreeNode result;

        result = instance.lowestCommonAncestor(Tree.of(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}), new TreeNode(4), new TreeNode(5));
        System.out.println("Result: " + result.val);


    }
}
