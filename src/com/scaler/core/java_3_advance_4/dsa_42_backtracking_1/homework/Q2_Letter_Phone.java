package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 02/04/23 11:04 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Letter_Phone {
    Map<Character, String> map;
    int count = 0;
    String[] ans;

    private String[] letterCombinations(String A) {
        map = new HashMap<>();
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        int length = 1;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            length *= map.get(c).length();
        }
        ans = new String[length];
        StringBuilder sb = new StringBuilder();
        generate(0, A.length(), sb, A);
        return ans;
    }

    private void generate(int index, int n, StringBuilder currString, String A) {
        //base case
        if (index == n) {
            ans[count++] = currString.toString();
            return;
        }

        String digits = map.get(A.charAt(index));
        for (int i = 0; i < digits.length(); i++) {
            currString.append(digits.charAt(i));
            generate(index + 1, n, currString, A);
            currString.deleteCharAt(currString.length() - 1);
        }
    }
}
