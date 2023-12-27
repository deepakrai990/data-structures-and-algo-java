package com.scaler.core.java_2_intermediate.dsa_28_trees_basics.assignment;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

import java.util.Arrays;

/**
 * @created 29/12/22 9:22 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Inorder_Traversal {
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
    private static int[] inorderTraversal(TreeNode A) {
        if(A == null)
            return null;

        int[] leftArr = inorderTraversal(A.left);

        int[] rightArr = inorderTraversal(A.right);

        int totalSize = leftArr != null ? leftArr.length : 0;
        totalSize += rightArr != null ? rightArr.length : 0;
        totalSize += 1;

        int[] arr = new int[totalSize];

        int rightArrStart = 0;
        if(leftArr != null){
            System.arraycopy(leftArr, 0, arr, 0, leftArr.length);
            rightArrStart = leftArr.length;
        }

        arr[rightArrStart++] = A.val;

        if(rightArr != null){
            System.arraycopy(rightArr, 0, arr, rightArrStart, rightArr.length);
        }

        return arr;
    }

    public static void main(String[] args) {
        TreeNode root = buildTreeNode();
        int[] results = inorderTraversal(root);
        System.out.println(Arrays.toString(results));
    }
    private static TreeNode buildTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }
}
