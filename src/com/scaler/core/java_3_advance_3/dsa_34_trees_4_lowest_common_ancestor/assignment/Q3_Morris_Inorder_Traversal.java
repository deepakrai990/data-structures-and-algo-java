package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @created 02/04/23 12:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Morris_Inorder_Traversal {

    List<Integer> list = new ArrayList<>();

    public int[] solve(TreeNode root) {
        morrisInorderTraversal(root);

        int n = list.size();
        int[] inOrder = new int[n];
        for (int i = 0; i < n; i++) {
            inOrder[i] = list.get(i);
        }

        return inOrder;
    }

    public void morrisInorderTraversal(TreeNode root) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.left == null) {// LST is processed
                list.add(temp.val);
                temp = temp.right;
            } else {
                TreeNode rightMostNode = findRightMostNode(temp);//will find out the right most node of the LST
                if (rightMostNode.right == null) {// if there is no connection with root - establish it
                    rightMostNode.right = temp;
                    temp = temp.left;
                } else {//if there is a connection exist means LST is processed - remove the connection
                    rightMostNode.right = null;
                    list.add(temp.val);//process the root node and go to RST
                    temp = temp.right;
                }
            }
        }
    }

    public TreeNode findRightMostNode(TreeNode root) {
        TreeNode temp = root.left;
        while (temp.right != null && temp.right != root)
            temp = temp.right;
        return temp;
    }
}
