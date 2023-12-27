package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_36_trees_4.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 22/03/23 8:22 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_LCA_in_BST {
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
    public int solve(TreeNode A, int B, int C) {
        TreeNode curr = A;
        while (curr != null) {
            if (B < curr.val && C < curr.val) {
                curr = curr.left;
            } else if (B > curr.val && C > curr.val) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
        return 0;
    }
}
