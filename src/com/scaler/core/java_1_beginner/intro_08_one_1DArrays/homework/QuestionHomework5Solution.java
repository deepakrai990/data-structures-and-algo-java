package com.scaler.core.java_1_beginner.intro_08_one_1DArrays.homework;

import java.util.Scanner;

/**
 * @created 06/08/22 4:18 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework5Solution {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        x = x - 1;
        for (int i = x; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        n = n - 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        scn.close();
    }
}
