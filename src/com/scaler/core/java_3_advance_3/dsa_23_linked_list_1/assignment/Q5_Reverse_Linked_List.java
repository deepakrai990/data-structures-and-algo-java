package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:50 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Reverse_Linked_List {
    private static ListNode reverseList(ListNode A) {
        ListNode head = A;
        ListNode prev = null;
        ListNode curr = A;

        while (curr != null) {
            ListNode currP1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currP1;
        }

        head = prev;
        return head;
    }
}
