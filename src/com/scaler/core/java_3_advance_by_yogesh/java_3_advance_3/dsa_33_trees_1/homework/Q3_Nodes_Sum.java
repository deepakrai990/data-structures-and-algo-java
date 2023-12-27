package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 15/03/23 2:34 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Nodes_Sum {
    private static int solve(TreeNode A) {
        return nodesSum(A);
    }
    private static int nodesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = nodesSum(root.left);
        int rightSum = nodesSum(root.right);
        return leftSum + rightSum + root.val;
    }
}
