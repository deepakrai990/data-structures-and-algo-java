package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward.assignment;

/**
 * @created 12/09/22 11:28 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Special_Subsequences_AG {
    /**
     * Q3. Special Subsequences "AG"
     * <p>
     * Problem Description
     * You have given a string A having Uppercase English letters.
     * <p>
     * You have to find how many times subsequence "AG" is there in the given string.
     * <p>
     * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= length(A) <= 105
     * <p>
     * <p>
     * <p>
     * Input Format
     * First and only argument is a string A.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return an integer denoting the answer.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = "ABCGAG"
     * Input 2:
     * <p>
     * A = "GAB"
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 3
     * Output 2:
     * <p>
     * 0
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Subsequence "AG" is 3 times in given string
     * Explanation 2:
     * <p>
     * There is no subsequence "AG" in the given string.
     **/
    private static int solve(String A) {
        long count = 0l;
        long ans = 0l;
        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) == 'G') {
                count++;
            } else if (A.charAt(i) == 'A') {
                ans += count;
            }
        }
        return (int) (ans % 1000000007);
    }

    /**
     * Solution
     **/
    private static int solve_solution(String A) {
        int n = A.length(), ans = 0, MOD = 1000 * 1000 * 1000 + 7;
        int cnt_G[] = new int[n], count = 0;
        //Suffix count of G
        for (int i = n - 1; i >= 0; i--) {
            if (A.charAt(i) == 'G')
                count = count + 1;
            cnt_G[i] = count;
        }
        // traverse the string again from beginning
        for (int i = 0; i < n; i++) {
            // if current character is "A" then add number of G's after that
            if (A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
                ans = ans % MOD;
            }
        }
        return ans;
    }

    /**
     * Scaler Solution
     * Approach
     * <p>
     * Hint 1
     * The main task is to find the number of times subsequence “AG” appears in a string.
     * Can count of A’s and G’s in the given string help in any way?
     * <p>
     * Solution Approach
     * Approach 1
     * <p>
     * The main task is to find the number of times subsequence “AG” appears in a string.
     * Simply find the number of G’s after any index i by taking suffix sum.
     * Then traverse the string again, and when you encounter an ‘A’, add the number of G’s after that to the answer.
     * <p>
     * Time Complexity : O(n)
     * Space Complexity (extra) : O(n)
     * <p>
     * where ‘n’ is the length of the string A.
     * <p>
     * This solution is enough to pass the test casses.
     * However , Do we really need O(n) space? Can you think of a solution with constant space?
     * <p>
     * Approach 2(memory efficient)
     * <p>
     * This is just a modification of the previous approach.
     * Instead of keeping a suffix array for count of G’s , we can instead keep a variable ‘g’ storing count of G’s and iterate in the reverse order.
     * If the current character is ‘G’ , increment g.
     * If the current character is ‘A’ , add g to our answer.
     * <p>
     * for i from n-1 to 0
     * if A[i]=='G'
     * g++
     * else
     * ans+=g
     * ans%=mod
     * <p>
     * Time complexity : O(n)
     * Space complexity : O(1)
     **/
    private static int solve1(String A) {
        int n = A.length(), ans = 0, MOD = 1000 * 1000 * 1000 + 7;
        int cnt_G[] = new int[n], count = 0;
        //Suffix count of G
        for (int i = n - 1; i >= 0; i--) {
            if (A.charAt(i) == 'G')
                count = count + 1;
            cnt_G[i] = count;
        }
        // traverse the string again from beginning
        for (int i = 0; i < n; i++) {
            // if current character is "A" then add number of G's after that
            if (A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
                ans = ans % MOD;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "ABCGAG";
        int result = solve(A);
        System.out.println("result : " + result);
        result = solve_solution(A);
        System.out.println("result : " + result);
        result = solve1(A);
        System.out.println("result : " + result);
    }
}