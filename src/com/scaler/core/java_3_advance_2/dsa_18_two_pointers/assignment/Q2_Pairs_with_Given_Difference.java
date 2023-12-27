package com.scaler.core.java_3_advance_2.dsa_18_two_pointers.assignment;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @created 02/04/23 7:10 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Pairs_with_Given_Difference {
    private static int solve(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;
        int i = 0, j = 1;
        int diff = Integer.MIN_VALUE;

        // Use HashMap to store unique pairs & discard repeated pairs
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (i < n && j < n) {
            diff = A[j] - A[i];
            if (diff < B) {
                j++;
            } else if (diff > B) {
                i++;
            } else if (diff == B) {
                if (i != j) hm.put(A[i], A[j]);
                i++;
            }
        }
        return hm.size();
    }

    private static int solve1(int[] A, int B) {
        int n = A.length;
        int count = 0;
        Arrays.sort(A);
        int p1 = 0, p2 = 1;
        while (p2 < n) {
            if (A[p2] - A[p1] == B) {
                count++;
                int a = A[p1], b = A[p2];
                while (p1 < n && A[p1] == a) {
                    p1++;
                }
                while (p2 < n && A[p2] == b) {
                    p2++;
                }

            } else if (A[p2] - A[p1] < B) {
                p2++;
            } else if (A[p2] - A[p1] > B) {
                p1++;
            }

            if (p1 == p2)
                p2++;
        }
        return count;
    }
}
