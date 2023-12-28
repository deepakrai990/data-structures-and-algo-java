package com.scaler.core.java_2_intermediate.dsa_24_recursion_2.assignment;

/**
 * @created 13/10/22 8:42 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Implement_Power_Function {
    /**
     * Q1. Implement Power Function
     * Problem Description
     * Implement pow(A, B) % C.
     * In other words, given A, B and C, Find (AB % C).
     *
     * Note: The remainders on division cannot be negative. In other words, make sure the answer
     * you return is non-negative.
     *
     *
     *
     * Problem Constraints
     * -109 <= A <= 109
     * 0 <= B <= 109
     * 1 <= C <= 109
     *
     *
     * Input Format
     * Given three integers A, B, C.
     *
     *
     * Output Format
     * Return an integer.
     *
     *
     * Example Input
     * A = 2, B = 3, C = 3
     *
     *
     * Example Output
     * 2
     *
     *
     * Example Explanation
     * 23 % 3 = 8 % 3 = 2
     * **/
    private static int pow(int A, int B, int C) {
        if(A < 0 ) A = C + A; // for negative number
        if(A == 0) return 0; // for if A value is 0
        if(B == 0) return 1; // Base condition
        long p = pow(A , B/2 , C);
        if(B % 2 == 0)
            return (int) (p % C * p % C ) % C;
        else
            return (int) ((p % C * p % C) % C * A % C) % C;
    }
    /**
     * Scaler Solution
     *
     * Hint 1
     * You need to develop a solution better than O(n).
     *
     * Think recursively. You can think of an example like 2^8. How many multiplications do you really
     * need to evaluate 2^8?
     *
     * Solution Approach
     * There are two important things to note here:
     *
     * 1) Overflow situation: Note that if x is large enough, multiplying x to the answer might overflow in integer.
     *
     * 2) Multiplying x one by one to the answer is O(n). We are looking for something better than O(n).
     *
     * If n is even, note the following:
     *
     * x ^ n = (x * x) ^ n/2
     *
     * Can you use the above observation to develop a solution better than O(n)?
     * **/
    /**
     * Method 1:
     * **/
    private static int pow1(int x, int n, int d) {
        long a = x;
        long res = 1L;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= a;
                res %= d;
            }
            a *= a;
            a %= d;
            n = n >> 1;
        }
        res = (res + d) % d;
        return (int) res;
    }
    /**
     * Method 1:
     * **/
    private static int pow2(int A, int B, int C) {
        if(A == 0)
            return 0;
        if(B == 0)
            return 1;
        long ans = pow(A, B / 2, C);
        ans = (ans * ans) % C;
        if(B % 2 == 1)
            ans = (ans * A);
        ans = (ans + C) % C;
        return (int)ans;
    }
    public static void main(String[] args) {
        int A = 2, B = 3, C = 3;
        int result = pow(A, B, C);
        System.out.println("Result : " + result);
    }
}
