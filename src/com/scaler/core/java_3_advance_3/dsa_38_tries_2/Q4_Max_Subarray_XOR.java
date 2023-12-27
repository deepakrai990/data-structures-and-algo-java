package com.scaler.core.java_3_advance_3.dsa_38_tries_2;

/**
 * @author Deepak Kumar Rai
 * @created 23/11/23
 * @project scaler_course_code
 */
public class Q4_Max_Subarray_XOR {
    static class TrieNode {
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[2];
        }
    }
    /**
     * Question: Max Subarray XOR
     * Given A[N], return max subarray XOR.
     * Note: For single element XOR is itself.
     * **/
    static TrieNode root;
    private static void insert(int num) {
        TrieNode current = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (current.children[bit] == null) {
                current.children[bit] = new TrieNode();
            }
            current = current.children[bit];
        }
    }
    private static int findMaxXOR(int num) {
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
    private static int findMaxSubarrayXOR(int[] nums) {
        root = new TrieNode();
        int maxXOR = Integer.MIN_VALUE;
        int currentXOR = 0;

        for (int num : nums) {
            currentXOR ^= num;
            insert(currentXOR);
            maxXOR = Math.max(maxXOR, findMaxXOR(currentXOR));
        }

        return maxXOR;
    }
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int maxSubarrayXOR = findMaxSubarrayXOR(nums);
        System.out.println("Maximum XOR value for any pair in the subarray: " + maxSubarrayXOR);
    }
}
