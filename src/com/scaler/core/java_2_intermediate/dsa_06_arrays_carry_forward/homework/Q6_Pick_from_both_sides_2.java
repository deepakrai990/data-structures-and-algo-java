package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward.homework;

/**
 * @created 12/09/22 11:17 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q6_Pick_from_both_sides_2 {
    private static int solve_method1(int[] A, int B) {
        int n = A.length;
        int []suff = new int[n + 1];
        suff[n] = 0;
        suff[n - 1] = A[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suff[i] = A[i] + suff[i + 1];
        }
        int pref_sum = 0;
        int ans = suff[n - B];
        for(int i = 0; i < B; i++){
            pref_sum = pref_sum + A[i];
            int suff_sum = suff[n - B + (i + 1)];
            ans = Math.max(ans, pref_sum + suff_sum);
        }
        return ans;
    }
    private static int solve_method2(int[] A, int B) {
        int n = A.length;
        int cur = 0;
        for(int i = 0; i < B; i++){
            cur += A[i];
        }
        int back = B - 1;
        int ans = cur;
        for(int j = n - 1 ; j >= n-B; j--){
            cur += A[j];
            cur -= A[back];
            back--;
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {5, -2, 3 , 1, 2};
        int B = 3;
        int sum = solve_method1(A, B);
        System.out.println("method 1 sum : " + sum);
        sum = solve_method2(A, B);
        System.out.println("method 2 sum : " + sum);
    }
}
