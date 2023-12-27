package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 25/02/23 11:18 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
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
