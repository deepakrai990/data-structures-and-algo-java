package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor.homework;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.HashSet;

/**
 * @created 02/04/23 12:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Common_Nodes_in_Two_BST {
    HashSet<Integer> set = new HashSet();
    long sum = 0;

    public int solve(TreeNode A, TreeNode B) {
        morrisInorder(A);
        morrisInorder(B);
        return (int) (sum % ((int) (1e9 + 7)));
    }

    private void morrisInorder(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                if (set.contains(curr.val)) sum += curr.val;
                else set.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    if (set.contains(curr.val)) sum += curr.val;
                    else set.add(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
}
