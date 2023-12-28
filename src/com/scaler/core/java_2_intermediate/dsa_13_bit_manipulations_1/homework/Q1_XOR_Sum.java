package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.homework;

/**
 * @created 21/09/22 3:58 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_XOR_Sum {
    /**
     * Q1. XOR Sum
     *
     * Problem Description
     * Given two integers A and B. Find the minimum value (A ⊕ X) + (B ⊕ X) that can be achieved for any X.
     *
     * where P ⊕ Q is the bitwise XOR operation of the two numbers P and Q.
     *
     *
     * Problem Constraints
     * 1 <= A, B <= 109
     *
     *
     * Input Format
     * The first argument is a single integer A.
     * The second argument is a single integer B.
     *
     *
     * Output Format
     * Return the minimum value (A ⊕ X) + (B ⊕ X) that can be achieved for any X.
     *
     *
     * Example Input
     * Input 1:-
     * A = 6
     * B = 12
     * Input 2:-
     * A = 4
     * B = 9
     *
     *
     * Example Output
     * Output 1:-
     * 10
     * output 2:-
     * 13
     *
     *
     * Example Explanation
     * Expanation 1:-
     * X ^ A + X ^ B = 10 when X = 8
     * Explanation 2:-
     * X ^ A + X ^ B = 13 when X = 1
     * **/
    private static int solve(int A, int B) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            if (((1 << i) & A) != ((1 << i) & B)) {
                res |= (1 << i);
            }
        }
        return res;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Hint 1
     * We can choose any X. So lets try to choose optimally. Say for any ith bit in binary values of A and B,
     * the bit is set for both A and B.
     * Then we can also set it in X such that XOR with both becomes 0.
     * Similarly, if for both A and B the bit was unset, we unset it for X as well. XOR of that bit remains 0.
     * Now try to think if the bit is set for one and unset for other what will X and our result be.
     *
     * Solution Approach
     * We can choose any X. So lets try to choose optimally. Say for any ith bit in binary values of A and B,
     * the bit is set for both A and B.
     * Then we can also set it in X such that XOR with both becomes 0.
     * Similarly, if for both A and B the bit was unset, we unset it for X as well. XOR of that bit remains 0.
     * Now try to think if the bit is set for one and unset for other what will X and our result be.
     *
     * That's right doesnt matter if the bit is set or unset that bit will be added to our answer
     * as either A ^ X != 0 or B ^ X != 0 for that bit.
     * Now did you take the observation? If we are adding a bit to out answer if that bit is set for
     * one number and unset for another,
     * then it is A ^ B operation itself. So A ^ B is our answer.
     * **/
    private static int solve1(int A, int B) {
        return A^B;
    }
    public static void main(String[] args) {
        int A = 6;
        int B = 12;
        int result = solve(A, B);
        System.out.println("Result " + result);
        result = solve1(A, B);
        System.out.println("Result " + result);
    }
}
