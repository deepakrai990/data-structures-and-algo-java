package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.assignment;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.ListNode;

/**
 * @created 21/02/23 3:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    public ListNode solve(ListNode A, int B) {
        if (B == 0) {
            return A.next;
        }

        ListNode temp = A;
        int count = 0;
        while (temp.next != null) {
            if (count == B - 1){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            count++;
        }
        return A;
    }
}
