package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @created 02/04/23 12:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Diameter_of_binary_tree {
    int maxHeight = Integer.MIN_VALUE;

    private int solve(TreeNode root) {
        findHeight(root);
        return maxHeight;

    }

    public int findHeight(TreeNode root) {
        if (root == null)
            return -1;

        int left = findHeight(root.left) + 1;
        int right = findHeight(root.right) + 1;
        maxHeight = Math.max(maxHeight, left + right);

        return Math.max(left, right);
    }
}
