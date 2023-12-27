package com.scaler.core.java_3_advance_2.dsa_18_two_pointers;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/10/23 7:27 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Containers_with_most_water {
    /**
     * Given A[N] where A[i] represents height of each wall pick any two walls
     * such that max water is accumulated between them.
     * **/
    private static int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        int N = height.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int width = j - i;
                int minHeight = Math.min(height[i], height[j]);
                int currentArea = width * minHeight;
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        return maxArea;
    }
    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {3, 7, 4, 5, 2};
        int result = maxAreaBruteForce(height);
        PrintUtils.print(result);
        PrintUtils.printNewLine();
        result = maxArea(height);
        PrintUtils.print(result);
    }
}
