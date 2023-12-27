package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward.homework;

/**
 * @created 12/09/22 11:20 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework7 {
    /**
     * Q7. Even Subarrays
     *
     * Problem Description
     * You are given an integer array A.
     *
     * Decide whether it is possible to divide the array into one or more subarrays of even length such that the
     * first and last element of all subarrays will be even.
     *
     * Return "YES" if it is possible; otherwise, return "NO" (without quotes).
     *
     *
     *
     * Problem Constraints
     * 1 <= |A|, A[i] <= 106
     *
     *
     *
     * Input Format
     * The first and the only input argument is an integer array, A.
     *
     *
     *
     * Output Format
     * Return a string "YES" or "NO" denoting the answer.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [2, 4, 8, 6]
     * Input 2:
     *
     *  A = [2, 4, 8, 7, 6]
     *
     *
     * Example Output
     * Output 1:
     *
     *  "YES"
     * Output 2:
     *
     *  "NO"
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  We can divide A into [2, 4] and [8, 6].
     * Explanation 2:
     *
     *  There is no way to divide the array into even length subarrays.
     * **/
    private static String solve(int[] A) {
        if(A.length % 2 != 0 || A[0] % 2 != 0 || A[A.length - 1] % 2 !=0) {
            return "NO";
        } else {
            return "YES";
        }
    }
    /**
     * Scaler Solution
     *
     * Hint 1
     * Try to find a pattern in this question. For some particular cases, the answer is always going to Yes
     * and No otherwise.
     * Try to make that observation.
     *
     * Solution Approach
     * If the first and the last element are even and the size of the array is even, then only the answer will be “YES.”
     * Otherwise will be “NO,” as we can’t divide the array into subarrays that meet the given conditions in the question.
     *
     * So, if(A[0]%2 == 0 and A[n-1]%2 == 0 and n%2 == 0)
     * return “YES”;
     *
     * **/
    private static String solve1(int[] A) {
        int n = (int)A.length;
        if(A[0]%2 == 0 && A[n-1]%2 == 0 && n%2 == 0)
            return "YES";
        return "NO";
    }
    public static void main(String[] args) {
        int[] A = {2, 4, 8, 7, 6};
        int[] B = {2, 4, 8, 6};
        String isEven = solve(A);
        System.out.println("isEven : " + isEven);
        isEven = solve(B);
        System.out.println("isEven : " + isEven);
        isEven = solve1(B);
        System.out.println("isEven : " + isEven);
    }
}
