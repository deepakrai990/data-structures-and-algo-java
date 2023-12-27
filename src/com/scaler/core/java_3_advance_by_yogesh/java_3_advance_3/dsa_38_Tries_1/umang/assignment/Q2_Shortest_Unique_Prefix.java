package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_38_Tries_1.umang.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 28/03/23 4:47 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Shortest_Unique_Prefix {
    class TrieNode {
        HashMap<Character, TrieNode> hm;
        int pf;

        TrieNode() {
            hm = new HashMap<>();
            pf = 0;
        }
    }

    private void insert(TrieNode root, String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!cur.hm.containsKey(ch)) {
                cur.hm.put(ch, new TrieNode());
            }
            cur = cur.hm.get(ch);
            cur.pf += 1;
        }
    }

    private String query(TrieNode root, String s) {
        TrieNode cur = root;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cur = cur.hm.get(ch);
            res += ch;
            if (cur.pf == 1) break;
        }
        return res;
    }

    private String[] prefix(String[] A) {
        TrieNode root = new TrieNode();
        for (String s : A) {
            insert(root, s);
        }
        int n = A.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = query(root, A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] A = {"zebra", "dog", "duck", "dove"};
        Q2_Shortest_Unique_Prefix solution = new Q2_Shortest_Unique_Prefix();

        String[] results = solution.prefix(A);
        PrintUtils.print(results);
    }
}
