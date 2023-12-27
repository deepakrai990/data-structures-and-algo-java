package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_17_searching_2_binary_search_problems.assignment;

import java.util.List;

/**
 * @created 07/02/23 7:57 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    // DO NOT MODIFY BOTH THE LISTS
    private static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int m = a.size();
        int n = b.size();
        if (m > n) {
            return findMedianSortedArrays(b, a);
        }
        int start = 0;
        int end = m;
        int medianPos = ((m + n) + 1) / 2;
        while (start <= end) {
            int cut1 = (start + end) / 2;
            int cut2 = medianPos - cut1;
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a.get(cut1 - 1);
            int l2 = (cut2 == 0) ? Integer.MAX_VALUE : b.get(cut2 - 1);
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : a.get(cut1);
            int r2 = (cut2 == n) ? Integer.MIN_VALUE : b.get(cut2);
            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 != 0) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                end = cut1 - 1;
            } else {
                start = cut1 + 1;
            }
        }
        return 0.0;
    }
}
