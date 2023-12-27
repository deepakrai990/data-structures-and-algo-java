package com.scaler.core.java_3_advance_3.dsa_38_tries_2;

/**
 * @author Deepak Kumar Rai
 * @created 23/11/23
 * @project scaler_course_code
 */

public class Q3_Find_max_xor_pair_value {
    static class Node {
        public Node[] c = new Node[2];
        public Node() {
            c[0] = null;
            c[1] = null;
        }
    }
    /**
     * Question: Given A[N] elements. Find max xor pair value
     * **/
    private static void insert(Node root, int A, int P) {
        Node temp = root;
        for (int i = P; i >= 0; i--) {
            int val = checkBit(A, i);
            if (temp.c[val] != null) {
                temp = temp.c[val];
            } else {
                temp.c[val] = new Node();
                temp = temp.c[val];
            }
        }
    }
    private static int query(Node root, int A, int P) {
        // For given A, find max xor
        int xorVal = 0;
        Node temp = root;
        for (int i = P; i >= 0; i--) {
            // Get ith bit in A
            int val = checkBit(A, i);
            if (temp.c[1 - val] != null) {
                xorVal = xorVal + (1 << i);
                temp = temp.c[1 - val];
            } else {
                temp = temp.c[val];
            }
        }
        return xorVal;
    }
    private static int maxXor(int[] A, int N) {
        Node r = new Node();
        int m = max(A);
        int P = -1;
        for (int i = 31; i >= 0; i--) {
            if (isCheckBit(m, i)) {
                P = i;
                break;
            }
        }
        // For all numbers inserts from P ---> 0
        for (int i = 0; i < N; i++) {
            insert(r, A[i], P);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            // A = A[i], calculate max xor
            ans = Math.max(ans, query(r, A[i], P));
        }
        return ans;
    }
    private static int max(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }
        return max;
    }
    private static int checkBit(int A, int i) {
        return (A >> i) & 1;
    }
    private static boolean isCheckBit(int A, int i) {
        return ((A >> i) & 1) == 1;
    }
    public static void main(String[] args) {
        int[] A = {22, 61, 38, 27, 21, 34, 42, 37, 43};
        int maxXorPairValue = maxXor(A, A.length);
        System.out.println("Maximum XOR pair value: " + maxXorPairValue);
    }
}
