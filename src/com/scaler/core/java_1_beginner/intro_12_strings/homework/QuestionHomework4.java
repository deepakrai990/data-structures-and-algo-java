package com.scaler.core.java_1_beginner.intro_12_strings.homework;

import java.util.Scanner;

/**
 * @created 18/08/22 2:15 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework4 {
    /**
     * Q4. Vowels vs Consonants
     *
     * Problem Description
     *
     * Write a program to input T strings (S) from user and print count of vowels and consonants in it.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= T <= 100
     *
     * 1 <= S.size() <= 1000
     *
     *
     *
     * Input Format
     *
     * First line is T which means number of test cases.
     *
     * Each next T lines contain a lowercase string S.
     *
     *
     *
     * Output Format
     *
     * T lines each containing two space separated integers representing cont of vowels and consonants in input string.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * 2
     * interviewbit
     * scaler
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * 5 7
     * 2 4
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 1; i <= T; i++) {
            String str = in.next();
            int vowels = 0;
            int consonant = 0;
            for(int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if ( (ch >= 'a' && ch <= 'z') ||  (ch >= 'A' && ch <= 'Z') ) {
                    ch = Character.toLowerCase(ch);

                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                        vowels++;
                    else
                        consonant++;
                }
            }
            System.out.println(vowels + " " + consonant);
        }
    }
}
