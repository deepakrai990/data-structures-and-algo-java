package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 15/03/23 2:33 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Sum_of_Left_Leaves {
    private static int solve(TreeNode A) {
        return leftLeavesSum(A, 'N');
    }
    private static int leftLeavesSum(TreeNode root, char childType) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (childType == 'L'){
                return root.val;
            }
            return 0;
        }
        int leftSum = leftLeavesSum(root.left, 'L');
        int rightSum = leftLeavesSum(root.right, 'R');
        return leftSum + rightSum;
    }
}
