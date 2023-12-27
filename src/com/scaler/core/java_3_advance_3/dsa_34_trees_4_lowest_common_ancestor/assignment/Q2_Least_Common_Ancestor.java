package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.Stack;

/**
 * @author Deepak Kumar Rai
 * @created 02/04/23 12:46 pm
 * @project scaler_course_code
 */
public class Q2_Least_Common_Ancestor {
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
    public int lca(TreeNode A, int B, int C) {
        Stack<Integer> pathB = new Stack<>();
        Stack<Integer> pathC = new Stack<>();
        boolean b = searchElementInTree(A, B, pathB);
        boolean c = searchElementInTree(A, C, pathC);
        if (b == false || c == false) {
            return -1;
        }
        int lcm = 0;
        while (!pathB.isEmpty() && !pathC.isEmpty()) {
            if (pathB.peek().equals(pathC.peek())) { // Use Equals Instead of ==
                lcm = pathB.pop();
                pathC.pop();
            } else {
                break;
            }
        }
        return lcm;
    }

    private static boolean searchElementInTree(TreeNode A, int K, Stack<Integer> path) {
        if (A == null) {
            return false;
        }
        if (A.val == K) {
            path.push(A.val);
            return true;
        }
        if (searchElementInTree(A.left, K, path) || searchElementInTree(A.right, K, path)) {
            path.push(A.val);
            return true;
        }
        return false;
    }
}
