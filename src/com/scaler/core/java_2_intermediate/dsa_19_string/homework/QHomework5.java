package com.scaler.core.java_2_intermediate.dsa_19_string.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:19 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework5 {
    private static String addBinary(String A, String B) {
        if (A.length() < B.length()) {
            String t = A;
            A = B;
            B = t;
        }
        String result = "";
        int carry = 0;
        int aLen = A.length() - 1;
        int bLen = B.length() - 1;
        while (bLen >= 0) {
            int val = carry + Integer.parseInt(String.valueOf(A.charAt(aLen--)))
                    + Integer.parseInt(String.valueOf(B.charAt(bLen--)));
            int d = val % 2;
            result = d + result;
            carry = val / 2;
        }
        int remain = A.length() - B.length();
        if (remain > 0) {
            for (int i = remain - 1; i >= 0; i--) {
                if (carry > 0) {
                    int val = Integer.parseInt(String.valueOf(A.charAt(i))) + carry;
                    int d = val % 2;
                    result = d + result;
                    carry = val / 2;
                } else {
                    result = String.valueOf(A.charAt(i)) + result;
                }
            }
        }
        if (carry > 0) {
            result = carry + result;
        }
        return result;
    }

    public static void main(String[] args) {
        String A = "100";
        String B = "11";
        String result = addBinary(A, B);
        PrintUtils.printString(result);
    }
}
