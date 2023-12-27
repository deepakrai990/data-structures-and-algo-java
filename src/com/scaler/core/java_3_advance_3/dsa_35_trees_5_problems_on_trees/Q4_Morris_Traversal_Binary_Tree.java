package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 21/11/23
 * @project scaler_course_code
 */
public class Q4_Morris_Traversal_Binary_Tree {
    private static void inorder(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                // Observation 1: If current visits a node for 1st time, right child of max of LST(Left Sub Tree) print to null
                // Observation 2: if current visits a node for 2nd time, right child of max of LST(Left Sub Tree) points to current
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if (temp.right == null) { // Observation 1
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                    temp.right = null;
                }
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        inorder(root);
    }
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(6);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(29);
        root.right.right.left = new TreeNode(20);
        root.right.right.left.right = new TreeNode(23);
        root.right.right.left.right.right = new TreeNode(25);

        root.right.right.left.left = new TreeNode(15);
        root.right.right.left.left.right = new TreeNode(17);
        root.right.right.left.left.right.right = new TreeNode(19);

        root.right.right.left.left.left = new TreeNode(9);
        root.right.right.left.left.left.right = new TreeNode(10);
        root.right.right.left.left.left.right.right = new TreeNode(13);

        root.right.right.right = new TreeNode(32);
        root.right.right.right.left = new TreeNode(30);
        root.right.right.right.right = new TreeNode(35);
        root.right.right.right.right.right = new TreeNode(39);
        root.right.right.right.right.left = new TreeNode(33);

        return root;
    }
}
