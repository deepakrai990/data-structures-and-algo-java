package com.scaler.core.java_3_advance_3.dsa_36_tries_1.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @created 02/04/23 12:40 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Contact_Finder {
    static class Trie {
        private boolean isEnd;
        private int count;
        private Trie[] nodes;

        public Trie(boolean isEnd, int count) {
            this.isEnd = isEnd;
            this.count = count;
            nodes = new Trie[26];
        }
    }

    private int[] solve(int[] A, String[] B) {
        int n = A.length;
        List<Integer> list = new LinkedList<>();
        Trie root = new Trie(false, 0);
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                root = addWordInTrie(root, B[i]);
            } else {
                list.add(findWordCount(root, B[i]));
            }
        }

        int len = list.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++)
            ans[i] = list.get(i);

        return ans;
    }

    private Trie addWordInTrie(Trie root, String word) {
        Trie temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (temp.nodes[index] == null)
                temp.nodes[index] = new Trie(false, 0);
            temp = temp.nodes[index];
            temp.count++;
        }
        temp.isEnd = true;
        return root;
    }

    private int findWordCount(Trie root, String prefix) {
        int n = prefix.length();
        Trie temp = root;
        for (int i = 0; i < n; i++) {
            int index = prefix.charAt(i) - 'a';
            if (temp.nodes[index] == null)
                return 0;
            temp = temp.nodes[index];
        }
        return temp.count;
    }

    public static void main(String[] args) {
        int[] A = {0, 0, 1, 1};
        String[] B = {"hack", "hacker", "hac", "hak"};

        Q1_Contact_Finder solution = new Q1_Contact_Finder();

        int[] results = solution.solve(A, B);

        PrintUtils.print(results);
    }
}
