package design_add_and_search_words_data_structure;

public class Solution {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
//        boolean pad = wordDictionary.search("pad");// return False
//        boolean bad = wordDictionary.search("bad");// return True
        boolean search = wordDictionary.search(".ad");// return True
        boolean search1 = wordDictionary.search("b..");// return True
        System.out.println(String.format("%s ", search));
        System.out.println(String.format("%s ", search1));
    }
}
