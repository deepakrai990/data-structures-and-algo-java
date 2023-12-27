package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2.homework;

import java.util.ArrayList;

/**
 * @created 02/04/23 11:01 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Palindrome_Partitioning {
    ArrayList<ArrayList<String>> ans;

    public ArrayList<ArrayList<String>> partition(String a) {
        int N = a.length();
        ans = new ArrayList<ArrayList<String>>();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> curr = new ArrayList<>();
        generate(a, curr, 0, N);
        return ans;
    }

    private void generate(String A, ArrayList<String> curr, int index, int N) {
        if (index == N) {
            ans.add(new ArrayList<String>(curr));
            return;
        }
        for (int i = index; i < N; i++) {

            if (isPalindrome(A, index, i)) {
                curr.add(A.substring(index, i + 1));
                generate(A, curr, i + 1, N);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String A, int l, int h) {
        while (l < h) {
            if (A.charAt(l) != A.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
}
