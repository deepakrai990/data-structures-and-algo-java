package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 02/04/23 12:44 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Identical_Binary_Trees {
    // Solution using Morris Algorithm
    private static int isSameTree(TreeNode A, TreeNode B) {
        TreeNode headA = A;
        TreeNode headB = B;

        while (headA != null && headB != null) {
            if (headA.left == null && headB.left == null) {
                if (headA.val != headB.val) {
                    return 0;
                } else {
                    headA = headA.right;
                }
                headB = headB.right;
            } else if (headA.left != null && headB.left != null) {
                TreeNode tempA = headA.left;
                TreeNode tempB = headB.left;
                while ((tempA.right != null && tempA.right != headA)
                        && (tempB.right != null && tempB.right != headB)) {
                    tempA = tempA.right;
                    tempB = tempB.right;
                }
                if (tempA.right == null && tempB.right == null) {
                    tempA.right = headA;
                    headA = headA.left;
                    tempB.right = headB;
                    headB = headB.left;
                } else if (tempA.right == headA && tempB.right == headB) {
                    headA.right = null;
                    headB.right = null;

                    if (headA.val != headB.val) {
                        return 0;
                    } else {
                        headA = headA.right;
                    }
                    headB = headB.right;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
        return 1;
    }

    private static int isSameTree_1(TreeNode A, TreeNode B) {
        boolean ans = isIdentical(A, B);
        if (ans) return 1;
        else return 0;
    }

    private static boolean isIdentical(TreeNode A, TreeNode B) {
        //base conditions
        if (A == null && B == null) return true;
        if (A == null) return false;
        if (B == null) return false;
        // validate left sub tree
        boolean left = isIdentical(A.left, B.left);
        //validate right sub tree
        boolean right = isIdentical(A.right, B.right);
        //if both LST and RST are true , check for root node
        if (left && right) {
            if (A.val == B.val) {
                return true;
            }
        }
        return false;
    }

    private static int isSameTree_2(TreeNode A, TreeNode B) {
        if (A == null && B != null) return 0;
        if (A != null && B == null) return 0;
        if (A == null && B == null) return 1;

        if (A.val != B.val) return 0;

        int isSame = isSameTree_2(A.left, B.left);
        if (isSame == 0) {
            return 0;
        }
        isSame = isSameTree_2(A.right, B.right);
        if (isSame == 0) {
            return 0;
        }
        return 1;
    }
}
