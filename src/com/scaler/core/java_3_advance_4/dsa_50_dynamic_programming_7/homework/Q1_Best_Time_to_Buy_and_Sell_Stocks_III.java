package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7.homework;

/**
 * @created 02/04/23 8:48 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Best_Time_to_Buy_and_Sell_Stocks_III {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        int n = A.length;
        if (n <= 1) return 0;
        else if (n == 2 && A[1] > A[0]) return A[1] - A[0];
        int min = A[0];
        int max = A[n - 1];
        int ans = 0;

        int[] leftProfit = new int[n];
        leftProfit[0] = 0;
        for (int i = 1; i < n; i++) {
            min = Math.min(A[i], min);
            leftProfit[i] = Math.max(leftProfit[i - 1], A[i] - min);
        }

        int[] rightProfit = new int[n];
        rightProfit[n - 1] = 0;
        for (int j = n - 2; j >= 0; j--) {
            max = Math.max(max, A[j]);
            rightProfit[j] = Math.max(rightProfit[j + 1], max - A[j]);
            ans = Math.max(ans, leftProfit[j] + rightProfit[j + 1]);
        }
        return ans;
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit_1(final int[] A) {
        int sell1 = 0, sell2 = 0;
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;

        for (int price : A) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }
        return sell2;
    }
}
