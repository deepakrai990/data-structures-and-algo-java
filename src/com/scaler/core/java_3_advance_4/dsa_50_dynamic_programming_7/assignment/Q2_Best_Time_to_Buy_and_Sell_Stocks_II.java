package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7.assignment;

/**
 * @created 02/04/23 8:47 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Best_Time_to_Buy_and_Sell_Stocks_II {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int maxProfit(final int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        int currStockValue = A[0];
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] > currStockValue) {
                maxProfit += A[i] - currStockValue;
                currStockValue = A[i];
            } else
                currStockValue = A[i];
        }
        return maxProfit;
    }
}
