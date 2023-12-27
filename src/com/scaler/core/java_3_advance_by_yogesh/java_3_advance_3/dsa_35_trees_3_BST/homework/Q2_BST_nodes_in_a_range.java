package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_35_trees_3_BST.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 18/03/23 4:56 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_BST_nodes_in_a_range {
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
    private static int solve(TreeNode A, int B, int C) {
        if (A == null) {
            return 0;
        }
        if (A.val > B && A.val < C) {
            return solve(A.left, B, C) + 1 + solve(A.right, B, C);
        } else if (A.val == B) {
            return solve(A.right, B, C) + 1;
        } else if (A.val == C) {
            return solve(A.left, B, C) + 1;
        } else {
            return solve(A.left, B, C) + solve(A.right, B, C);
        }
    }

    private static int solve_1(TreeNode A, int B, int C) {
        if (A == null) return 0;
        int cnt = 0;
        if (A.val >= B && A.val <= C) {
            cnt = 1;
        }
        return (cnt + solve(A.left, B, C) + solve(A.right, B, C));
    }
}
