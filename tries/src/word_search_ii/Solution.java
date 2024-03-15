package word_search_ii;

import java.util.*;

public class Solution {
    Map<Character, List<Position>> cache = new HashMap<>();
    Set<String> visited = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char letter = board[i][j];
                List<Position> list = cache.getOrDefault(letter, new ArrayList<>());
                list.add(new Position(i, j));
                cache.put(letter, list);
            }
        }

        List<String> results = new ArrayList<>(words.length);
        for (String word : words) {
            if (findWord(board, word))
                results.add(word);
        }
        return results;
    }

    private boolean findWord(char[][] board, String word) {
        //1. find start
        char[] letters = word.toCharArray();
        List<Position> positions = cache.getOrDefault(letters[0], Collections.EMPTY_LIST);

        for (Position position : positions) {
            if (findRight(board, word, position.row, position.column) ||
                    findLeft(board, word, position.row, position.column) ||
                    findUp(board, word, position.row, position.column) ||
                    findDown(board, word, position.row, position.column))
                return true;
        }
        return false;
    }

    private boolean findRight(char[][] board, String word, int row, int col) {
        String position = new String(row + "-" + col);
        if (word.isEmpty()) return true;
        if (col >= board[row].length || visited.contains(position)) return false;
        if (word.charAt(0) != board[row][col]) return false;
        visited.add(position);
        boolean found = findRight(board, word.substring(1), row, col + 1) ||
                findDown(board, word.substring(1), row + 1, col) ||
                findUp(board, word.substring(1), row - 1, col);
        visited.remove(position);
        return found;
    }

    private boolean findLeft(char[][] board, String word, int row, int col) {
        String position = new String(row + "-" + col);

        if (word.isEmpty()) return true;
        if (col < 0 || visited.contains(position)) return false;
        if (word.charAt(0) != board[row][col]) return false;
        visited.add(position);
        boolean found = findLeft(board, word.substring(1), row, col - 1) ||
                findDown(board, word.substring(1), row + 1, col) ||
                findUp(board, word.substring(1), row - 1, col);
        visited.remove(position);
        return found;
    }

    private boolean findDown(char[][] board, String word, int row, int col) {
        String position = new String(row + "-" + col);
        if (word.isEmpty()) return true;
        if (row >= board.length || visited.contains(position)) return false;
        if (word.charAt(0) != board[row][col]) return false;

        visited.add(position);
        boolean found = findDown(board, word.substring(1), row + 1, col) ||
                findLeft(board, word.substring(1), row, col - 1) ||
                findRight(board, word.substring(1), row, col + 1);
        visited.remove(position);
        return found;
    }

    private boolean findUp(char[][] board, String word, int row, int col) {
        String position = new String(row + "-" + col);

        if (word.isEmpty()) return true;
        if (row < 0 || visited.contains(position)) return false;
        if (word.charAt(0) != board[row][col]) return false;
        visited.add(position);
        boolean found = findUp(board, word.substring(1), row - 1, col) ||
                findLeft(board, word.substring(1), row, col - 1) ||
                findRight(board, word.substring(1), row, col + 1);
        visited.remove(position);
        return found;
    }

    record Position(int row, int column) {
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        List<String> result;
//[['o','a','a','n'],['e','t','a','e'],['i','h','k','r'],['i','f','l','v']], words = ['oath','pea','eat','rain']
//        result = instance.findWords(
//                new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
//                new String[]{"oath", "pea", "eat", "rain"});

//        result = instance.findWords(
//                new char[][]{{'a'}},
//                new String[]{"ab"});

//        result = instance.findWords(
//                new char[][]{{'a', 'b', 'c', 'e'}, {'x', 'x', 'c', 'd'}, {'x', 'x', 'b', 'a'}},
//                new String[]{"abc", "abcd"});

        result = instance.findWords(
                new char[][]{{'a', 'a'}, {'a', 'a'}},
                new String[]{"aaaaa"});

        System.out.println("Result: " + result);


    }
}
