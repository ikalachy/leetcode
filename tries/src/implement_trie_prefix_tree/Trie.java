package implement_trie_prefix_tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode('R');
    }

    public void insert(String word) {
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            node.children.putIfAbsent(letter, new TrieNode(letter));
            node = node.get(letter);
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            node = node.get(letter);
            if (node == null) {
                return false;
            }
        }

        return node.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (char letter : letters) {
            node = node.get(letter);
            if (node == null) {
                return false;
            }
        }
        return true;
    }


    static class TrieNode {
        char label;
        boolean endOfWord;
        Map<Character, TrieNode> children;

        public TrieNode(char label) {
            this.children = new HashMap<>();
            this.label = label;
        }

        public TrieNode get(char letter) {
            return children.get(letter);
        }
    }
}