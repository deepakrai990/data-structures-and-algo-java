package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_20_hashing_1_introduction_and_problems.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.*;

/**
 * @created 16/02/23 10:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int colorful(int A) {
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        while (A != 0) {
            int num = A % 10;
            numbers.add(num);
            A /= 10;
        }
        Collections.reverse(numbers);
        int n = numbers.size();
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                // prod stores the product of every digit in the range [i..j]
                prod *= numbers.get(j);
                // check if the product is unique
                if (hashSet.contains(prod))
                    return 0;
                hashSet.add(prod);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int  A = 23;
        int result = colorful(A);
        PrintUtils.printInt(result);
    }
}
