package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @created 14/03/23 3:47 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q6_Postorder_Traversal {
    private static int[] postorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null) {
            return new int[]{};
        }
        TreeNode pre = null;
        Stack<TreeNode> stk = new Stack<>();
        while (A != null || !stk.empty()) {
            if (A != null) {
                stk.push(A);
                A = A.left;
            } else {
                A = stk.peek();
                if (A.right == null || A.right == pre) { // means we have traversed right subtree already
                    list.add(A.val);
                    stk.pop();
                    pre = A;
                    A = null; // we don't go down to left child again
                } else {
                    A = A.right; // Traverse the right subtree before adding root
                }
            }
        }
        int[] value = new int[list.size()];
        for (int i = 0; i < value.length; i++)
            value[i] = list.get(i);
        return value;
    }
    private static int[] postorderTraversal_1(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        if(A == null) {
            return new int[]{};
        }

        TreeNode current = A;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                list.add(current.val);
                current = current.right;
            }

            current = stack.pop();
            current = current.left;
        }

        Collections.reverse(list);
        int[] results = new int[list.size()];
        for (int i = 0; i < results.length; i++)
            results[i] = list.get(i);
        return results;
    }
}
