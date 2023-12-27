package com.scaler.core.java_3_advance_3.dsa_33_trees_3_binary_search_tree.homework;



import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @created 02/04/23 12:50 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Two_Sum_BST {
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
    private static int t2Sum(TreeNode root, int B) {
        Stack<TreeNode> forwardIterator = new Stack<>();//with the help of this I can move in increasing order
        Stack<TreeNode> backwardIterator = new Stack<>();//with the help of this I can move in decreasing order

        if (root == null)
            return 0;

        TreeNode temp = root;
        while (temp != null) {//reached the left most ndoe of tree also known as smallest value of tree
            forwardIterator.push(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {//reached the right most node of tree also known as max value of tree
            backwardIterator.push(temp);
            temp = temp.right;
        }

        while (!forwardIterator.isEmpty() && !backwardIterator.isEmpty()) {
            //consider l and r as 2 pointers in the same way if the same problem came with sorted array structure
            TreeNode l = forwardIterator.peek();
            TreeNode r = backwardIterator.peek();
            int sum = l.val + r.val;

            if (sum == B && l != r)//can’t access same nodes
                return 1;
            if (sum >= B) {//need to decrease value of r ---- How? Ans = go to left node of current r and go to its right most node
                TreeNode temp2 = backwardIterator.pop();
                if (temp2.left != null) {
                    backwardIterator.push(temp2.left);
                    TreeNode temp3 = backwardIterator.peek().right;
                    while (temp3 != null) {
                        backwardIterator.push(temp3);
                        temp3 = temp3.right;
                    }
                }
            } else {//need to increase value of l ---- How? Ans = go to right node of current l and go to its left most node
                TreeNode temp2 = forwardIterator.pop();
                if (temp2.right != null) {
                    forwardIterator.push(temp2.right);
                    TreeNode temp3 = forwardIterator.peek().left;
                    while (temp3 != null) {
                        forwardIterator.push(temp3);
                        temp3 = temp3.left;
                    }
                }
            }
        }
        return 0;
        //!that’s it
    }

    private static int t2Sum_1(TreeNode A, int B) {
        //Create a Hashmap to use Simple two sum approach
        Map<Integer, Integer> hm = new HashMap<>();

        // PostOrder Tree Traversal
        return traverse(A, hm, B);
    }

    private static int traverse(TreeNode A, Map<Integer, Integer> hm, int B) {
        if (A == null) {
            return 0;
        }
        if (hm.get(B - A.val) != null) {
            return 1;
        }
        hm.put(A.val, 1);
        if (traverse(A.left, hm, B) == 1 || traverse(A.right, hm, B) == 1) {
            return 1;
        }
        return 0;
    }
}
