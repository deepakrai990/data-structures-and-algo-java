package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @created 23/04/23 5:53 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Given_pre_and_inOrder_traversal_of_BT_of_distinct_values_print_post_order {
    /**
     * Given preorder & inorder traversal of Binary Tree of distinct values.
     * Print postorder traversal.
     * **/
    private static void generateAndPrintPostOrderTraversal(int[] pre, int startPre, int endPre, int[] in,
                                                           int startIn, int endIn) {
        TreeNode root = generateTree(pre, startPre, endPre, in, startIn, endIn);
        if (root == null) return;
        postOrder(root);
    }

    private static TreeNode generateTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre && startIn >endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        int index = -1;
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                index = i;
                break;
            }
        }
        int x = index - startIn;
        root.left = generateTree(pre, startPre + 1, startPre + x, in, startIn, index - 1);
        root.right = generateTree(pre, startPre + x + 1, endPre, in, index + 1, endIn);
        return root;
    }
    private static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode preNode = null;
        while(!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.peek();
                if (current.right == null || current.right == preNode) {
                    System.out.print(current.val + " ");
                    stack.pop();
                    preNode = current;
                    current = null;
                } else  {
                    current = current.right;
                }
            }
        }
    }

    private static void generateAndPrintPostOrderTraversal_1(int[] pre, int startPre, int endPre, int[] in,
                                                           int startIn, int endIn) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            hashMap.put(in[i], i);
        }
        TreeNode root = generateTree(pre, startPre, endPre, in, startIn, endIn, hashMap);
        if (root == null) return;
        postOrder(root);
    }

    private static TreeNode generateTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn,
                                         HashMap<Integer, Integer> hashMap) {
        if (startPre > endPre && startIn >endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);

        int index = hashMap.get(pre[startPre]);
        int x = index - startIn;

        root.left = generateTree(pre, startPre + 1, startPre + x, in, startIn, index - 1, hashMap);
        root.right = generateTree(pre, startPre + x + 1, endPre, in, index + 1, endIn, hashMap);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {8, 6, 2, 11, 16, 10, 12, 4, 14, 18, 9, 15};
        int[] in = {11, 2, 16, 6, 10, 12, 8, 14, 18, 4, 9, 15};
        int start = 0;
        int preEnd = pre.length - 1;
        int inEnd = in.length - 1;
        generateAndPrintPostOrderTraversal(pre, start, preEnd, in, start, inEnd);
        System.out.println("\n----------------------------------------");
        generateAndPrintPostOrderTraversal_1(pre, start, preEnd, in, start, inEnd);
    }
}
