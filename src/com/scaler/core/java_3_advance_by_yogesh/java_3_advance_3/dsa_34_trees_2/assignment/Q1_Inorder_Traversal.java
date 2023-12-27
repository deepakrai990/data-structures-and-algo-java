package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_34_trees_2.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @created 16/03/23 10:16 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Inorder_Traversal {
    /**
     * Definition for binary tree
     * class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) {
     * val = x;
     * left=null;
     * right=null;
     * }
     * }
     */
    private static int[] inorderTraversal(TreeNode A) {
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
}
