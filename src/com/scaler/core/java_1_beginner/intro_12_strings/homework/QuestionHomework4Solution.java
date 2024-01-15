package com.scaler.core.java_1_beginner.intro_12_strings.homework;

import java.util.Scanner;

/**
 * @created 18/08/22 2:17 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework4Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        while(T-- > 0) {
            String str = scn.next();

            int v = 0;
            int c = 0;

            for(int i=0; i < str.length();i++) {
                char ch = str.charAt(i);

                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    v++;
                }
                else {
                    c++;
                }
            }

            System.out.println(v + " " + c);
        }
        scn.close();
    }
}
