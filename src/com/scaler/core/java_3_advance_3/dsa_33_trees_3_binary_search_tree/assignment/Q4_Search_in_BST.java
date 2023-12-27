package com.scaler.core.java_3_advance_3.dsa_33_trees_3_binary_search_tree.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 02/04/23 12:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Search_in_BST {
    private static int solve(TreeNode A, int B) {
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
