package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree.assignment;


import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 12:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Right_View_of_Binary_tree {
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
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        int[] results = solve(root);
        PrintUtils.print(results);
    }
}
