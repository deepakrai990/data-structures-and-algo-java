package com.scaler.core.java_2_intermediate.dsa_12_arrays_interview_problems_2.assignment;

/**
 * @created 17/09/22 9:22 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Q2. Special Index
     * <p>
     * Problem Description
     * Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element
     * from these indices makes the sum of even-indexed and odd-indexed array elements equal.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= n <= 105
     * -105 <= A[i] <= 105
     * <p>
     * <p>
     * Input Format
     * First argument contains an array A of integers of size N
     * <p>
     * <p>
     * Output Format
     * Return the count of array indices such that removing an element from these indices makes the sum of
     * even-indexed and odd-indexed array elements equal.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * A=[2, 1, 6, 4]
     * Input 2:
     * <p>
     * A=[1, 1, 1]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * 1
     * Output 2:
     * <p>
     * 3
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
     * Therefore, the required output is 1.
     * Explanation 2:
     * <p>
     * Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
     * Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
     * Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
     * Therefore, the required output is 3.
     **/
    private static int solve(int[] A) {
        int N = A.length;
        int[] oddPrefix = new int[N];
        int[] evenPrefix = new int[N];
        oddPrefix[0] = 0;
        evenPrefix[0] = A[0];
        for (int i = 1; i < N; i++) {
            if (i % 2 == 0) {
                evenPrefix[i] = evenPrefix[i - 1] + A[i];
                oddPrefix[i] = oddPrefix[i - 1];
            } else {
                evenPrefix[i] = evenPrefix[i - 1];
                oddPrefix[i] = oddPrefix[i - 1] + A[i];
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            int oddSum = 0;
            int evenSum = 0;
            evenSum = oddPrefix[N - 1] - oddPrefix[i];
            oddSum = evenPrefix[N - 1] - evenPrefix[i];
            if (i != 0) {
                evenSum = evenSum + evenPrefix[i - 1];
                oddSum = oddSum + oddPrefix[i - 1];
            }
            if (evenSum == oddSum) count++;
        }
        return count;
    }

    /**
     * Solution from Scaler
     **/
    private static int solve1(int A[]) {
        int N = A.length;
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 0;
        }

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                sumEven += A[i];
            } else {
                sumOdd += A[i];
            }
        }
        int currOdd = 0;
        int currEven = A[0];
        int res = 0;
        int newEvenSum = 0;
        int newOddSum = 0;
        for (int i = 1; i < N - 1; i++) {
            if (i % 2 == 1) {
                currOdd += A[i];
                newEvenSum = currEven + sumOdd - currOdd;
                newOddSum = currOdd + sumEven - currEven - A[i];
            } else {
                currEven += A[i];
                newOddSum = currOdd + sumEven - currEven;
                newEvenSum = currEven + sumOdd - currOdd - A[i];
            }
            if (newEvenSum == newOddSum) {
                res++;
            }
        }
        if (sumOdd == sumEven - A[0]) {
            res++;
        }
        if (N % 2 == 1) {
            if (sumOdd == sumEven - A[N - 1]) {
                res++;
            }
        } else {
            if (sumEven == sumOdd - A[N - 1]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 6, 4};
        int result = solve(A);
        System.out.println("Result : " + result);
    }
}
