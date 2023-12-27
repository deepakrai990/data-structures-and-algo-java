package com.scaler.core.java_3_advance_3.dsa_38_tries_2.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @created 02/04/23 11:31 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Flatten_Binary_Tree_to_Linked_List {
    TreeNode prev = null;

    public TreeNode flatten(TreeNode a) {
        if (a == null) return null;
        flatten(a.right);
        flatten(a.left);
        a.right = prev;
        a.left = null;
        prev = a;
        return a;
    }
}
