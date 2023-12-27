package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_35_trees_3_BST.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;

/**
 * @created 18/03/23 4:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Recover_Binary_Search_Tree {

    private static int[] recoverTree(TreeNode A) {
        return recoverTree_1(A);
    }
    private static int[] recoverTree_1(TreeNode root) {
        int prev = Integer.MIN_VALUE;
        int d1 = -1;
        int d2 = -1;
        TreeNode curr = root;
        ArrayList<Integer> output = new ArrayList<>();
        boolean isFirst = true;
        while (curr != null) {
            if (prev >= curr.val) {
                if (d1 == -1) {
                    d1 = prev;
                    d2 = curr.val;
                } else {
                    isFirst = false;
                    d2 = curr.val;
                }
            }
            if (curr.left == null) {
                //Process it
                if (prev < curr.val && isFirst) {
                    prev = curr.val;
                }
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    //Process the current
                    if (prev < curr.val && isFirst) {
                        prev = curr.val;
                    }

                    curr = curr.right;
                }
            }
        }
        output.add(d2);
        output.add(d1);
        int[] arr = output.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}
