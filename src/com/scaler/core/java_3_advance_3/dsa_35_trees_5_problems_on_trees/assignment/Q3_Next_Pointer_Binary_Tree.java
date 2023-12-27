package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_36_trees_4.model.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 12:43 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Next_Pointer_Binary_Tree {
    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     *     int val;
     *     TreeLinkNode left, right, next;
     *     TreeLinkNode(int x) { val = x; }
     * }
     */
    private static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> qe = new LinkedList<TreeLinkNode>();
        qe.offer(root);
        while (!qe.isEmpty()) {
            int size = qe.size();
            TreeLinkNode temp = null;
            TreeLinkNode tempNext = null;
            for (int i = 0; i < size; i++) {
                if (temp == null) {
                    temp = qe.poll();
                } else {
                    tempNext = qe.poll();
                    temp.next = tempNext;
                    temp = tempNext;
                    tempNext = null;
                }
                if (temp.left != null) {
                    qe.offer(temp.left);
                }
                if (temp.right != null) {
                    qe.offer(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
