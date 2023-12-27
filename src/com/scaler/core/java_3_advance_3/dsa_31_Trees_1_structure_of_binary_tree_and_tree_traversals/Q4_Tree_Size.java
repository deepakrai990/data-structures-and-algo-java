package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 06/11/23
 * @project scaler_course_code
 */
public class Q4_Tree_Size {
    private static int size(TreeNode root) {
        if (root == null) return 0;
        int left = size(root.left);
        int right = size(root.right);
        return 1 + left + right;
    }

    public static void main(String[] args) {

    }
}
