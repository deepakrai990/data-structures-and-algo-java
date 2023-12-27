package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree.homework;



import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 12:53 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Left_View_of_Binary_tree {
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
