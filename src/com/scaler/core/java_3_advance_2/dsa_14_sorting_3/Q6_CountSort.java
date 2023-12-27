package com.scaler.core.java_3_advance_2.dsa_14_sorting_3;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 26/09/23 10:49 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q6_CountSort {
    private static void countSort(int[] arr) {
        // Find the maximum and minimum values in the array
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        // Determine the range of values in the array
        int range = max - min + 1;
        // Create a counting array to store the count of each element
        int[] count = new int[range];
        // Count the occurrences of each element
        for (int num : arr) {
            count[num - min]++;
        }
        // Reconstruct the sorted array from the counting array
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index] = i + min;
                index++;
                count[i]--;
            }
        }
    }
    public static int[] countingSort(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        // Count the occurrences of each element
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // Reconstruct the sorted array
        int[] sortedArr = new int[arr.length];
        int index = 0;
        for (int num : arr) {
            while (countMap.get(num) > 0) {
                sortedArr[index] = num;
                index++;
                countMap.put(num, countMap.get(num) - 1);
            }
        }
        return sortedArr;
    }
    public static void main(String[] args) {
        int[] A = {3, 1, 4, 4, 2, 1, 3, 3, 2, 1};
        PrintUtils.print1DArray(A);
        PrintUtils.printNewLine();
        countSort(A);
        PrintUtils.print1DArray(A);
    }
}
