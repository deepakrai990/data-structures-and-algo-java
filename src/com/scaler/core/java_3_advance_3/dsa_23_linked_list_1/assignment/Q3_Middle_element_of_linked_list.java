package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Middle_element_of_linked_list {
    private int solve(ListNode A) {
        ListNode head = A;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next == null) {
            return slow.val;
        }
        return slow.next.val;
    }
}
