package same_tree;

import model.TreeNode;
import utils.Tree;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null && q != null || q == null && p != null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        boolean result;

        result = instance.isSameTree(Tree.of(new Integer[]{1, 2, 3}), Tree.of(new Integer[]{1, 2, 3}));
        System.out.println("Result: " + result);

    }
}
