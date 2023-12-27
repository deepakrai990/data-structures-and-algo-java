package com.scaler.core.java_2_intermediate.dsa_19_string.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static String solve(String A) {
        StringBuilder sb = new StringBuilder();
        int check_ = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != ' ') {
                check_= 1;
            }
            if (check_ == 1 && A.charAt(i) != ' ') {
                sb.append(A.charAt(i));
            }
            else if (check_ == 1 && A.charAt(i) == ' ') {
                check_ = 0;
                sb.append(A.charAt(i));
            }
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        reverse(sb, 0, sb.length() - 1);
        int l = 0;
        int r = 0;
        while (r < sb.length()) {
            if (sb.charAt(r) == ' ') {
                l++;
            }
            while (r < sb.length() && sb.charAt(r) != ' ') {
                r++;
            }
            if (l < r) {
                reverse(sb, l, r - 1);
            }
            r++;
            l=r;
        }
        return sb.toString();
    }

    private static void reverse(StringBuilder sb,int i, int j){
        while (i <= j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String A = "the sky is blue";
        String result = solve(A);
        PrintUtils.printString(result);
    }
}
