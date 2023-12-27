package com.scaler.core.java_3_advance_3.dsa_38_tries_2;

/**
 * @author Deepak Kumar Rai
 * @created 23/11/23
 * @project scaler_course_code
 */
public class Q3_Find_max_xor_pair_value_1 {
    static class TrieNode {
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[2];
        }
    }
    static TrieNode root;

    static void insert(int num) {
        TrieNode current = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (current.children[bit] == null) {
                current.children[bit] = new TrieNode();
            }
            current = current.children[bit];
        }
    }

    static int findMaxXOR(int num) {
        TrieNode current = root;
        int maxXOR = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int flipBit = 1 - bit;

            if (current.children[flipBit] != null) {
                maxXOR |= (1 << i);
                current = current.children[flipBit];
            } else {
                current = current.children[bit];
            }
        }

        return maxXOR;
    }

    static int findMaxXORPair(int[] nums) {
        root = new TrieNode();
        int maxXORPair = Integer.MIN_VALUE;
        for (int num : nums) {
            insert(num);
            maxXORPair = Math.max(maxXORPair, findMaxXOR(num));
        }
        return maxXORPair;
    }

    public static void main(String[] args) {
        int[] nums = {22, 61, 38, 27, 21, 34, 42, 37, 43};;
        int maxXOR = findMaxXORPair(nums);
        System.out.println("Maximum XOR pair value: " + maxXOR);
    }
}
