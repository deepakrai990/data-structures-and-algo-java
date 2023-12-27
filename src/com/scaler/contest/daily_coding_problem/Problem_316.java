package com.scaler.contest.daily_coding_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepak Kumar Rai
 * @created 11/10/23
 * @project scaler_course_code
 */
public class Problem_316 {
    /**
     * You are given an array of length N, where each element i represents the number of ways
     * we can produce i units of change. For example, [1, 0, 1, 1, 2] would indicate that
     * there is only one way to make 0, 2, or 3 units, and two ways of making 4 units.
     * <></>
     * Given such an array, determine the denominations that must be in use. In the case above,
     * for example, there must be coins with value 2, 3, and 4.
     * **/
    public static List<Integer> findDenominations(int[] changeArray) {
        List<Integer> denominations = new ArrayList<>();
        int n = changeArray.length;
        for (int i = 1; i < n; i++) {
            if (changeArray[i] > 0) {
                denominations.add(i);
            }
        }
        return denominations;
    }
    public static void main(String[] args) {
        int[] changeArray = {1, 0, 1, 1, 2};
        List<Integer> denominations = findDenominations(changeArray);

        System.out.println("Denominations that must be in use: " + denominations);
    }
}
