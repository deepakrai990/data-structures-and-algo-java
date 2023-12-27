package com.scaler.core.java_3_advance_2.dsa_15_binary_search_1.homework;

import java.util.List;

/**
 * @created 02/04/23 7:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Median_of_Array {
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
    private static double findMedianSortedArrays_1(final List<Integer> A, final List<Integer> B) {
        int len = A.size() + B.size();
        if(len % 2 == 1)
            return findKth(A, 0, B, 0, len / 2 + 1);
        else return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    }
    private static int findKth(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
        if(A_start >= A.size())
            return B.get(B_start + k - 1);
        if(B_start >= B.size())
            return A.get(A_start + k - 1);
        if(k == 1)
            return Math.min(A.get(A_start), B.get(B_start));
        int A_key = A_start + k / 2 - 1 < A.size() ? A.get(A_start + k / 2 - 1) : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.size() ? B.get(B_start + k / 2 - 1) : Integer.MAX_VALUE;
        if(A_key < B_key)
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        else
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
    }
}
