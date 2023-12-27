package com.scaler.core.java_3_advance_1.dsa_02_arrays_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Spiral_Order_Matrix_II {
    private static int[][] generateMatrix(int A) {
        int[][] spiralMat = new int[A][A];
        int elem = 1;
        int x = 0,y = 0;

        while (A > 1) {
            for(int k = 1; k <= A - 1; k++){
                spiralMat[x][y] = elem++;
                y++;
            }

            for(int k = 1; k <= A - 1; k++) {
                spiralMat[x][y] = elem++;
                x++;
            }

            for(int k = 1; k <= A - 1; k++) {
                spiralMat[x][y] = elem++;
                y--;
            }

            for(int k = 1; k <= A - 1; k++) {
                spiralMat[x][y] = elem++;
                x--;
            }
            x++; y++;
            A -= 2;
        }
        if(A == 1) {
            spiralMat[x][y] = elem;
        }
        return spiralMat;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] results = generateMatrix(A);
        PrintUtils.print(results);
    }
}
