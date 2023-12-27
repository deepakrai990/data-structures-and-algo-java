package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_36_trees_4.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.Stack;

/**
 * @created 21/03/23 5:10 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Least_Common_Ancestor {
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
