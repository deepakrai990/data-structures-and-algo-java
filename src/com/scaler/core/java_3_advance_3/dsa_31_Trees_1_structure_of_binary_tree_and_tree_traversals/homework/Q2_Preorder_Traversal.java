package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.homework;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 6:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Preorder_Traversal {
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
    private static int[] preorderTraversal(TreeNode A) {
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

    private static Queue<TreeNode> customPreOrder(TreeNode A, Queue<TreeNode> newQueue) {
        if (A == null) {
            return null;
        }
        newQueue.add(A);
        customPreOrder(A.left, newQueue);
        customPreOrder(A.right, newQueue);
        return newQueue;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        int[] results = preorderTraversal(root);
        PrintUtils.print(results);
    }
}
