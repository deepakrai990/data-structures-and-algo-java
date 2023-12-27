package com.scaler.core.java_1_beginner.intro_04_for_loop.quizzes;

/**
 * @created 28/07/22 10:22 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Quiz2 {
    public static void main(String[] args) {
        int i = 1; // Initialisation
        while (i <= 10) /* Condition */ {
            i = i * i; // loop statement / loop work
            System.out.print(i + " "); // loop statement / loop work
            i++; // update / increment
        }
    }
}
