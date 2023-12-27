package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 14/03/23 3:03 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Tree_Height {
    /**
     * Definition for binary tree
     * class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) {
     *      val = x;
     *      left=null;
     *      right=null;
     *     }
     * }
     */
    public int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int leftHeight = solve(A.left);
        int rightHeight = solve(A.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
