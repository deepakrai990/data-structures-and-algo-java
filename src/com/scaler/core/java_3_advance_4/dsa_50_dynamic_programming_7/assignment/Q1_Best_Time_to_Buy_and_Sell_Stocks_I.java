package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7.assignment;

/**
 * @created 02/04/23 8:43 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Best_Time_to_Buy_and_Sell_Stocks_I {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int maxProfit(final int[] A) {
        int n = A.length;
        int profit = 0, mini = 0;
        for (int i = 1; i < n; i++) {
            if (A[mini] > A[i])
                mini = i;
            else if (profit < A[i] - A[mini])
                profit = A[i] - A[mini];
        }
        return profit;
    }
}
