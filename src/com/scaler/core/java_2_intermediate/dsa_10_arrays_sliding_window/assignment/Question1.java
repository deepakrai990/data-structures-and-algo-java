package com.scaler.core.java_2_intermediate.dsa_10_arrays_sliding_window.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 13/09/22 2:24 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int solve(int[] A, int B, int C) {
        int sum = 0;
        for(int i = 0 ; i < A.length ; i++){
            sum += A[i];
            if(i >= B){
                sum -= A[i - B];
            }
            if(sum == C && i >= B - 1){
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        int B = 2;
        int C = 5;
        int subarrayCount = solve(A, B, C);
        PrintUtils.printInt(subarrayCount);
    }
}
