package word_search_ii;

import java.util.*;

public class Solution2 {
    Set<Pair> visited = new HashSet<>();
    Set<String> results = new HashSet<>();


    static class TrieNode {
        boolean endWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public void addWord(String word) {
            char[] chars = word.toCharArray();
            TrieNode node = this;
            for (char ch : chars) {
                TrieNode test = node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.endWord = true;
        }

        public TrieNode get(char key) {
            return children.get(key);
        }
    }

    record Pair(int row, int col) {
    }

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {
            root.addWord(word);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                dfs(board, root, row, col, "");
            }
        }

        return results.stream().toList();
    }

    public void dfs(char[][] board, TrieNode node, int row, int col, String buffer) {
        Pair key = new Pair(row, col);
        if (row < 0 || row == board.length ||
                col < 0 || col == board[row].length ||
                visited.contains(key) || !node.children.containsKey(board[row][col]))
            return;

        visited.add(key);
        buffer += (board[row][col]);
        node = node.get(board[row][col]);

        if (node.endWord)
            results.add(buffer.toString());

        dfs(board, node, row - 1, col, buffer); // up
        dfs(board, node, row + 1, col, buffer); // down>
        dfs(board, node, row, col - 1, buffer); // left
        dfs(board, node, row, col + 1, buffer); // right

        visited.remove(key);
    }

    public void dfsPrint(char[][] board, int row, int col, int counter, String prefix) {
        Pair key = new Pair(row, col);
        if (row < 0 || row == board.length ||
                col < 0 || col == board[row].length || visited.contains(key))
            return;
        counter += 1;

        if (counter > 10) {
            System.out.println();
            counter = 0;
        }
        System.out.print(prefix + board[row][col] + " -> ");
        visited.add(key);
        dfsPrint(board, row - 1, col, counter, ""); // up
        dfsPrint(board, row + 1, col, counter, ""); // down
        dfsPrint(board, row, col + 1, counter,  ""); // right
        dfsPrint(board, row, col - 1, counter, ""); // left
        visited.remove(key);
    }

    public static void main(String[] args) {
        Solution2 instance = new Solution2();
        List<String> result;

        char[][] demo = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        result = instance.findWords(
                demo,
                new String[]{"oath", "pea", "eat", "rain"});

//        result = instance.findWords(
//                new char[][]{{'a'}},
//                new String[]{"ab"});

//        result = instance.findWords(
//                new char[][]{{'a', 'b', 'c', 'e'}, {'x', 'x', 'c', 'd'}, {'x', 'x', 'b', 'a'}},
//                new String[]{"abc", "abcd"});

//        result = instance.findWords(
//                new char[][]{{'a', 'a'}, {'a', 'a'}},
//                new String[]{"aaaaa"});

        System.out.println("Result: " + result);

        instance.dfsPrint(demo, 0, 0, 0, "");


    }
}
