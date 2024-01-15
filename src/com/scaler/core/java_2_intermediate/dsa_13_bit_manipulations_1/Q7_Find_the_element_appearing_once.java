package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 05/01/24
 * @project scaler_course_code
 */
public class Q7_Find_the_element_appearing_once {
    private static int findSAppearingOnce(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 6, 3, 2, 6};

        int result = findSAppearingOnce(A);
        PrintUtils.print(result);
    }
}
