package utils;

import model.TreeNode;

public class Tree {

    public static TreeNode of(int[] ints) {
        return createNodeFromArrayElement(ints, 0);
    }

    public static TreeNode of(Integer[] ints) {
        return createNodeFromInt(ints, 0);
    }

    private static TreeNode createNodeFromArrayElement(int[] ints, int i) {
        if (i >= ints.length)
            return null;

        TreeNode node = new TreeNode(ints[i]);
        node.left = createNodeFromArrayElement(ints, 2 * i + 1);
        node.right = createNodeFromArrayElement(ints, 2 * i + 2);
        return node;

    }

    private static TreeNode createNodeFromInt(Integer[] numbers, int i) {
        if (i >= numbers.length)
            return null;

        TreeNode node = null;
        if (numbers[i] != null) {
            node = new TreeNode(numbers[i]);
            node.left = createNodeFromInt(numbers, 2 * i + 1);
            node.right = createNodeFromInt(numbers, 2 * i + 2);
        }

        return node;
    }

}
