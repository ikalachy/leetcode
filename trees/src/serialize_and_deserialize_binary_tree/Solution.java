package serialize_and_deserialize_binary_tree;

import model.TreeNode;
import utils.Tree;

public class Solution {
    public static void main(String[] args) {
        // Your Codec object will be instantiated and called as such:
        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(Tree.of(new Integer[]{1, 2, 3, null, null, 4, 5}));
        System.out.println(serialized);

        TreeNode ans = deser.deserialize(serialized);
        System.out.println(ans);

    }
}
