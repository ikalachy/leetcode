package serialize_and_deserialize_binary_tree;

import model.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "null"; // Handle the case when the tree is empty
        return String.format("%s,%s,%s", root.val, serialize(root.left), serialize(root.right));
    }

    int pos = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return dfsDeser(data.split(","));
    }

    private TreeNode dfsDeser(String[] root) {
        TreeNode node = null;
        String val = root[pos];
        pos += 1;


        if ("null".equals(val)) {
            return node;
        }

        node = new TreeNode(Integer.parseInt(val));
        TreeNode left = dfsDeser(root);
        TreeNode right = dfsDeser(root);

        node.left = left;
        node.right = right;

        return node;
    }
}


