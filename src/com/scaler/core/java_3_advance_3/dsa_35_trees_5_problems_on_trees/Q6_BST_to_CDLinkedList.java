package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 21/11/23
 * @project scaler_course_code
 */
public class Q6_BST_to_CDLinkedList {
    private static TreeNode BSTToCDLikedList(TreeNode root) {
        if (root == null) return null;
        TreeNode head1 = BSTToCDLikedList(root.left);
        TreeNode head2 = BSTToCDLikedList(root.right);
        root.left = root;
        root.right = root;
        head1 = combine(head1, root);
        head1 = combine(head1, head2);
        return head1;
    }
    private static TreeNode combine(TreeNode head1, TreeNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        TreeNode temp1 = head1.left;
        TreeNode temp2 = head2.left;
        temp1.right = head2;
        head2.left = temp1;
        head1.left = temp2;
        temp2.right = head1;
        return head1;
    }
    private static void printCircularList(TreeNode head) {
        if (head == null) return;

        TreeNode current = head;
        do {
            System.out.print(current.val + " ");
            current = current.right;
        } while (current != head);

        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode circularListHead = BSTToCDLikedList(root);

        System.out.println("Circular Doubly Linked List:");
        printCircularList(circularListHead);
    }
}
