package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree.homework;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @created 02/04/23 6:14 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Max_Sum_Path_in_Binary_Tree {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode A) {
        // Travel through post order
        postOrder(A);

        return maxSum;
    }

    private int postOrder(TreeNode node) {
        if (node == null) return 0;
        //Calculate Best left sum possible;
        int leftSum = Math.max(0, postOrder(node.left));

        //Calculate Best right sum possible;
        int rightSum = Math.max(0, postOrder(node.right));

        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);

        //Choose left path or right path
        return Math.max(leftSum + node.val, +rightSum + node.val);
    }
}
