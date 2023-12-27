package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.Stack;

/**
 * @created 19/04/23 9:01 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q6_PreOrderIterativelyTreeTraversal {
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || current != null) {
            while (current != null) {
                stack.push(current);
                System.out.print(current.val + " ");
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = createTreeNode();
        preOrder(root);
    }

    private static TreeNode createTreeNode() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(10);
        root.left.left.right.left = new TreeNode(20);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(20);
        root.right.left.left = new TreeNode(19);
        root.right.left.left.right = new TreeNode(40);
        return root;
    }
}
