package com.scaler.core.java_2_intermediate.dsa_12_arrays_interview_problems_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 17/09/22 6:10 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Special_Index {
    /**
     * Problem: Special Index {Hard} -> {Google}
     * An index is said to be special if after deleting the index sum of all even indexes is equals to
     * the sum of all odd indexes.
     * Count the number of special indexes in the array
     * **/
    // Bruteforce Approach
    private static int countSpecialIndexes(int[] A) {
        int N = A.length;
        int count = 0;
        // Iterate through each index in the array
        for (int i = 0; i < N; i++) {
            // Delete the element at index i
            int[] copiedArray = new int[N - 1];
            int indexInCopiedArray = 0;
            for (int j = 0; j < N; j++) {
                if (j != i) {
                    copiedArray[indexInCopiedArray] = A[j];
                    indexInCopiedArray++;
                }
            }
            // Calculate the sum of elements at even and odd indices for the updated array
            int sumEven = 0;
            int sumOdd = 0;
            for (int j = 0; j < indexInCopiedArray; j++) {
                if (j % 2 == 0) {
                    sumEven += copiedArray[j];
                } else {
                    sumOdd += copiedArray[j];
                }
            }
            // Check if the sums are equal and increment count id true
            if (sumEven == sumOdd) {
                count++;
            }
        }
        return count;
    }
    // Optimise approach 1
    private static int countSpecialIndexes1(int[] A) {
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
            int oddSum = evenPrefix[N - 1] - evenPrefix[i];
            int evenSum = oddPrefix[N - 1] - oddPrefix[i];
            if (i != 0) {
                evenSum = evenSum + evenPrefix[i - 1];
                oddSum = oddSum + oddPrefix[i - 1];
            }
            if (evenSum == oddSum) count++;
        }
        return count;
    }
    // Optimise approach 2
    private static int countSpecialIndexes2(int[] A) {
        int N = A.length;
        int[] prefixOdd = createOddPrefix(A);
        int[] prefixEven = createEvenPrefix(A);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int sumEven = prefixOdd[N - 1] - prefixOdd[i];
            if (i != 0) {
                sumEven = sumEven + prefixEven[i - 1];
            }
            int sumOdd = prefixEven[N - 1] - prefixEven[i];
            if (i != 0) {
                sumOdd = sumOdd + prefixOdd[i - 1];
            }
            if (sumEven == sumOdd) {
                count++;
            }
        }
        return count;
    }
    private static int[] createOddPrefix(int[] A) {
        int N = A.length;
        int[] oddPrefix = new int[N];
        oddPrefix[0] = 0; // the first index is 0 it will be always even
        for (int i = 1; i < N; i++) {
            if (i % 2 == 0) {
                oddPrefix[i] = oddPrefix[i - 1];
            } else {
                oddPrefix[i] = oddPrefix[i - 1] + A[i];
            }
        }
        return oddPrefix;
    }
    private static int[] createEvenPrefix(int[] A) {
        int N = A.length;
        int[] evenPrefix = new int[N];
        evenPrefix[0] = A[0]; // the first index is 0 it will be always even
        for (int i = 1; i < N; i++) {
            if (i % 2 == 0) {
                evenPrefix[i] = evenPrefix[i - 1] + A[i];
            } else {
                evenPrefix[i] = evenPrefix[i - 1];
            }
        }
        return evenPrefix;
    }
    public static void main(String[] args) {
        int[] A = {2, 1, 3, 0, 6, 7, 3, 4, 5, 6, 10, 2}; // {4, 3, 2, 7, 6, -2};

        int result = countSpecialIndexes(A);
        PrintUtils.print(result);

        result = countSpecialIndexes1(A);
        PrintUtils.print(result);

        result = countSpecialIndexes2(A);
        PrintUtils.print(result);
    }
}
