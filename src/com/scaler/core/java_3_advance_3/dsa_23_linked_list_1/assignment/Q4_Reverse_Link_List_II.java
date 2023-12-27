package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Reverse_Link_List_II {
    private ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode head = A;
        ListNode current = A;
        ListNode first = null;
        ListNode from = null;
        ListNode to = null;
        ListNode last = null;

        int count = 0;
        while (current != null) {
            count++;

            if (count < B) {
                first = current;
            }
            if (count == B) {
                from = current;
            }
            if (count == C) {
                to = current;
                last = to.next;
                break;
            }
            current = current.next;
        }
        to.next = null;
        reverse(from);

        if (first != null)
            first.next = to;
        else
            A = to;

        from.next = last;
        return A;
    }

    //reverse the linked list
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

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
