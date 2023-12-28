package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.assignment;

import java.util.Arrays;

/**
 * @created 19/09/22 5:09 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q5_Array_Rotation {
    /**
     * Q5. Array Rotation
     *
     * Problem Description
     * Given an integer array A of size N and an integer B, you have to return the same array after rotating
     * it B times towards the right.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <=109
     * 1 <= B <= 109
     *
     *
     * Input Format
     * The first argument given is the integer array A.
     * The second argument given is the integer B.
     *
     *
     * Output Format
     * Return the array A after rotating it B times to the right
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [1, 2, 3, 4]
     * B = 2
     * Input 2:
     *
     * A = [2, 5, 6]
     * B = 1
     *
     *
     * Example Output
     * Output 1:
     *
     * [3, 4, 1, 2]
     * Output 2:
     *
     * [6, 2, 5]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
     * Explanation 2:
     *
     * Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]
     * **/
    private static int[] solve(int[] arr, int B) {
        int n = arr.length;
        int k = B; // No. of rotations
        k = k % n;
        int i, j;
        // Reverse last k numbers
        for (i = n - k, j = n - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // Reverse the first n-k terms
        for (i = 0, j = n - k - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // Reverse the entire array
        for (i = 0, j = n - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Let n be the length of the array.
     * Rotating an array by n and 2 * n times gives the same results, i.e., rotating i or i % n times is the same.
     * So, we update B to B % n.
     *
     * When we rotate the array B times, B elements from the back end of the array come to the front
     * and the rest of the elements from the front shift backward.
     *
     * In this approach, we firstly reverse all the elements of the array.
     * Then, reversing the first B elements followed by reversing the rest N - B elements gives us the required result.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     * **/
    private static void reverse(int[] A, int start, int end) {
        int i, j;
        for (i = start, j = end; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
    private static int[] solve1(int[] A, int B) {
        int n = A.length;
        B = B % n;
        reverse(A, 0, n - 1);
        reverse(A, 0, B - 1);
        reverse(A, B, n - 1);
        return A;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int B = 2;
        int[] results = solve(A, B);
        System.out.println("Results : " + Arrays.toString(results));
        results = solve1(A, B);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
