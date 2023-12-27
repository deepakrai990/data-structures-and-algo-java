package com.scaler.core.java_3_advance_2.dsa_15_binary_search_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 01/10/23 9:44 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class BinarySearch {
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 9, 13, 15, 18, 19};
        int target = 15;
        int result = binarySearch(arr, target);
        PrintUtils.print(result);
    }
}
