package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward.homework;

/**
 * @created 12/09/22 11:13 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    /**
     * Q4. Best Time to Buy and Sell Stocks I
     * <p>
     * Problem Description
     * Say you have an array, A, for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     * <p>
     * Return the maximum possible profit.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 0 <= len(A) <= 7e5
     * 1 <= A[i] <= 1e7
     * <p>
     * <p>
     * <p>
     * Input Format
     * The first and the only argument is an array of integers, A.
     * <p>
     * <p>
     * Output Format
     * Return an integer, representing the maximum possible profit.
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * A = [1, 2]
     * Input 2:
     * <p>
     * A = [1, 4, 5, 2, 4]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * 1
     * Output 2:
     * <p>
     * 4
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * Buy the stock on day 0, and sell it on day 1.
     * Explanation 2:
     * <p>
     * Buy the stock on day 0, and sell it on day 2.
     **/
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int maxProfit(final int[] A) {
        int n;
        int array[];
        n = A.length;
        if (A == null || n <= 1)
            return 0;
        array = new int[n - 1];
        int profit = 0;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            array[i - 1] = A[i] - A[i - 1];
        }
        for (int i = 0; i < n - 1; i++) {
            prev += array[i];
            profit = Math.max(profit, prev);
            if (prev < 0)
                prev = 0;
        }
        return profit;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Hint 1
     * Basically you need to find the maximum value of A[j]-A[i] where j>i.
     * Now can you do this?
     *
     * Solution Approach
     * If you buy your stock on day i, you’d obviously want to sell it on the day its price is maximum after that day.
     * So essentially at every index i, you need to find the maximum in the array in the suffix.
     * Now this part can be done in 2 ways :
     * 1) Have another array which stores that information.
     * max[i] = max(max[i+1], A[i])
     *
     * 2) Start processing entries from the end maintaining a maximum till now. Constant additional space requirement.
     * Above solution is same
     * **/

    public static void main(String[] args) {
        int[] A = {1, 4, 5, 2, 4};
        int maxProfit = maxProfit(A);
        System.out.println("max profit : " + maxProfit);

    }
}
