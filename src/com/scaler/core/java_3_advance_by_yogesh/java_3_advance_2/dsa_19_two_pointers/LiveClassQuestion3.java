package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_19_two_pointers;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 15/02/23 9:01 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {
    /**
     * Given an array of positive integers, find count of sub-arrays with sum = K.
     * Example
     * int[] A = {3, 2, 5, 1, 8, 6, 2, 10};
     * int K = 15;
     **/
    private static int countOfSubArray3(int[] A, int K) {
        int n = A.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        int count = 0;
        int i = 0, j = prefixSum.length - 1;
        while (i < j) {
            int subArrSum = 0;
            if (i == 0) {
                subArrSum = prefixSum[j];
            } else {
                subArrSum = prefixSum[j] - prefixSum[i - 1];
            }
            if (subArrSum == K) count++;
            else if (subArrSum > K) {
                j--;
            } else i++;
        }
        return count;
    }
    private static int countOfSubArray(int[] A, int K) {
        int n = A.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        int count = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            int subArrSum = 0;
            if (i == 0) {
                subArrSum = prefixSum[j];
            } else {
                subArrSum = prefixSum[j] - prefixSum[i - 1];
            }
            if (subArrSum == K){
                count++;
                i++;
                j++;
            }
            else if (subArrSum > K) {
                i++;
                if (i == j) j++;
            } else j++;
        }
        return count;
    }

    private static int countOfSubArray1(int[] A, int K) {
        int count = 0;
        int[] prefixSum = new int[A.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
        }

        for (int start = 0; start < prefixSum.length; start++) {
            for (int end = start + 1; end < prefixSum.length; end++) {
                if (prefixSum[end] - prefixSum[start] == K) {
                    count++;
                }
            }
        }
        return count;
    }
    private static int subarraySum1(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    private static int subarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int ans = 0, currPrefix = 0;
        prefixSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            currPrefix += nums[i];
            ans += prefixSum.getOrDefault(currPrefix - k, 0);
            prefixSum.put(currPrefix, prefixSum.getOrDefault(currPrefix, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 5, 1, 8, 6, 2, 10};
        int K = 15;
        int result = countOfSubArray(A, K);
        PrintUtils.printInt(result);
    }
}
