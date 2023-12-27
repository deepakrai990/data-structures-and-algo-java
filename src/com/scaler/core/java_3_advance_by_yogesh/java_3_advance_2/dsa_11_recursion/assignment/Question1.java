package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_11_recursion.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;

/**
 * @created 11/02/23 7:32 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    ArrayList<String> respList = new ArrayList<>();

    private String[] generateParenthesis(int A) {
        int open = 0, close = 0;
        generate(A, "", open, close);
        return respList.stream().toArray(String[]::new);
    }

    private void generate(int A, String s, int open, int close) {
        if (s.length() == 2 * A) {
            respList.add(s);
            return;
        }
        if (open < A) generate(A, s + "(", open + 1, close);

        if (close < open) generate(A, s + ")", open, close + 1);
    }

    public static void main(String[] args) {
        Question1 question = new Question1();
        int A = 3;
        String[] result = question.generateParenthesis(A);
        PrintUtils.print1DStringArray(result);
    }
}
