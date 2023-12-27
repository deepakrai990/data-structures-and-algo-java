package com.scaler.core.java_2_intermediate.dsa_24_recursion_2.homework;

import com.scaler.core.utils.PrintUtils; /**
 * @created 13/10/22 9:02 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int solve(int A) {
        if(A <= 9 && A == 1) return 1; // For Bsse Case 1
        if(A <= 9 && A != 1) return 0; // For Bsse Case 2
        else
            A = digitSum(A);
        return 0 + solve(A);
    }
    private static int digitSum(int num){
        if(num <= 0) return 0; // For Bsse Case 1
        int rem = num % 10;
        num /= 10;
        return rem + digitSum(num);
    }

    public static void main(String[] args) {
        int A = 83557;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
