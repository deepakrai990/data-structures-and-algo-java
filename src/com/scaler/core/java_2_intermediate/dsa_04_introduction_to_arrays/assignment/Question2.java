package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 19/09/22 4:59 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Q2. Good Pair
     * <p>
     * Problem Description
     * Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B).
     * Check if any good pair exist or not.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A.size() <= 104
     * <p>
     * 1 <= A[i] <= 109
     * <p>
     * 1 <= B <= 109
     * <p>
     * <p>
     * <p>
     * Input Format
     * First argument is an integer array A.
     * <p>
     * Second argument is an integer B.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return 1 if good pair exist otherwise return 0.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [1,2,3,4]
     * B = 7
     * Input 2:
     * <p>
     * A = [1,2,4]
     * B = 4
     * Input 3:
     * <p>
     * A = [1,2,2]
     * B = 4
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 1
     * Output 2:
     * <p>
     * 0
     * Output 3:
     * <p>
     * 1
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * (i,j) = (3,4)
     * Explanation 2:
     * <p>
     * No pair has sum equal to 4.
     * Explanation 3:
     * <p>
     * (i,j) = (2,3)
     **/
    private static int solve(int[] A, int B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if ((A[i] + A[j]) == B) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * Scaler Solution
     * Approach 1
     * <p>
     * For every i run a loop of j and check if A[i]+A[j]==B or not. Also, check if i!=j.
     * <p>
     * Time complexity : O(n^2)
     * <p>
     * This is enough to pass the test casses. However we can furthur optimize this solution.
     * <p>
     * Approach 2
     * <p>
     * Sort the array A in increasing order. For each i from 0 to n-1 find the first element in the array having a value greater than or equal to B-A[i] using binary search.
     * (For c++ we can directly use ‘lower_bound’ function) . Now just check if this element is equal to B-A[i] , if it is then return 1 , otherwise continue the process.
     * <p>
     * Time complexity : O(nlogn)
     **/
    private static int solve1(int[] A, int B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i == j) continue;
                if (A[i] + A[j] == B) return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int B = 7;
        int result = solve(A, B);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        result = solve1(A, B);
        PrintUtils.printInt(result);
    }
}
