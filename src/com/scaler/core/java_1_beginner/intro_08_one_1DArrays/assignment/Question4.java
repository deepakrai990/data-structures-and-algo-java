package com.scaler.core.java_1_beginner.intro_08_one_1DArrays.assignment;

import java.util.Arrays;

/**
 * @created 06/08/22 8:12 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Q4. Copy the Array
     *
     * Problem Description
     *
     * You are given a constant array A and an integer B.
     *
     * You are required to return another array where outArr[i] = A[i] + B.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A.size() <= 10000
     *
     * 1 <= A[i] <= 10000
     *
     * 1 <= B <= 10000
     *
     *
     *
     * Input Format
     *
     * First argument is a constant array A.
     *
     * Second argument is an integer B.
     *
     *
     *
     * Output Format
     *
     * You have to return an integer array.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * A = [1,2,3,2,1]
     * B = 3
     * Input 2:
     *
     * A = [1,1,10]
     * B = 6
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  [4,5,6,5,4]
     * Output 2:
     *
     *  [7,7,16]
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * A[0] + 3 = 1 + 3 = 4
     * A[1] + 3 = 2 + 3 = 5
     * A[2] + 3 = 3 + 3 = 6
     * A[3] + 3 = 2 + 3 = 5
     * A[4] + 3 = 1 + 3 = 4
     * **/
    public int[] solve1(final int[] A, int B) {
        int[] arr = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            arr[i] = A[i] + B;
        }
        return arr;
    }
    private static int[] solve(final int[] A, int B) {
        int n = A.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++) {
            ans[i] = A[i]+B;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int B = 3;
        int[] resultArr = solve(A, B);
        System.out.println(Arrays.toString(resultArr));
    }
}
