package com.scaler.core.java_2_intermediate.dsa_23_recursion_1.assignment;

import com.scaler.core.utils.PrintUtils; /**
 * @created 11/10/22 8:45 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static int solve(String A) {
        int aSize = A.length();
        if (aSize <= 1)
            return aSize;
        return isPalindrome(A, 0, aSize - 1);
    }
    private static int isPalindrome(String A, int start, int end) {
        if (start >= end)
            return 1;
        if (A.charAt(start) != A.charAt(end))
            return 0;
        return isPalindrome(A, start + 1, end - 1);
    }
    public static void main(String[] args) {
        String  A = "naman";
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
