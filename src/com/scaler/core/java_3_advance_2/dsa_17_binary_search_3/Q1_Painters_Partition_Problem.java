package com.scaler.core.java_3_advance_2.dsa_17_binary_search_3;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Painters_Partition_Problem {
    /**
     * We have to paint N boards of length A1, A2, A3.....AN.
     * There are K painters available and each takes one unit of time to paint one unit of board.
     * Find minimum time to get the job done.
     * Note: One painter will paint only a continuous section of the board.
     * **/
    private static int minTimeToPaint(int[] boards, int K) {
        int totalLength = 0, maxBoardLength = 0;
        int minimumTime = Integer.MAX_VALUE;
        for (int board: boards) {
            totalLength += board;
            maxBoardLength = Math.max(maxBoardLength, board);
        }
        int left = maxBoardLength, right = totalLength;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (isPossible(boards, mid,  K)) {
                minimumTime = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minimumTime;
    }
    private static boolean isPossible(int[] boards, int mid, int K) {
        int paintersRequired = 1;
        int currentBoardLength = 0;
        for (int i = 0; i < boards.length; i++) {
            currentBoardLength += boards[i];
            if (currentBoardLength > mid) {
                paintersRequired++;
                currentBoardLength = boards[i];
                if (paintersRequired > K) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] A = {3, 5, 1, 7, 8, 2, 5, 3, 10, 1, 4, 7, 5, 4, 6};
        int K = 4;
        int result = minTimeToPaint(A, K);
        PrintUtils.print(result);
    }
}
