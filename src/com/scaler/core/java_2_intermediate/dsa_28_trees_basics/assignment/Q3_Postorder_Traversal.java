package com.scaler.core.java_2_intermediate.dsa_28_trees_basics.assignment;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @created 21/02/23 3:25 pm
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
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
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
}
