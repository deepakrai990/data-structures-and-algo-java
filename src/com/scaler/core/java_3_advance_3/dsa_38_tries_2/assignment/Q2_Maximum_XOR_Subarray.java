package com.scaler.core.java_3_advance_3.dsa_38_tries_2.assignment;

/**
 * @created 02/04/23 11:31 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Maximum_XOR_Subarray {
    static class NodePrefix {
        int index;
        NodePrefix[] child;

        NodePrefix() {
            index = -1;
            child = new NodePrefix[2];
        }
    }

    private int[] solve(int[] A) {
        // init
        int[] prefixXOR = new int[A.length];
        prefixXOR[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ A[i];
        }

        NodePrefix root = new NodePrefix();
        int maxXor = Integer.MIN_VALUE;
        int s = -1;
        int e = -1;

        insert(root, 0, -1); // -1 index has 0. since x^0 = x.

        for (int i = 0; i < prefixXOR.length; i++) {
            int ind = query(root, prefixXOR[i]); // complement of prefix num index
            int currXor = (ind == -1) ? prefixXOR[i] : (prefixXOR[i] ^ prefixXOR[ind]); // ind = -1, took the subarray from 0-i
            if (currXor > maxXor || s == -1) {
                maxXor = currXor;
                s = ind + 1;
                e = i;
            } else if (currXor == maxXor) {
                int currLen = i - (ind + 1) + 1;
                int prevLen = e - s + 1;
                if (currLen < prevLen) {
                    s = ind + 1;
                    e = i;
                }
            }
            insert(root, prefixXOR[i], i);
        }

        int[] res = {s + 1, e + 1};
        return res;
    }

    private int query(NodePrefix root, int prefixNum) {
        NodePrefix curr = root;
        for (int j = 30; j >= 0; j--) {
            int bit = checkBit(prefixNum, j);
            int compBit = bit == 1 ? 0 : 1;
            if (curr.child[compBit] != null) {
                curr = curr.child[compBit];
            } else {
                curr = curr.child[bit];
            }
        }
        return curr.index;
    }

    private void insert(NodePrefix root, int prefixNum, int index) {
        NodePrefix curr = root;
        for (int i = 30; i >= 0; i--) {
            int bit = checkBit(prefixNum, i);
            if (curr.child[bit] == null) {
                curr.child[bit] = new NodePrefix();
            }
            curr = curr.child[bit];
        }
        curr.index = index;
    }
    private int checkBit(int prefixNum, int i) {
        return (prefixNum >> i & 1) == 1 ? 1 : 0;
    }
}
