package com.scaler.core.java_3_advance_3.dsa_36_tries_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 12:39 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Shortest_Unique_Prefix {
    static class Node {
        int count;
        Node[] child = new Node[26];

        Node() {
            count = 0;
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }
    Node root = new Node();

    private String[] prefix(String[] A) {
        String ans[] = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            Node curr = root;
            for (int j = 0; j < A[i].length(); j++) {
                int idx = A[i].charAt(j) - 'a';
                if (curr.child[idx] == null) {
                    curr.child[idx] = new Node();
                }
                curr = curr.child[idx];
                curr.count++;
            }
        }
        for (int i = 0; i < A.length; i++) {
            Node curr = root;
            String str = "";
            for (int j = 0; j < A[i].length(); j++) {
                int idx = A[i].charAt(j) - 'a';
                if (curr.count == 1) {
                    ans[i] = str;
                    break;
                }
                str += A[i].charAt(j);
                curr = curr.child[idx];
                if (j == A[i].length() - 1) ans[i] = str;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] A = {"zebra", "dog", "duck", "dove"};
        Q3_Shortest_Unique_Prefix solution = new Q3_Shortest_Unique_Prefix();
        String[] results = solution.prefix(A);
        PrintUtils.print(results);
    }
}
