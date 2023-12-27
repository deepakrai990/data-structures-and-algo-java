package com.scaler.core.java_1_beginner.intro_04_for_loop.homework;

import java.util.Scanner;

/**
 * @created 28/07/22 5:51 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = 1;
        int i = 1;
        while(i <= Math.min(a, b)) {
            if(a % i == 0 && b % i == 0) {
                ans = i;
            }
            i++;
        }
        System.out.print(ans);
    }
}
