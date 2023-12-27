package com.scaler.core.java_2_intermediate.dsa_05_arrays_prefix_sum;

/**
 * @created 03/09/22 6:49 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main2 {

    private static int prefixSumFromRangeSum(int[] prefixSum, int L, int R) {
        int sum = 0;
        if (L == 0) {
            sum = prefixSum[R];
        } else {
            sum = prefixSum[R] - prefixSum[L - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prefixSum = {-2, 4, 1, 5, 2};
        int result = prefixSumFromRangeSum(prefixSum, 1, 2);
        System.out.println("result: " + result);
    }
}
