package construct_binary_tree_from_preorder_and_inorder_traversal;

import model.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode node = new TreeNode(preorder[0]);
        int mid = indexOf(preorder[0], inorder);

        node.left = buildTree(
                Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(inorder, 0, mid));

        node.right = buildTree(
                Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length));

        return node;

    }

    private int indexOf(int what, int[] where) {
        for (int i = 0; i < where.length; i++) {
            if (what == where[i]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        TreeNode result;

        result = instance.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println("Result: " + result);


    }
}
