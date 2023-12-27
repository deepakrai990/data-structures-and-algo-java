package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6.homework;

import java.util.ArrayList;

/**
 * @created 02/04/23 9:05 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Length_of_LIS {
    private static int findLIS(int[] A) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            if (A[i] > arr.get(arr.size() - 1)) {
                arr.add(A[i]);
            } else {
                int idx = Upper_Bound(arr, A[i]);
                arr.set(idx, A[i]);
            }
        }
        return arr.size();
    }

    private static int Upper_Bound(ArrayList<Integer> tmp, int key) {
        int low = 0, high = tmp.size() - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (tmp.get(mid) == key) {
                return mid;
            } else if (tmp.get(mid) > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
