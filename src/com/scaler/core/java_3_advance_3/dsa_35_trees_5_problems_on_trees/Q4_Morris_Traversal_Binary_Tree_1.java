package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 21/11/23
 * @project scaler_course_code
 */
public class Q4_Morris_Traversal_Binary_Tree_1 {
    private static void morrisInorderTraversal(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                TreeNode predecessor = findPredecessor(current);

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }

    private static TreeNode findPredecessor(TreeNode node) {
        TreeNode predecessor = node.left;
        while (predecessor.right != null && predecessor.right != node) {
            predecessor = predecessor.right;
        }
        return predecessor;
    }

    // Preorder Traversal
    private static void morrisPreorderTraversal(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                TreeNode predecessor = findPredecessor(current);

                if (predecessor.right == null) {
                    System.out.print(current.val + " ");
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Morris Inorder Traversal:");
        morrisInorderTraversal(root);

        System.out.println();

        System.out.println("Morris Preorder Traversal:");
        morrisPreorderTraversal(root);
    }
}
