package com.scaler.core.java_3_advance_2.dsa_11_recursion_2.homework;

/**
 * @created 02/04/23 7:38 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Gray_Code {
    private static int[] grayCode(int A) {
        //base case
        if (A == 1)
            return new int[]{0, 1};
        //ans array of 2^n length
        int l1 = (int) Math.pow(2, A);
        int[] ans = new int[l1];
        //to  store prev grayCode of 2^n-1 length
        int l2 = (int) Math.pow(2, A - 1);
        int[] prev = new int[l2];
        prev = grayCode(A - 1);  //recursion call
        int i;
        //Add prev array element in order to ans array
        for (i = 0; i < l2; i++) {
            ans[i] = prev[i];
        }
        //Add 2^n-1 to all the prev array element in reverse order to ans array
        for (int j = l2 - 1; j >= 0; j--) {
            ans[i++] = prev[j] + l2;
        }
        // [0 1 1+2^1 0+2^1] = [0 1 3 2]
        return ans;
    }
}
