package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.homework;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 6:18 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Deserialize_Binary_Tree {
    private static TreeNode solve(int[] A) {
        TreeNode root = new TreeNode(A[0]);
        Queue<TreeNode> q = new LinkedList<>();
        int index = 1;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            if (temp == null)
                continue;
            TreeNode node;
            for (int i = 0; i < 2; i++) { //for left and right child
                if (A[index] == -1) {
                    node = null;
                } else
                    node = new TreeNode(A[index]);
                index++;
                if (i % 2 == 0) {
                    temp.left = node;
                    q.add(temp.left);
                } else {
                    temp.right = node;
                    q.add(temp.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1};
        TreeNode result = solve(A);
        printTree(result);
    }
    private static void printTree(TreeNode root) {
        printTreeUtil(root, "", "");
    }

    private static void printTreeUtil(TreeNode node, String prefix, String edgeLabel) {
        if (node != null) {
            System.out.println(prefix + edgeLabel + node.val);

            // Recursively print the children with appropriate edge labels
            if (node.left != null || node.right != null) {
                String childPrefix = prefix + "    ";
                String leftEdgeLabel = "left: ";
                String rightEdgeLabel = "right: ";

                if (node.left != null) {
                    printTreeUtil(node.left, childPrefix, leftEdgeLabel);
                } else {
                    System.out.println(childPrefix + leftEdgeLabel);
                }

                if (node.right != null) {
                    printTreeUtil(node.right, childPrefix, rightEdgeLabel);
                } else {
                    System.out.println(childPrefix + rightEdgeLabel);
                }
            }
        }
    }
}
