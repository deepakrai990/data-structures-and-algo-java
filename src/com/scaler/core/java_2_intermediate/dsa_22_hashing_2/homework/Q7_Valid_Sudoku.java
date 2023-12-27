package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;

/**
 * @created 20/02/23 8:53 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q7_Valid_Sudoku {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int isValidSudoku(final String[] A) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (A[i].charAt(j) != '.') {
                    char charValue = A[i].charAt(j);
                    // inserting concatenated string in Hashset
                    // for i/3 and j/3 check give link https://sudoku.com.au/TheRules.aspx
                    if (!set.add(charValue + "is in row" + i)
                            || !set.add(charValue + "is in col" + j)
                            || !set.add(charValue + "is in 3*3" + i / 3 + j / 3)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String[] A = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.",
                "...419..5", "....8..79"};
        int result = isValidSudoku(A);
        PrintUtils.printInt(result);
    }
}
