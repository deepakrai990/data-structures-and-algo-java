package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @created 02/04/23 6:16 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Inorder_Traversal {
    public int[] inorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (A != null || !stk.isEmpty()) {
            if (A != null) {
                stk.push(A);
                A = A.left;
            } else {
                A = stk.pop();
                list.add(A.val);
                A = A.right;
            }
        }
        int[] element = new int[list.size()];
        for (int i = 0; i < element.length; i++)
            element[i] = list.get(i);
        return element;
    }

    private static int[] inorderTraversal_1(TreeNode A) {
        if(A == null)
            return null;

        int[] leftArr = inorderTraversal_1(A.left);

        int[] rightArr = inorderTraversal_1(A.right);

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
        int[] results = inorderTraversal_1(root);
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
