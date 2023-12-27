package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.homework;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @created 02/04/23 6:18 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Postorder_Traversal {
    /**
     * Definition for binary tree
     * class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) {
     *      val = x;
     *      left=null;
     *      right=null;
     *     }
     * }
     */
    private static ArrayList<Integer> postorderTraversal(TreeNode A) {
        Stack<TreeNode> stack1, stack2;
        ArrayList<Integer> postorder;
        TreeNode node;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        postorder = new ArrayList<>();
        if (A == null)
            return null;
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
            postorder.add(node.val);
        }
        return postorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        ArrayList<Integer> results = postorderTraversal(root);
        PrintUtils.print(results);
    }
}
