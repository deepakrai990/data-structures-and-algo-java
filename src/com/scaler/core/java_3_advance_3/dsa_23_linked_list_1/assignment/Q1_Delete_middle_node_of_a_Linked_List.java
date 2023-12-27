package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Delete_middle_node_of_a_Linked_List {
    private static ListNode solve(ListNode A) {
        if (A.next == null) return null;
        ListNode fast = A, slow = A, lastslow = A;
        while (fast != null && fast.next != null) {
            lastslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        lastslow.next = lastslow.next.next;
        return A;
    }
}
