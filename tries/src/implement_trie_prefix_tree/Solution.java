package implement_trie_prefix_tree;

public class Solution {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        boolean apple = trie.search("apple");// return True
        boolean app = trie.search("app");// return False
        boolean app1 = trie.startsWith("app");// return True

        trie.insert("app");
        boolean app2 = trie.search("app");// return True

    }
}
