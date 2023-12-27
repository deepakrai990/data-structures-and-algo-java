package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 02/04/23 12:47 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Distance_between_Nodes_of_BST {
    public int solve(TreeNode root, int B, int C) {
        TreeNode lca = findLCA(root, B, C); // find out lca
        int a = findHeight(lca, B); //find height of B and C from lca
        int b = findHeight(lca, C);
        return a + b; //return addition of height
    }

    private static int findHeight(TreeNode root, int a) {
        int count = 0;
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > a)
                temp = temp.left;
            else if (temp.val < a)
                temp = temp.right;
            else
                return count;
            count++;
        }
        return -1;
    }

    private static TreeNode findLCA(TreeNode root, int B, int C) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val < B && temp.val < C)
                temp = temp.right;
            else if (temp.val > B && temp.val > C)
                temp = temp.left;
            else
                return temp;
        }
        return root;
    }
}
