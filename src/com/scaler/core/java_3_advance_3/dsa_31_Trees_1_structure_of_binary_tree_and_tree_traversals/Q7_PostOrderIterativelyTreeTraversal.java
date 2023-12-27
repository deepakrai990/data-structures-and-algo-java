package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.Stack;

/**
 * @created 19/04/23 9:01 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q7_PostOrderIterativelyTreeTraversal {
    private static void postOrder(TreeNode A) {
        Stack<TreeNode> stack1, stack2;
        TreeNode node;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        if (A == null) {
            return;
        }
        stack1.push(A);
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);
            if (node.left != null)
                stack1.push(node.left);
            if (node.right != null)
                stack1.push(node.right);
        }
        while (!stack2.isEmpty()) {
            node = stack2.pop();
            System.out.print(node.val + " ");
        }
    }
    private static void postOrder_1(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode preNode = null;
        while(stack.size() > 0 || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.peek();
                if (current.right == null || current.right == preNode) {
                    System.out.print(current.val + " ");
                    stack.pop();
                    preNode = current;
                    current = null;
                } else  {
                    current = current.right;
                }
            }
        }
    }

    private static void postOrder_2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            // traverse down the left subtree
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    System.out.print(curr.val + " ");
                    stack.pop();
                }
                // traverse down the right subtree
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    System.out.print(curr.val + " ");
                    stack.pop();
                }
                // traverse back up from the right subtree
            } else if (curr.right == prev) {
                System.out.print(curr.val + " ");
                stack.pop();
            }
            prev = curr;
        }
    }
    public static void main(String[] args) {
        TreeNode root = createTreeNode();
        postOrder(root);
        System.out.println();
        postOrder_1(root);
        System.out.println();
        postOrder_2(root);
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
