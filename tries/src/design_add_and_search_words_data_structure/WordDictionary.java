package design_add_and_search_words_data_structure;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node('S');
    }

    public void addWord(String word) {
        Node node = root;
        char[] letters = word.toCharArray();

        for (char letter : letters) {
            node = node.putIfAbsent(letter);
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        return searchNode(word, this.root);
    }

    public boolean searchNode(String word, Node root) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (letter == '.') {
                for (Node childNode : node.children.values()) {
                    if (searchNode(word.substring(i + 1), childNode))
                        return true;
                }
                return false;
            }

            node = node.get(letter);
            if (node == null) return false;
        }

        return node.wordEnd;
    }


    static class Node {
        boolean wordEnd;
        char label;
        Map<Character, Node> children;

        public Node(char label) {
            this.label = label;
            children = new HashMap<>();
        }

        public Node putIfAbsent(char letter) {
            children.putIfAbsent(letter, new Node(letter));
            return children.get(letter);
        }

        public Node get(char letter) {
            return children.get(letter);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */