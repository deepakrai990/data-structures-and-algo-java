package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @created 14/03/23 3:41 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Preorder_Traversal {
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
    public int[] preorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (A != null || !stk.isEmpty()) {
            if (A != null) {
                list.add(A.val);
                stk.push(A);
                A = A.left;
            } else {
                A = stk.pop();
                A = A.right;
            }
        }
        int[] value = new int[list.size()];
        for (int i = 0; i < value.length; i++)
            value[i] = list.get(i);
        return value;
    }
}
