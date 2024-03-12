package subtree_of_another_tree;

import model.TreeNode;
import utils.Tree;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) return true;
        if (root == null && subRoot != null || root != null && subRoot == null) return false;

        if (root.val == subRoot.val && isSameTree(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null && subRoot != null) return false;
        if (root != null && subRoot == null) return false;
        if (root.val != subRoot.val) return false;

        return isSameTree(root.right, subRoot.right) && isSameTree(root.left, subRoot.left);

    }


    public static void main(String[] args) {
        Solution instance = new Solution();
        boolean result;

        // true
//        result = instance.isSameTree(Tree.of(new Integer[]{4, 1, 2}), Tree.of(new Integer[]{4, 1, 2}));
//        System.out.println("Result: " + result);

        result = instance.isSubtree(Tree.of(new Integer[]{3, 4, 5, 1, 2}), Tree.of(new Integer[]{4, 1, 2}));
        System.out.println("Result: " + result);

        // false
//        root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
        result = instance.isSubtree(Tree.of(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0}), Tree.of(new Integer[]{4, 1, 2}));
        System.out.println("Result: " + result);


    }
}
