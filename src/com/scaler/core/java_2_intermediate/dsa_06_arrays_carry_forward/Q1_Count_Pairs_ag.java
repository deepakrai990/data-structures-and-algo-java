package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward;

/**
 * @created 11/09/22 10:54 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Count_Pairs_ag {
    /**
     * Brute Force Approach     *  1
     * **/
    private static int countPairs(char[] chars) {
        int N = chars.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (chars[i] == 'a' && chars[j] == 'g') {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * Approach     *  2
     * **/
    private static int countPairsApproachTwo(char[] chars) {
        int N = chars.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (chars[i] == 'a') {
                for (int j = i + 1; j < N; j++) {
                    if (chars[j] == 'g') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Approach     *  3
     * Using Carry Forward (RHS -> LHS)
     * **/
    private static int countPairsUsingCarryForward(char[] chars) {
        int N = chars.length;
        int count_g_char = 0;
        int ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (chars[i] == 'g') {
                count_g_char++;
            } else if (chars[i] == 'a') {
                ans += count_g_char;
            }
        }
        return ans;
    }
    /**
     * Approach     *  4
     * Using Carry Forward (LHS -> RHS)
     * **/
    private static int countPairsWithCarryForwardLHSToRHS(char[] chars) {
        int N = chars.length;
        int count_a_char = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (chars[i] == 'a') {
                count_a_char++;
            } else if (chars[i] == 'g') {
                ans += count_a_char;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] chars = {'b', 'a', 'a', 'g' ,'d', 'c', 'a', 'g'};
        char[] chars1 = {'b', 'c', 'a', 'g' ,'g', 'a', 'a', 'g'};
        char[] chars2 = {'a', 'c', 'g', 'd' ,'g', 'a', 'g'};
        int pairs = countPairs(chars);
        System.out.println("Approach 1 Pairs of ag Count : " +pairs);
        pairs = countPairs(chars1);
        System.out.println("Approach 1 Pairs of ag Count : " +pairs);
        pairs = countPairs(chars2);
        System.out.println("Approach 1 Pairs of ag Count : " +pairs);
        pairs = countPairsApproachTwo(chars);
        System.out.println("Approach 2 Pairs of ag Count : " +pairs);
        pairs = countPairsUsingCarryForward(chars);
        System.out.println("Approach 3 Using Carry Forward Pairs of ag Count : " +pairs);
        pairs = countPairsWithCarryForwardLHSToRHS(chars2);
        System.out.println("Approach 4 Using Carry Forward (LHS -> RHS) Pairs of ag Count : " +pairs);
    }
}
