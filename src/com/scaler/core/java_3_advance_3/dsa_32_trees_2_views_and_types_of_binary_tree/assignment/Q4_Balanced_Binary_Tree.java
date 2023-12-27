package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @created 02/04/23 12:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Balanced_Binary_Tree {

    private static int isBalanced(TreeNode A) {
        if (checkBalanced(A) == 0) return 0;
        return 1;
    }

    private static int checkBalanced(TreeNode A) {
        if (A == null) return 1;

        int left = checkBalanced(A.left);
        int right = checkBalanced(A.right);

        if (left == 0 || right == 0) return 0;
        if (Math.abs(left - right) > 1) return 0;

        return Math.max(left, right) + 1;
    }
}
