package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 15/03/23 2:32 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Counting_the_Nodes {
    public int solve(TreeNode A) {
        Integer max = 0;
        return countNodes(A, max);
    }

    private int countNodes(TreeNode root, Integer max) {
        if (root == null)
            return 0;
        int counter = 0;
        if (root.val > max) {
            max = root.val;
            counter++;
        }
        counter += countNodes(root.left, max);
        counter += countNodes(root.right, max);
        return counter;
    }
}
