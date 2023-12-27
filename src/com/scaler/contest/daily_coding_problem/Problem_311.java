package com.scaler.contest.daily_coding_problem;

/**
 * @created 06/10/23 10:09 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Problem_311 {
    /**
     * Given a array that's sorted but rotated at some unknown pivot, in which all elements
     * are distinct, find a "peak" element in O(log N) time.
     * <p><p/>
     * An element is considered a peak if it is greater than both its left and right neighbors.
     * It is guaranteed that the first and last elements are lower than all others.
     * **/
    private static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if((mid == 0 && nums[mid] >= nums[mid+1])
                    || (mid == nums.length - 1 && nums[mid] >= nums[mid - 1])
                    || (mid > 0 && mid < nums.length - 1
                    && nums[mid] >= nums[mid - 1]
                    && nums[mid] >= nums[mid + 1])
            )
                return nums[mid];
            if(mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {8, 9, 10, 2, 5, 6};
        int result = findPeakElement(nums);
        System.out.println("Peak Element: " + result);
    }
}
