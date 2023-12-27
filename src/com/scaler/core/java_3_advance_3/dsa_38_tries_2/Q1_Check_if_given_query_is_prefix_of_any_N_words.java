package com.scaler.core.java_3_advance_3.dsa_38_tries_2;

import java.util.HashMap;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean isEndOfWord;
    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}
public class Q1_Check_if_given_query_is_prefix_of_any_N_words {
    /**
     * Questions: Given N inputs Strings and Q queries.
     * For Each query, check if a given query is prefix of any input strings.
     * Constraints:
     * 1 <= length (String) <= length
     * Note: SubString starting at index = 0.
     *       Full String is also prefix String
     * **/
    private static void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
    }
    private static boolean isPrefix(TrieNode root, String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false; // Prefix isn't found
            }
            node = node.children.get(ch);
        }
        return true; // Prefix found
    }
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        String[] inputStrings = {"apple", "app", "banana", "orange", "grape"};
        // Insert N input strings
        for (String input : inputStrings) {
            insert(root, input);
        }
        // Perform Q queries
        String[] queries = {"ap", "or", "ban", "pear"};
        for (String query : queries) {
            if (isPrefix(root, query)) {
                System.out.println(query + " is a prefix.");
            } else {
                System.out.println(query + " is not a prefix.");
            }
        }
    }
}
