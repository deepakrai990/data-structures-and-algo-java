package com.scaler.core.java_2_intermediate.dsa_28_trees_basics.assignment;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

/**
 * @created 21/02/23 3:25 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Tree_Height {
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
        if(A == null) {
            return 0;
        } else {
            return (1 + Math.max(solve(A.right), solve(A.left)));
        }
    }
}
