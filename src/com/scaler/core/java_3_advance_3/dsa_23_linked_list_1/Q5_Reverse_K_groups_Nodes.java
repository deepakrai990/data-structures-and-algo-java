package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 13/10/23
 * @project scaler_course_code
 */
public class Q5_Reverse_K_groups_Nodes {
    /**
     * Given head of a linked list reverse all groups of sizes K.
     * Where k >= 0.
     * Note: If a group has less than k elements, we still reverse.
     * Note: Recursion-based extra space allowed
     * **/
    private static Node reverseKGroups(Node head, int k) {
        if (head == null || k <= 1) return head;
        Node th = head;
        Node rh = null;
        Node current = head;
        int count = k;
        while (count > 0 && head != null) {
            current = head;
            head = head.next;
            current.next = rh;
            rh = current;
            count = count - 1;
        }
        th.next = head;
        Node x = reverseKGroups(head, k);
        th.next = x;
        return rh;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        CreateLinkedList.printLL(head);

        System.out.println();

        int k = 4;
        Node result = reverseKGroups(head, k);
        CreateLinkedList.printLL(result);
    }
}
