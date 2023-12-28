package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.homework;

/**
 * @created 19/09/22 8:13 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Second_Largest {
    /**
     * Q3. Second Largest
     * <p>
     * Problem Description
     * You are given an integer array A. You have to find the second largest element/value in the array or report
     * that no such element exists.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= |A| <= 105
     * <p>
     * 0 <= A[i] <= 109
     * <p>
     * <p>
     * <p>
     * Input Format
     * The first argument is an integer array A.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return the second largest element. If no such element exist then return -1.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [2, 1, 2]
     * Input 2:
     * <p>
     * A = [2]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 2
     * Output 2:
     * <p>
     * -1
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * First largest element = 2
     * Second largest element = 2
     * Third largest element = 1
     * Explanation 2:
     * <p>
     * There is no second largest element in the array.
     **/
    private static int solve(int[] A) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = -1;
        if (A.length < 2)
            return secondHighest;
        for (int i = 0; i < A.length; i++) {

            if (A[i] > highest) {
                secondHighest = highest;
                highest = A[i];
            } else if (A[i] > secondHighest) {
                secondHighest = A[i];
            }
        }
        return secondHighest;
    }

    /**
     * Scaler Solution
     * First, we find out the index/position of the largest element in the array. If there are multiple such indices,
     * we can use any
     * such index. Then using it, we can find the largest value present in the array, excluding
     * the largest element index.
     **/
    private static int solve1(int[] A) {
        int index = 0, n = A.length;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[index]) {
                index = i;
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (i != index) {
                ans = Math.max(ans, A[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        int result = solve(A);
        System.out.println("result : " + result);
        result = solve1(A);
        System.out.println("result : " + result);
    }
}
