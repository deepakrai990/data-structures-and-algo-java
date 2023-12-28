package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.assignment;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.ListNode;

/**
 * @created 21/02/23 3:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Insert_in_Linked_List {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    public ListNode solve(ListNode A, int B, int C) {
        ListNode n = new ListNode(B);
        if (C <= 0){
            n.next = A;
            return n;
        }

        int i = 0;
        ListNode temp = A;
        while (i < C - 1 && temp.next != null) {
            i += 1;
            temp = temp.next;
        }

        n.next = temp.next;
        temp.next = n;
        return A;
    }
}
