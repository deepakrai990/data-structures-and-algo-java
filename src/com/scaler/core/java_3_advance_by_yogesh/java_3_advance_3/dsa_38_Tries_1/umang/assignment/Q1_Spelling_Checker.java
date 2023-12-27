package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_38_Tries_1.umang.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 28/03/23 4:47 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Spelling_Checker {
    class TriesNode {
        int isEnd;
        HashMap<Character, TriesNode> hm;
        public TriesNode() {
            isEnd = 0;
            hm = new HashMap<Character, TriesNode>();
        }
    }

    public void insert(TriesNode root, String S) {
        TriesNode t = root;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (t.hm.containsKey(c)) {
                t = t.hm.get(c); //if present point the address of next char
            } else {
                TriesNode n = new TriesNode();
                t.hm.put(c, n); //if not present create new node and add it in root hm
                t = t.hm.get(c); //point the next character address
            }

        }
        t.isEnd = 1; //set end point as 1 at last for each string. default is 0.
    }

    public int search(TriesNode root, String S) {
        TriesNode t = root;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (t.hm.containsKey(c)) {
                t = t.hm.get(c);
            } else {
                return 0;
            }
        }
        return t.isEnd;
    }

    public int[] solve(String[] A, String[] B) {
        int N = B.length;
        int ans[] = new int[N];
        TriesNode root = new TriesNode();
        for (int i = 0; i < A.length; i++) {
            insert(root, A[i]); //Create dictionary by calling insert for each string in array
        }
        for (int i = 0; i < N; i++) {
            ans[i] = search(root, B[i]); //call search func for each string and store results in ans array
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] A = {"hat", "cat", "rat"};
        String[] B = {"cat", "ball"};

        Q1_Spelling_Checker solution = new Q1_Spelling_Checker();

        int[] results = solution.solve(A, B);
        PrintUtils.print(results);
    }
}
