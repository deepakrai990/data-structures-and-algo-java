package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_18_searching_3_binary_search_on_answer;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 13/02/23 3:28 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Question 2. Find A^th magical number
     * A number is magical if it is divisible by B or C.
     * Example:- B = 2, C = 3, A = 8
     * **/
    private static int findMagicalNumber(int B, int C, int A) {
        int low = 1, high = A * Math.min(B, C);
        int ans = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countOfMagicalNumbers(B, C, mid);
            if (count == A) {
                ans = mid;
                high = mid - 1;
            } else if (count < A) low = mid + 1;
            else high = mid - 1;
        }
        return ans;
    }
    private static int countOfMagicalNumbers(int B, int C, int mid) {
        int countB = mid / B;
        int countC = mid / C;
        int commonFactors = mid / lcm(B, C);
        return (countB + countC - commonFactors);
    }
    private static int lcm(int A, int B) {
        return (A * B) / gcd(A, B);
    }
    private static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
    public static void main(String[] args) {
        int B = 2, C = 3, A = 8;
        int result = findMagicalNumber(B, C, A);
        PrintUtils.printInt(result);
    }
}
