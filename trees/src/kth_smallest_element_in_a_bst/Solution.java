package kth_smallest_element_in_a_bst;

import model.TreeNode;
import utils.Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> kthSeq;

    public int kthSmallest(TreeNode root, int k) {
        kthSeq = new ArrayList<>(k);
        dfs(root, k);
        return kthSeq.getLast();
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;

        dfs(root.left, k);
        System.out.print(root.val + " ");
        if (kthSeq.size() < k)
            kthSeq.add(root.val);
        dfs(root.right, k);
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.kthSmallest(Tree.of(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 2); //1
        System.out.println("Result: " + result);
//
//        result = instance.kthSmallest(Tree.of(new Integer[]{3, 1, 4, null, 2}), 1); //1
//        System.out.println("Result: " + result);


    }
}
