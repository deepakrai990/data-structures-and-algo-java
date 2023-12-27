package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_35_trees_3_BST.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode; /**
 * @created 18/03/23 4:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Valid_Binary_Search_Tree {
    private static int isValidBST(TreeNode A) {
        boolean isValid = isValid_BST(A, Long.MIN_VALUE, Long.MAX_VALUE);
        if (isValid) {
            return 1;
        }
        return 0;
    }
    private static boolean isValid_BST(TreeNode A, long mini, long maxi) {
        if (A == null) {
            return true;
        }
        if (A.val < mini || A.val > maxi) {
            return false;
        }
        boolean left = isValid_BST(A.left, mini, A.val - 1);
        boolean right = isValid_BST(A.right, A.val + 1, maxi);

        return left && right;
    }
}
