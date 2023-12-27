package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Deepak Kumar Rai
 * @created 06/11/23
 * @project scaler_course_code
 */
public class Q12_Invert_Binary_Tree_or_Mirror_View_of_Binary_Tree {
    private static TreeNode invertBT(TreeNode root) {
        if (root == null) return null;
        TreeNode invertLeft = invertBT(root.left);
        TreeNode invertRight = invertBT(root.right);
        root.left = invertRight;
        root.right = invertLeft;
        return root;
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // Swap the left and right subtrees
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            // Add non-null children to the queue
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return root;
    }
    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println("Original Tree");
        inOrder(root);
        TreeNode result = invertBT(root);
        System.out.println("\n-------------------------------");
        System.out.println("Inverted Tree");
        inOrder(result);
        System.out.println("\n-------------------------------");
        TreeNode root1 = createTree();
        System.out.println("Original Tree");
        inOrder(root1);
        TreeNode result1 = invertTree(root1);
        System.out.println("\n-------------------------------");
        System.out.println("Inverted Tree");
        inOrder(result1);
    }
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(10);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(3);

        return root;
    }
}
