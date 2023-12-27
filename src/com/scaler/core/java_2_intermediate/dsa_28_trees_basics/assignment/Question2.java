package com.scaler.core.java_2_intermediate.dsa_28_trees_basics.assignment;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 21/02/23 3:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
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
        Queue<TreeNode> newFreshQueue = new LinkedList<>();
        Queue<TreeNode> newQueue = customPreOrder(A, newFreshQueue);
        int[] arr = new int[newQueue.size()];
        int i = 0;
        while (!newQueue.isEmpty()) {
            arr[i] = newQueue.remove().val;
            i++;
        }
        return arr;
    }

    public Queue<TreeNode> customPreOrder(TreeNode A, Queue<TreeNode> newQueue) {
        if (A == null) {
            return null;
        }
        newQueue.add(A);
        customPreOrder(A.left, newQueue);
        customPreOrder(A.right, newQueue);
        return newQueue;
    }
}
