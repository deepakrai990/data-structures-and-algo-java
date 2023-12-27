package com.scaler.core.java_3_advance_1.dsa_02_arrays_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Minimum_Swaps {
    private static int solve(int[] A, int B) {
        int N = A.length;
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(A[i] <= B) {
                count++;
            }
        }
        if(count <= 1) {
            return 0;
        }
        int countBad = 0;
        for(int i = 0; i < count; i++) {
            if(A[i] > B) {
                countBad++;
            }
        }
        int ans = countBad;
        int s = 1;
        int e = count;
        while(e < N) {
            if(A[s - 1] > B) {countBad--;}
            if(A[e] > B) {countBad++;}
            ans = Math.min(ans, countBad);
            s++;
            e++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 12, 10, 3, 14, 10, 5};
        int B = 8;
        int minimumSwap = solve(A, B);
        PrintUtils.printInt(minimumSwap);
        // System.out.println("minimumSwap : " + minimumSwap);
    }
}
