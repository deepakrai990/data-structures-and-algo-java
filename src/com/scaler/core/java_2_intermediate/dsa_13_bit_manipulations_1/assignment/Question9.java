package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @created 20/09/22 1:23 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question9 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int singleNumber(final int[] A) {
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }
    /**
     * Scaler Solution
     *
     * Hint 1
     * Let us look at every bit’s position.
     *
     * Every number that occurs twice will either contribute 2 ‘1’s or 2 ‘0’s to the position.
     * The number that occurs once-‘X’ will contribute exactly one 0 or 1 to the position depending on whether
     * it has 0 or 1 in that position.
     *
     * So:
     * If X has 1 in that position, we will have an odd number of 1s in that position.
     * If X has 0 in that position, we will have an odd number of 0s in that position.
     * Can you think of a solution using the above observation?
     *
     * Solution Approach
     * We have noticed that if X has 1 in that position, we will have an odd number of 1s in that position.
     *
     * If X has 0 in that position, we will have an odd number of 0 in that position.
     *
     * Looking at the bit operators, XOR is what we need.
     *
     * XOR will return 1 only on two different bits. So if two numbers are the same, XOR will return 0.
     *
     * Finally, there is only one number left.
     *
     * A ^ A = 0 and A ^ B ^ A = B.
     *
     * So, all the even occurrences will cancel out using XOR.
     *
     * Time Complexity : O(n)
     * Space Complexity(extra) : O(1)
     * **/
    // DO NOT MODIFY THE LIST
    private static int singleNumber1(final List<Integer> A) {
        int num = 0;
        for (int val: A) {
            num ^= val;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 1};
        int result = singleNumber(A);
        System.out.println("Result : " + result);
        List<Integer> list = IntStream.of(A).boxed().collect(Collectors.toCollection(ArrayList::new));
        result = singleNumber1(list);
        System.out.println("Result : " + result);

    }
}
