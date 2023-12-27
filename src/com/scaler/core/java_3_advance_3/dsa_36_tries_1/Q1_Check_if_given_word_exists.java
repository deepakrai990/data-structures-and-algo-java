package com.scaler.core.java_3_advance_3.dsa_36_tries_1;

import java.util.HashMap;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
class Node {
    public boolean isEnd;
    public HashMap<Character, Node> hm;
    public Node() {
        isEnd = false;
        hm = new HashMap<>();
    }
}
public class Q1_Check_if_given_word_exists {
    /**
     * Question: Given N Strings and Q queries.
     * For each query, check if a given query is in given N String.
     * Note: All chars are 'a' - 'z' (a to z) and length (String) <= length
     * **/
    private static void insert(Node root, String data) {
        Node temp = root;
        int length = data.length();
        for (int i = 0; i < length; i++) {
            // Char to insert is data[i]
            char ch = data.charAt(i);
            if (temp.hm.containsKey(ch)) {
                temp = temp.hm.get(ch);
            } else {
                // Not found create new Node
                Node newNode = new Node();
                temp.hm.put(ch, newNode);
                temp = newNode; // Or temp = temp.hm.get(ch);
            }
        }
        temp.isEnd = true;
    }
    private static boolean search(Node root, String data) {
        Node temp = root;
        int length = data.length();
        for (int i = 0; i < length; i++) {
            char ch = data.charAt(i);
            if (temp.hm.containsKey(ch)) {
                temp = temp.hm.get(ch);
            } else {
                return false;
            }
        }
        return temp.isEnd;
    }

    public static void main(String[] args) {
        Node root = new Node();
        String[] words = {"damp", "dark", "data", "drake", "drawn", "drew", "dried", "drunk", "draw", "trie", "tried",
                "trump", "tea"};
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i]);
        }
        String[] queries = {"data", "draw", "drew", "dump", "drawed"};
        for (int i = 0; i < queries.length; i++) {
            if (search(root, queries[i])) {
                System.out.println(queries[i] + " has been found");
            } else {
                System.out.println(queries[i] + " not found");
            }
        }
    }
}
