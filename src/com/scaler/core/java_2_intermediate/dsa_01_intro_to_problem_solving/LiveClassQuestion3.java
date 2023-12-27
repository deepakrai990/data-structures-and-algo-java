package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving;

/**
 * @created 09/09/22 7:42 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {
    /**
     * Given N, find floor squire root of N
     * **/
    private static int floorSqrt(int N) {
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (i * i <= N) {
                ans = i;
            } else
                break;;
        }
        return ans;
    }
    public static void main(String[] args) {
        int N = 65;
        int sqrtValue = floorSqrt(N);
        System.out.println("sqrtValue : " + sqrtValue);
    }
}
