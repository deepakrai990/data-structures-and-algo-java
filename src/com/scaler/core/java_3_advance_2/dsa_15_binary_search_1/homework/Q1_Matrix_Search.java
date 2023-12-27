package com.scaler.core.java_3_advance_2.dsa_15_binary_search_1.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Matrix_Search {
    private static int searchMatrix(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int row = -1;
        //finding the row in which element is present
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (B >= A[mid][0] && B <= A[mid][m - 1])
                row = mid;
            if (B > A[mid][m - 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        if (row == -1) return 0;

        //applying bfs on row
        low = 0;
        high = m - 1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (A[row][mid] == B)
                return 1;
            if (B > A[row][mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] A = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        int B = 3;
        int result = searchMatrix(A, B);
        PrintUtils.printInt(result);
    }
}
