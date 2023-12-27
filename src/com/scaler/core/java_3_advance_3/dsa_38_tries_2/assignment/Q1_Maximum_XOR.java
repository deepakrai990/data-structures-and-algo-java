package com.scaler.core.java_3_advance_3.dsa_38_tries_2.assignment;

/**
 * @created 02/04/23 11:30 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Maximum_XOR {
    static class Trienode {
        Trienode[] bit;

        public Trienode() {
            this.bit = new Trienode[2];
        }
    }

    private int solve(int[] A) {
        int maxXOR = 0;
        Trienode root = new Trienode();
        for (int i : A) {
            maxXOR = Math.max(maxXOR, insert(root, i));
        }
        return maxXOR;
    }

    private int insert(Trienode root, int num) {
        Trienode tmp = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int set = (num >> i) & 1;
            if (root.bit[set] == null) {
                root.bit[set] = new Trienode();
            }
            if (tmp.bit[1 - set] != null) {
                tmp = tmp.bit[1 - set];
                xor = xor | (1 << i);
            } else {
                tmp = tmp.bit[set];
            }
            root = root.bit[set];
        }
        return xor;
    }
}
