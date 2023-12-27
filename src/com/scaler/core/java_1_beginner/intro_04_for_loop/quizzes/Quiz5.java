package com.scaler.core.java_1_beginner.intro_04_for_loop.quizzes;

/**
 * @created 28/07/22 11:06 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Quiz5 {
    public static void main(String[] args) {
        int N = 34562;
        int count = 0;
        while (N >= 0) { // this loop will never end
            N = N / 10;
            count++;
        }
        System.out.println(count);
    }
}
