package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 15/03/23 2:35 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q6_Symmetric_Binary_Tree {
    private static int isSymmetric(TreeNode A) {
        if (checkSymmetric(A.left, A.right)) {
            return 1;
        }
        return 0;
    }

    private static boolean checkSymmetric(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        boolean l = checkSymmetric(A.left, B.right);
        boolean r = checkSymmetric(B.left, A.right);
        return l && r;
    }
}
