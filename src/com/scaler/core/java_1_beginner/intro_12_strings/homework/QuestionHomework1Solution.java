package com.scaler.core.java_1_beginner.intro_12_strings.homework;

/**
 * @created 18/08/22 2:10 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1Solution {

    public static void main(String[] args) {

    }

    private static int solve(String A) {
        int p = 0, a = 0, m = 0;
        for (int i = 0; i < A.length(); i++)
        {
            if (A.charAt(i) == 'p')
                p++;
            else if (A.charAt(i) == 'a')
                a++;
            else
                m++;
        }
        if(p + a == m)
            return 1;
        else
            return 0;
    }
}
