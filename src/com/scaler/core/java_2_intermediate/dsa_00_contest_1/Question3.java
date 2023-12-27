package com.scaler.core.java_2_intermediate.dsa_00_contest_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @created 25/09/22 11:08 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, M, Q;
        N = in.nextInt();
        M = in.nextInt();
        Q = in.nextInt();
        int[][] array2D = new int[N][M];
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array2D[i][j]= ++num;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < N; i++) {
            int temp = array2D[i][0];
            array2D[i][0] = array2D[i][1];
            array2D[i][1] = temp;
            System.out.println("");
        }
        System.out.println(Arrays.toString(array2D));

    }
}
