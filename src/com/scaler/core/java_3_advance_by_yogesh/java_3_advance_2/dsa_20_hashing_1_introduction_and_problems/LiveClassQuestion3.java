package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_20_hashing_1_introduction_and_problems;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 16/02/23 3:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {
    /**
     * Question 3
     * Given an array of integers. Find the length of the longest subarray with sum = 0;
     * int[] A = {2, 2, 1, -3, 4, 3, 1, -8, 6, -2, 1};
     * <p></p>
     * Link of this question
     * <a href="https://www.scaler.com/topics/largest-subarray-with-0-sum/">...</a>
     **/
    private static int maxLenSubSumZero(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (sum == 0) {
                max_len = i + 1;
            }
            Integer prev_index = map.get(sum);
            if (prev_index != null) {
                max_len = Math.max(max_len, i - prev_index);
            } else {
                map.put(sum, i);
            }
        }
        return max_len;
    }

    /**
     * Brute Force Approach
     * @param A
     */
    // function for finding the length of the largest
    // subarray of an array that has a sum of 0
    private static int maxLenSubSumZero1(int A[]) {
        int size = A.length;
        // declaring the variable max_length for storing
        // maximum length of subarray with sum 0
        int max_length = 0;
        // iterating over the input array
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                // variable cur-sum to store the sum of subarray
                // that starts with ith index and ends with a jth index
                int cursum = 0;
                for (int k = i; k <= j; k++)
                    cursum = cursum + A[k];
                // checks that the subarray has a sum of zero or not
                if (cursum == 0) {
                    // if the sum of the subarray is zero and
                    // current subarray length is greater
                    // than update max_length
                    if (max_length < j - i + 1)
                        max_length = j - i + 1;
                }
            }
        }
        //returning the length of the largest subarray with a sum of 0
        return max_length;
    }

    /**
     * Approach 2 : Efficient Brute Force - Using Two Nested Loops
     *
     * @param A
     * @return max_length
     */
    // function for finding the length of the largest
    // subarray of an array that has sum 0
    private static int maxLenSubSumZero2(int[] A) {
        int size = A.length;
        // declaring the variable max_length for storing
        // maximum length of subarray with sum 0
        int max_length = 0;
        // iterating over the input array
        for (int i = 0; i < size; i++) {
            // variable cursum to store the current sum of subarray
            // starting with ith index
            int cursum = 0;
            for (int j = i; j < size; j++) {
                // getting the sum of subarray that starts with i and ends with j
                cursum = cursum + A[j];
                // checks that the subarray has sum zero or not
                if (cursum == 0) {
                    // if sum of subarray is zero and
                    // current subarray length is greater
                    // than update max_length
                    if (max_length < j - i + 1)
                        max_length = j - i + 1;
                }
            }
        }
        //returning the length of largest subarray with sum 0
        return max_length;
    }

    /**
     * Approach 3 : Alternative and Efficient Approach - Using the Hash Map
     * @param A
     * @return max_length
     */
    // function for finding the length of the largest
    //  subarray of an array that has sum 0
    private static int maxLenSubSumZero3(int A[]) {
        int size = A.length;
        // declaring the variable max_length for storing
        // maximum length of subarray with sum 0
        int max_length = 0;
        // Creating an empty hashmap for storing previous sum
        HashMap<Integer, Integer> prevSumMap = new HashMap<Integer, Integer>();
        // Declaring and Initializing the cur_sum to store sum
        int cur_sum = 0;
        // iterating over an input array
        for (int i = 0; i < size; i++) {
            // Adding current element to the previous calculated sum
            cur_sum += A[i];
            if (A[i] == 0 && max_length == 0)
                max_length = 1;
            if (cur_sum == 0)
                max_length = i + 1;
            // Checking this sum in the map
            Integer prevInd = prevSumMap.get(cur_sum);
            // If sum is in map then update the value of max_length
            if (prevInd != null)
                max_length = Math.max(max_length, i - prevInd);
            else {
                // If sum is not in the map
                // then insert it into map with current index
                prevSumMap.put(cur_sum, i);
            }
        }
        //returning the length of the largest subarray with sum 0
        return max_length;
    }

    public static void main(String[] args) {
        int[] A = {2, 2, 1, -3, 4, 3, 1, -8, 6, -2, 1};
        int result = maxLenSubSumZero(A);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        int result1 = maxLenSubSumZero1(A);
        PrintUtils.printInt(result1);
        PrintUtils.printNewLine();
        int result2 = maxLenSubSumZero2(A);
        PrintUtils.printInt(result2);
        PrintUtils.printNewLine();
        int result3 = maxLenSubSumZero3(A);
        PrintUtils.printInt(result3);
    }

}
