package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @created 14/03/23 3:35 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Inorder_Traversal {
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
    private static int[] inorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = A;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        int[] element = new int[list.size()];
        for (int i = 0; i < element.length; i++)
            element[i] = list.get(i);
        return element;
    }
    private static int[] inorderTraversal_1(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (A != null || !stk.isEmpty()) {
            if (A != null) {
                stk.push(A);
                A = A.left;
            } else {
                A = stk.pop();
                list.add(A.val);
                A = A.right;
            }
        }
        int[] element = new int[list.size()];
        for (int i = 0; i < element.length; i++)
            element[i] = list.get(i);
        return element;
    }
    private static ArrayList<Integer> inorderTraversal_2(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        traverseTree(A, list);
        return list;
    }
    private static void traverseTree(TreeNode root, ArrayList list) {
        if (root != null) {
            traverseTree(root.left, list);
            list.add(root.val);
            traverseTree(root.right, list);
        }
    }

}
