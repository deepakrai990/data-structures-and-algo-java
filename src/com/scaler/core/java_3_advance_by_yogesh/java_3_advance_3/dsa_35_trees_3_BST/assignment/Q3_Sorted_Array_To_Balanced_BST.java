package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_35_trees_3_BST.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.List;

/**
 * @created 18/03/23 4:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Sorted_Array_To_Balanced_BST {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final List<Integer> A) {
        if (A.size() == 0)
            return null;

        int root = A.size() / 2;
        TreeNode treeNode = new TreeNode(A.get(root));

        if (A.size() == 1)
            return treeNode;

        treeNode.left = sortedArrayToBST(A.subList(0, root));
        treeNode.right = sortedArrayToBST(A.subList(root + 1, A.size()));
        return treeNode;
    }

    private static TreeNode sortedArrayToBST_1(final int[] A) {
        int s = 0, e = A.length - 1;
        return createBBST(A, s, e);
    }

    private static TreeNode createBBST(int[] A, int s, int e) {
        if (s > e) return null;

        int m = (s + e) / 2;
        TreeNode root = new TreeNode(A[m]);
        root.left = createBBST(A, s, m - 1);
        root.right = createBBST(A, m + 1, e);
        return root;
    }

}
