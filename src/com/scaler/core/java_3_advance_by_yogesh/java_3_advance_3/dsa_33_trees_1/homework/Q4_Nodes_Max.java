package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 15/03/23 2:34 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Nodes_Max {
    private static int solve(TreeNode A) {
        return nodesMax(A);
    }

    private static int nodesMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = nodesMax(root.left);
        int rightMax = nodesMax(root.right);
        return Math.max(Math.max(leftMax, rightMax), root.val);
    }
}
