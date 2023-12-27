package com.scaler.core.java_2_intermediate.dsa_11_arrays_interview_problems_1.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @created 18/09/22 11:41 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    /**
     * Q2. Maximum positivity
     *
     * Problem Description
     * Given an array of integers A, of size N.
     *
     * Return the maximum size subarray of A having only non-negative elements. If there are more than one
     * such subarray, return the one having the smallest starting index in A.
     *
     * NOTE: It is guaranteed that an answer always exists.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * -109 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * The first and only argument given is the integer array A.
     *
     *
     *
     * Output Format
     * Return maximum size subarray of A having only non-negative elements. If there are more than one such
     * subarrays, return the one having earliest starting index in A.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [5, 6, -1, 7, 8]
     * Input 2:
     *
     *  A = [1, 2, 3, 4, 5, 6]
     *
     *
     * Example Output
     * Output 1:
     *
     *  [5, 6]
     * Output 2:
     *
     *  [1, 2, 3, 4, 5, 6]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  There are two subarrays of size 2 having only non-negative elements.
     *  1. [5, 6]  starting point  = 0
     *  2. [7, 8]  starting point  = 3
     *  As starting point of 1 is smaller, return [5, 6]
     * Explanation 2:
     *
     *  There is only one subarray of size 6 having only non-negative elements:
     *  [1, 2, 3, 4, 5, 6]
     * **/
    /**
     * Bruteforce Approach
     * **/
    private static int[] solve(int[] A) {
        int N = A.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int flag = 0;
                int subArrayStart = i;
                int subArrayEnd = j;
                for (int k = subArrayStart; k <= subArrayEnd; k++) {
                    if (A[k] < 0) {
                        flag = 1;
                        break;
                    }
                }
                // [a to b] = b - a + 1
                int sizeOfSubArray = subArrayEnd - subArrayStart + 1;
                if (flag == 0 && sizeOfSubArray > list.size() ) {

                    list = new ArrayList<>();
                    for (int k = subArrayStart; k <= subArrayEnd; k++) {
                        list.add(A[k]);
                    }
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    /**
     * Scaler Solution
     *
     * Hint 1
     * If we try to bruteforce this problem we’ll look at all the subarrays, but there are some
     * unecessary compututations that are taking place here, can you idenitfy them?
     *
     * Solution Approach
     * We can solve this problem using a single while loop:-
     *
     * For all elements in array :-
     *
     * 1.If ith element is negative, we need to ignore it and go on next element
     *
     * 2. If ith element is non-negative, we will start a second while loop from this position until a negative
     * element arrives.
     *     a.If size of subarray received using this is greater than size of previous such arrays, then update the answer
     *     b. else ignore it.
     * **/
    private static int[] solve1(int[] A) {
        int size = 0, left = 0, right = 0;
        for (int l = -1, r = 0; r < A.length; r++) {
            if (A[r] >= 0) {
                if (size < r - l) {
                    size = r - l;
                    left = l;
                    right = r;
                }
            } else {
                l = r;
            }
        }
        int ans[] = new int[size];
        for (int i = left + 1; i <= right; i++) {
            ans[i - left - 1] = A[i];
        }
        return ans;
    }

    private static List<Integer> solve2(List<Integer> A) {
        int n = A.size();
        int i = 0;
        int max_count = 0, st_point = 0;
        while (i < n) {
            if (A.get(i) >= 0) {
                int temp = 0;
                int tempst = i;
                while (A.get(i) >= 0 && i < n) {
                    i++;
                    temp++;
                }
                if (temp > max_count) {
                    max_count = temp;
                    st_point = tempst;
                }
            } else {
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = st_point; j < st_point + max_count; j++) {
            ans.add(A.get(i));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {5, 6, -1, 7, 8};
        int[] result = solve(A);
        System.out.println("Result = " + Arrays.toString(result));
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(6);
        l.add(-1);
        l.add(7);
        l.add(8);
        result = solve1(A);
        System.out.println("Result = " + Arrays.toString(result));
    }
}
