package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.model;

/**
 * @author Deepak Kumar Rai
 * @created 21/11/23
 * @project scaler_course_code
 */
public class TreeNode {
    public int val;
    public TreeNode left, right, next;

    public TreeNode(int x) {
        val = x;
        left = right = next = null;
    }
}
