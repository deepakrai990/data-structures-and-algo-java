package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.Stack;

/**
 * @created 19/04/23 8:52 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_InOrderIterativelyTreeTraversal {
    private static void inOrder(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stk = new Stack<>();
        while (stk.size() > 0 || current != null) {
            while (current != null) {
                stk.push(current);
                current = current.left;
            }
            current = stk.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = createTreeNode();
        inOrder(root);
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
