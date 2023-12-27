package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.homework;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @created 02/04/23 6:18 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Serialize_Binary_Tree {
    private static int[] solve(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);

        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            if (temp != null)
                list.add(temp.val);
            else {
                list.add(-1);
                continue;
            }
            q.add(temp.left);
            q.add(temp.right);
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        printTree(root);

        PrintUtils.printNewLine();

        int[] results = solve(root);
        PrintUtils.print(results);
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
