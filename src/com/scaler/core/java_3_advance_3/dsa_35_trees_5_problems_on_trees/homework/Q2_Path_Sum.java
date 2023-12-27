package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.homework;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @created 02/04/23 12:44 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Path_Sum {

    public int hasPathSum(TreeNode A, int B) {
        return sumPath(A, 0, B);
    }
    private int sumPath(TreeNode root, int sum, int target) {
        if (root == null)
            return 0;

        sum = sum + root.val;
        int l = sumPath(root.left, sum, target);
        int r = sumPath(root.right, sum, target);

        if (l == 1 || r == 1)
            return 1;

        if (sum == target && root.left == null && root.right == null)
            return 1;
        else
            return 0;
    }
}
