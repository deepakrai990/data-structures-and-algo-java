package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_34_trees_2.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 16/03/23 10:17 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Right_View_of_Binary_tree {
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
    private static int[] solve(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null) {
            return new int[]{};
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode parent = q.peek();
                if (parent.left != null) {
                    q.add(parent.left);
                }
                if (parent.right != null) {
                    q.add(parent.right);
                }
                if (i == len - 1) {
                    list.add(parent.val);
                }
                q.poll();
            }
        }
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}
