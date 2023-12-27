package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_35_trees_3_BST.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 18/03/23 4:50 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Search_in_BST {
    public int solve(TreeNode A, int B) {
        if (A == null) {
            return 0;
        }
        if (A.val == B) {
            return 1;
        }
        if (B <= A.val) {
            return solve(A.left, B);
        } else {
            return solve(A.right, B);
        }
    }
}
