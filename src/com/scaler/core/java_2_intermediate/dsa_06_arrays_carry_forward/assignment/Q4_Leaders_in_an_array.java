package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @created 12/09/22 11:32 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q4_Leaders_in_an_array {
    /**
     * Q4. Leaders in an array
     * <p>
     * Problem Description
     * <p>
     * Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
     * <p>
     * An element is a leader if it is strictly greater than all the elements to its right side.
     * <p>
     * NOTE:The rightmost element is always a leader.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * <p>
     * 1 <= N <= 105
     * <p>
     * 1 <= A[i] <= 108
     * <p>
     * <p>
     * <p>
     * Input Format
     * <p>
     * First and only argument is an integer array A.
     * <p>
     * <p>
     * <p>
     * Output Format
     * <p>
     * Return an integer array denoting all the leader elements of the array.
     * <p>
     * NOTE: Ordering in the output doesn't matter.
     * <p>
     * <p>
     * <p>
     * Example Input
     * <p>
     * Input 1:
     * <p>
     * A = [16, 17, 4, 3, 5, 2]
     * Input 2:
     * <p>
     * A = [1, 2]
     * <p>
     * <p>
     * Example Output
     * <p>
     * Output 1:
     * <p>
     * [17, 2, 5]
     * Output 2:
     * <p>
     * [2]
     * <p>
     * <p>
     * Example Explanation
     * <p>
     * Explanation 1:
     * <p>
     * Element 17 is strictly greater than all the elements on the right side to it.
     * Element 2 is strictly greater than all the elements on the right side to it.
     * Element 5 is strictly greater than all the elements on the right side to it.
     * So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17]
     * or any other ordering.
     * Explanation 2:
     * <p>
     * Only 2 the rightmost element is the leader in the array.
     **/
    private static int[] solve(int[] A) {
        int n = A.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = A[n - 1];

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(A[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i]);
            if (rightMax[i] == A[i]) {
                arr.add(A[i]);
            }
        }
        int[] ret = new int[arr.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = arr.get(i);
        }
        return ret;
    }

    /**
     * Scaler Solution
     * Approach
     *
     * Hint 1
     * A leader element must be greater than all the elements on the right to it simply means the leader element
     * must be greater than the maximum of all the elements on the right side of it.
     * Try to use the above fact and find a solution to the problem.
     *
     * Solution Approach
     * Method 1: (Simple)
     *
     * Use two loops. The outer loop runs from 0 to size – 1 and, one by one, picks all elements from left to the right. The inner loop compares the picked element to all the elements to its right side. If the picked element is greater than all the elements to its right side, then the picked element is the leader.
     * Time Complexity: O(N2)
     *
     * Method 2: (Scan from right) Optimized Approach
     *
     * Note that for an element to be greater than all the elements towards its right , it just needs to be greater than the maximum element towards its right.
     * Keep a variable ‘mx’ which stores the maximum till now and initialize it with the last element of the array and also add the last element to our answer array. Iterate from n-2 to 0 , at every index we check if that number is greater than the variable mx. If it is we add the element to our answer array and change mx to that variable.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     **/
    private static ArrayList<Integer> printLeaders(ArrayList<Integer> arr) {
        int size = arr.size();
        int max_from_right = arr.get(size - 1);

        ArrayList<Integer> ans = new ArrayList<>();
        /* Rightmost element is always leader */
        ans.add(arr.get(size - 1));

        for (int i = size - 2; i >= 0; i--) {
            if (max_from_right < arr.get(i)) {
                max_from_right = arr.get(i);
                ans.add(max_from_right);
            }
        }
        return ans;
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        return printLeaders(A);
    }

    public static void main(String[] args) {
        int[] A = {16, 17, 4, 3, 5, 2};
        int[] resultsArr = solve(A);
        System.out.println("Results : " + Arrays.toString(resultsArr));
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> results = printLeaders(arr);
        System.out.println("Results : " + Arrays.toString(results.toArray()));
    }
}
