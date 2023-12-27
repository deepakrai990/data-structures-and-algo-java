package com.scaler.core.java_3_advance_3.dsa_36_tries_1.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 12:40 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Modified_Search {

    static class Trie {
        boolean isEnd;
        Trie[] nodes;
        public Trie(boolean isEnd) {
            this.isEnd = isEnd;
            nodes = new Trie[26];
        }
    }

    private String solve(String[] A, String[] B) {
        int n = A.length;
        Trie root = new Trie(false);
        for (int i = 0; i < n; i++) {
            root = addWordInTrie(A[i], root);
        }
        int m = B.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (wordExistsInTrie(root, B[i], B[i].length(), 0, false))
                sb.append('1');
            else
                sb.append('0');
        }
        return sb.toString();
    }

    private boolean wordExistsInTrie(Trie root, String word, int length, int index, boolean modified) {
        if (index == length && modified)
            return true;
        if (root == null || (index == length && !modified))
            return false;

        char ch = word.charAt(index);
        boolean res = false; // important before starting itrations of node array make the flag false again
        for (int i = 0; i < 26; i++) { //any node can contain answer so need to check all nodes
            if (root.nodes[i] != null) {
                if (modified && i == (ch - 'a')) {
                    res = res | wordExistsInTrie(root.nodes[i], word, length, index + 1, modified);
                } else if (!modified) {
                    if (i == (ch - 'a')) {
                        res = res | wordExistsInTrie(root.nodes[i], word, length, index + 1, modified);
                    } else {
                        res = res | wordExistsInTrie(root.nodes[i], word, length, index + 1, true);
                    }
                }
            }
        }
        return res;
    }

    private Trie addWordInTrie(String word, Trie root) {
        Trie temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (temp.nodes[index] == null)
                temp.nodes[index] = new Trie(false);
            temp = temp.nodes[index];
        }
        temp.isEnd = true;
        return root;
    }

    public static void main(String[] args) {
        String[] A = {"data", "circle", "cricket"};
        String[] B = {"date", "circel", "crikket", "data", "circl"};
        Q2_Modified_Search solution = new Q2_Modified_Search();
        String result = solution.solve(A, B);
        PrintUtils.print(result);
    }
}
