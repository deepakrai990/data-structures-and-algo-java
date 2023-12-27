package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_K_reverse_linked_list {
    private ListNode reverseList(ListNode A, int B) {
        if (A == null || B == 0) {
            return A;
        }
        ListNode h1 = A;
        ListNode h2 = null;
        ListNode h3 = A;
        int tempB = B;
        while (B > 0 && h1 != null) {
            ListNode temp = h1;
            h1 = h1.next;
            temp.next = h2;
            h2 = temp;
            B--;
        }
        h3.next = reverseList(h1, tempB);
        return h2;
    }
}
