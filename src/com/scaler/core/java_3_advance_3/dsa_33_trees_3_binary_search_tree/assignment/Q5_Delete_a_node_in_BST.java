package com.scaler.core.java_3_advance_3.dsa_33_trees_3_binary_search_tree.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @created 02/04/23 12:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Delete_a_node_in_BST {
    private static TreeNode solve(TreeNode A, int B) {
        if (A == null) {
            return null;
        }

        if (A.val < B) {
            A.right = solve(A.right, B);
        } else if (A.val > B) {
            A.left = solve(A.left, B);
        } else {
            // case 1: when A is a leaf node
            if (A.left == null && A.right == null) {
                return null;
            }
            // case 2; when A is having a single child
            else if (A.left == null) {
                return A.right;
            } else if (A.right == null) {
                return A.left;
            } else {
                TreeNode max_left = max_left(A.left);
                A.val = max_left.val; // replace the node value with the value of a node
                // which contains the maximum value on left subtree
                A.left = solve(A.left, max_left.val); // remove the node which contains
                // max value in left subtree
            }
        }
        return A;
    }
    public static TreeNode max_left(TreeNode A) {
        while (A.right != null) {
            A = A.right;
        }
        return A;
    }
}
