package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @created 19/04/23 8:47 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_InOrderTreeTraversal {
    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = createTreeNode();
        inOrder(root);
    }

    private static TreeNode createTreeNode() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(11);
        root.right = new TreeNode(14);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(2);
        root.right.right.right = new TreeNode(17);
        return root;
    }
}
