package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.homework;

import java.util.Scanner;

/**
 * @created 18/08/22 6:42 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework2Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int N = sc.nextInt();

            int[] A = new int[N];
            for(int i = 0; i < N; i++){
                A[i] = sc.nextInt();
            }


            for (int val = 0; val < 1001;val++){
                int cnt = 0;
                for(int i = 0; i < N; i++){
                    if(A[i] == val){
                        cnt++;
                    }
                }
                if(cnt == 1){
                    System.out.print(val + " ");
                }
            }

            System.out.println();
        }
    }
}
