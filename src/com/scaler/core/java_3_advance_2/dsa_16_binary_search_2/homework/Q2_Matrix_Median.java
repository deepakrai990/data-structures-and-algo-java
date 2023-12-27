package com.scaler.core.java_3_advance_2.dsa_16_binary_search_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:22 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Matrix_Median {
    private static int findMedian(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        //Overall TC using binary search TC : O(log(max-min)  * (N * log M))   SC:O(1)
        //finding min and max
        //TC: O(N)
        int min = A[0][0];
        int max = A[0][m - 1];
        for (int i = 0; i < n; i++) {
            if (A[i][0] < min) min = A[i][0];
            if (A[i][m - 1] > max) max = A[i][m - 1];
        }

        //TC : O(log (max-min)  * (N * log M))
        int low = min;
        int high = max;
        int ans = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            // we are counting frequency (cnt of ele in A) <=mid, TC : O(N * log M)
            int cnt = cntFrequency(A, mid);
            if (cnt <= (n * m / 2)) {
                ans = mid + 1; //why +1 bcs we always have odd nos. rows and columns as we need to find median
                // for odd values (n*m/2) gives always even no. index and median present in odd index so we are doing +1
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }

    private static int cntFrequency(int[][] A, int val) {
        int n = A.length;
        int m = A[0].length;
        int cnt = 0;
        //TC : O(N * log M)
        for (int i = 0; i < n; i++) {
            //TC : O(log M) binary search
            int low = 0, high = m - 1;
            int ans = 0;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (A[i][mid] <= val) {
                    ans = mid;
                    low = mid + 1;
                    ans++; //why +1 bcs index is oth based and cmt is start from 1
                } else high = mid - 1;
            }
            cnt = cnt + ans;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        int result = findMedian(A);
        PrintUtils.printInt(result);
    }
}
