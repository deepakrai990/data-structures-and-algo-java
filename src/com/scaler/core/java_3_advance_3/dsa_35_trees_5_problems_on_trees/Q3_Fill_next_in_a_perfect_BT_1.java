package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees;

import com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 21/11/23
 * @project scaler_course_code
 */
public class Q3_Fill_next_in_a_perfect_BT_1 {
    private static void connectNextPointers(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftMost = root;
        while (leftMost.left != null) {
            TreeNode current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createTree();

        connectNextPointers(root);

        TreeNode node = root;
        while (node != null) {
            TreeNode currentLevel = node;
            while (currentLevel != null) {
                System.out.print(currentLevel.val + " ");
                currentLevel = currentLevel.next;
            }
            System.out.println();
            node = node.left;
        }
    }

    private static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }
}
