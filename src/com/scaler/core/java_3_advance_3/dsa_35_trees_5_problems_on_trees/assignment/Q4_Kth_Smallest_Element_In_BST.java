package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.assignment;


import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @created 02/04/23 12:43 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Kth_Smallest_Element_In_BST {
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
    private static int kTHSmallest(TreeNode A, int B) {
        return findKthSmallest(A, B);
    }
    private static int findKthSmallest(TreeNode root, int B) {
        int count = 0;
        while (root != null) {
            TreeNode left = root.left;
            if (left == null) {
                count++;
                if (count == B) {
                    return root.val;
                }
                root = root.right;
            } else {
                while (left.right != null && left.right != root) {
                    left = left.right;
                }
                if (left.right == null) {
                    left.right = root;
                    root = root.left;
                } else if (left.right == root) {
                    count++;
                    if (count == B)
                        return root.val;
                    root = root.right;
                    left.right = null;
                }
            }
        }
        return -1;
    }
}
