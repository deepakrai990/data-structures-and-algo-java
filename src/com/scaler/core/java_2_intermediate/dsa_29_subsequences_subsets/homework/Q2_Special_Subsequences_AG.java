package com.scaler.core.java_2_intermediate.dsa_29_subsequences_subsets.homework;

/**
 * @created 05/03/23 6:07 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Special_Subsequences_AG {
    public int solve(String A) {
        long countOfA = 0;
        long countOfAG = 0;
        int modulo = (int) (Math.pow(10, 9) + 7);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'A')
                countOfA++;
            else if (A.charAt(i) == 'G')
                countOfAG += countOfA;
        }
        return (int) (countOfAG % modulo);
    }
}
