package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_35_trees_3_BST.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 18/03/23 4:57 pm
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
    public int kTHSmallest(TreeNode A, int B) {
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
