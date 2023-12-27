package com.scaler.core.java_1_beginner.intro_03_while_loop;

/**
 * @created 26/07/22 1:02 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main2 {
    public static void main(String[] args) {
        /**
         *  Q1 Print numbers from 1 to 10.
         * -> 1 2 3 4 5 6 7 8 9 10
         **/
        /**
         * initialization
         * **/
        int i = 1; //initialization
        while(i <= 10) { // condition
            System.out.println(i); // loop work
            i = i + 1; // update
        }
    }
}
