package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_11_recursion.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 7:32 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    int idx = -1;
    int[][] arr;

    private int[][] towerOfHanoi(int A) {
        int mSize = (1 << A) - 1;
        arr = new int[mSize][3];
        customTowerOfHanoi(A, 1, 2, 3);
        return arr;
    }

    private void customTowerOfHanoi(int disc, int st, int temp, int end) {
        if (disc == 0) {
            return;
        }
        customTowerOfHanoi(disc - 1, st, end, temp);
        arr[++idx][0] = disc;
        arr[idx][1] = st;
        arr[idx][2] = end;
        customTowerOfHanoi(disc - 1, temp, st, end);
        return;
    }

    public static void main(String[] args) {
        Question2 question = new Question2();
        int A = 3;
        int[][] results = question.towerOfHanoi(A);
        PrintUtils.print2DArray(results);
    }
}
