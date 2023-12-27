package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward.assignment;

/**
 * @created 12/09/22 11:45 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    /**
     * Q5. Closest MinMax
     * <p>
     * Problem Description
     * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
     * <p>
     * and at least one occurrence of the minimum value of the array.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= |A| <= 2000
     * <p>
     * <p>
     * <p>
     * Input Format
     * First and only argument is vector A
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [1, 3]
     * Input 2:
     * <p>
     * A = [2]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 2
     * Output 2:
     * <p>
     * 1
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Only choice is to take both elements.
     * Explanation 2:
     * <p>
     * Take the whole array.
     **/
    private static int solve(int[] A) {
        int N = A.length;
        int minVal = A[0];
        int maxVal = A[0];
        for (int i = 0; i < N; i++) {
            minVal = Math.min(minVal, A[i]);
            maxVal = Math.max(maxVal, A[i]);
        }
        if (minVal == maxVal) {
            return 1;
        }
        int ans = N, mini = -1, maxi = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] == minVal) {
                mini = i;
                if (maxi != -1) {
                    ans = Math.min(ans, maxi - mini + 1);
                }
            }
            if (A[i] == maxVal) {
                maxi = i;
                if (mini != -1) {
                    ans = Math.min(ans, mini - maxi + 1);
                }
            }
        }
        return ans;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * One simple thing can be to generate all possible subarray and then compute the ans, but can we do better?
     * If we know the last occurrence of the min and max element in a particular subarray under consideration,
     * can we do something?
     * <p>
     * Solution Approach
     * This problem can be solved in a simple O(N) complexity.
     * We can implement a sliding window kind of algorithm using two pointers. We can slide over the array and keep track of every last occurrence of the minimum and maximum element of the array.
     * In order to find the start point, we can simply remember the last occurrences of a minimum and a maximum value, respectively. And for each min-max pair, we check the length of the subarray that encloses them and then update out overall based on that.
     * <p>
     * Time Complexity : O(n)
     * Space Complexity(extra) : O(1)
     **/
    private static int solve1(int[] A) {
        int min_Index = -1;
        int max_Index = -1;
        int min_ele = Integer.MAX_VALUE;
        int max_ele = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int x : A) {
            min_ele = Math.min(min_ele, x);
            max_ele = Math.max(max_ele, x);
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == min_ele) {
                min_Index = Math.max(min_Index, i);
            }
            if (A[i] == max_ele) {
                max_Index = Math.max(max_Index, i);
            }

            if (min_Index != -1 && max_Index != -1) {
                int len = Math.abs(max_Index - min_Index) + 1;
                ans = Math.min(ans, len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1, 4, 3};
        int closestMinMax = solve(A);
        System.out.println("closestMinMax : " + closestMinMax);
        closestMinMax = solve1(A);
        System.out.println("closestMinMax : " + closestMinMax);
    }
}
