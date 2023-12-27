package com.scaler.core.java_3_advance_3.dsa_33_trees_3_binary_search_tree.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @created 02/04/23 12:48 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Largest_BST_Subtree {

    class TreeInfo {
        Long max;
        Long min;
        Integer size;
        Boolean isBST;

        public TreeInfo(Long max, Long min, Integer size, Boolean isBST) {
            this.max = max;
            this.min = min;
            this.size = size;
            this.isBST = isBST;
        }
    }

    Integer maxSize = Integer.MIN_VALUE;

    public int solve(TreeNode root) {
        traverse(root);
        return maxSize;
    }

    public TreeInfo traverse(TreeNode root) {
        if (root == null)
            return new TreeInfo(Long.MIN_VALUE, Long.MAX_VALUE, 0, true);

        TreeInfo left = traverse(root.left);
        TreeInfo right = traverse(root.right);

        if (left.isBST && right.isBST && root.val >= left.max && root.val < right.min) {
            int currSize = left.size + right.size + 1;
            maxSize = Math.max(maxSize, currSize);
            return new TreeInfo(
                    Math.max(root.val, right.max),
                    Math.min(root.val, left.min),
                    currSize,
                    true
            );
        } else {
            return new TreeInfo(
                    Math.max(root.val, right.max),
                    Math.min(root.val, left.min),
                    left.size + right.size + 1,
                    false
            );
        }
    }
}
