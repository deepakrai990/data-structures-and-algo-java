package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 20/02/23 8:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int solve(int[] A, int B) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int size = A.length;
        // Traverse the array
        for (int i = 0; i < size; i++) {
            // Update frequency
            // of A[i]
            mpp.put(A[i], mpp.getOrDefault(A[i], 0) + 1);
            // Check if any element whose frequency
            // is greater than 1 exist or not for B == 0
            if (B == 0 && mpp.get(A[i]) > 1) return 1;
        }
        // Check if difference is zero, and
        // we are unable to find any duplicate or
        // element whose frequency is greater than 1
        // then no such pair found.
        if (B == 0) return 0;

        for (int i = 0; i < size; i++) {
            if (mpp.containsKey(B + A[i])) {
                //System.out.print("Pair Found: (" + A[i] + ", " + + (n + A[i]) + ")");
                return 1;
            }
        }
        // System.out.print("No Pair found");
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {5, 10, 3, 2, 50, 80};
        int B = 78;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
