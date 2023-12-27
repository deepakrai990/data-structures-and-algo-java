package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_04_bit_manipulations_1.assignment;

import java.util.Arrays;
import java.util.List;

/**
 * @created 10/02/23 8:13 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    private static int singleNumber(final List<Integer> A) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // we calculate set-bit count at every position from 0 to 31
            int setBitCount = 0;
            for (int j = 0; j < A.size(); j++) {
                if ((1 << i & A.get(j)) > 0) {
                    setBitCount++;
                }
            }
            // if setBitCount is not a divisor of 3, it means the unique number has a set bit at this position
            if (setBitCount % 3 != 0) {
                // add the corresponding base value (i.e. power of 2 which is 1 << i)
                res += 1 << i;
            }
        }
        return res;
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int singleNumber1(final Integer[] A) {
        int[] bits = new int[32];
        // check frequency of each bit
        for (int num : A) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (1 & (num >> i));
                bits[i] %= 3;
            }
        }
        int number = 0;
        for (int i = 31; i >= 0; i--) {
            number = number * 2 + bits[i];
        }
        return number;
    }

    public static void main(String[] args) {
        Integer[] A = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        List<Integer> Alist = Arrays.asList(A);
        int result = singleNumber(Alist);
        System.out.printf("%s%5d", "Result: ", result);
        System.out.println();
        int result1 = singleNumber1(A);
        System.out.printf("%s%5d", "Result: ", result1);
    }
}
