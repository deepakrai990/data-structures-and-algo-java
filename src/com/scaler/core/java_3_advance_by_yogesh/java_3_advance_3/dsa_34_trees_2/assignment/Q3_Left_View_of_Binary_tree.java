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
public class Q3_Left_View_of_Binary_tree {
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
    public int[] solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        queue.add(A);
        queue.add(null);

        list.add(A.val);

        while (queue.size() != 0) {
            TreeNode curr = queue.remove();
            if (curr != null) {
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            } else if (queue.size() != 0) {
                list.add(queue.peek().val);
                queue.add(null);
            }
        }
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}
