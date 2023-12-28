package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.assignment;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.ListNode;

/**
 * @created 21/02/23 3:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Search_in_Linked_List {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    public int solve(ListNode A, int B) {
        if (A == null) {
            return 0;
        }
        int index = 0;
        ListNode temp = A;
        // While loop is used to search the entire Linked
        // List starting from the tail
        while (temp != null) {
            // Returns the index of that particular element,
            // if found.
            if (temp.val == B) {
                return 1;
            }
            // Gradually increases index while
            // traversing through the Linked List
            index++;
            temp = temp.next;
        }
        // Returns -1 if the element is not found
        return -0;
    }
}
