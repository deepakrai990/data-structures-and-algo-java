package com.scaler.core.java_2_intermediate.dsa_05_arrays_prefix_sum.assignment;

/**
 * @created 19/09/22 8:53 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    /**
     * Q5. Equilibrium index of an array
     * <p>
     * Problem Description
     * You are given an array A of integers of size N.
     * <p>
     * Your task is to find the equilibrium index of the given array
     * <p>
     * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to
     * the sum of elements at higher indexes.
     * <p>
     * NOTE:
     * <p>
     * Array indexing starts from 0.
     * If there is no equilibrium index then return -1.
     * If there are more than one equilibrium indexes then return the minimum index.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 105
     * -105 <= A[i] <= 105
     * <p>
     * <p>
     * Input Format
     * First arugment is an array A .
     * <p>
     * <p>
     * Output Format
     * Return the equilibrium index of the given array. If no such index is found then return -1.
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * A=[-7, 1, 5, 2, -4, 3, 0]
     * Input 2:
     * <p>
     * A=[1,2,3]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * 3
     * Output 2:
     * <p>
     * -1
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * 3 is an equilibrium index, because:
     * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
     * Explanation 1:
     * <p>
     * There is no such index.
     **/
    private static int solve(int[] A) {
        int totSum = 0;
        for (Integer n : A) {
            totSum += n;
        }
        int curSum = 0, index = 0;
        for (Integer n : A) {
            if ((totSum - n) == 2 * curSum)
                return index;
            index++;
            curSum += n;
        }
        return -1;
    }

    /**
     * Scaler Solution
     * Approach
     * The idea is to get the total sum of the array first. Then Iterate through the array and keep updating the
     * left sum which is initialized as zero. In the loop, we can get the right sum by subtracting
     * the elements one by one.
     * <p>
     * 1) Initialize leftsum  as 0
     * 2) Get the total sum of the array as sum
     * 3) Iterate through the array and for each index i, do following.
     * a)  Update sum to get the right sum.
     * sum = sum - arr[i]
     * // sum is now right sum
     * b) If leftsum is equal to sum, then return current index.
     * // update leftsum for next iteration.
     * c) leftsum = leftsum + arr[i]
     * 4) return -1
     * // If we come out of loop without returning then
     * // there is no equilibrium index
     **/
    private static int solve1(int[] A) {
        long sum1 = 0;
        for (int i = 0; i < A.length; i++) sum1 += A[i];
        long sum2 = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum1 -= A[i];
            if (sum1 == sum2) {
                ans = i;
                break;
            }
            sum2 += A[i];
        }
        if (ans == Integer.MAX_VALUE) ans = -1;
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-7, 1, 5, 2, -4, 3, 0};
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
