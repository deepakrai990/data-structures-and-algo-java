package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_26_linked_list_2_sorting_and_detecting_loop.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 01/03/23 1:33 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    public ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode h = A;
        ListNode h1 = A;
        ListNode h2 = A.next;
        h1.next = h2.next;
        h = h2;
        h2.next = h1;

        ListNode t = h.next;
        while (t != null && t.next != null && t.next.next != null) {
            ListNode t1 = t.next;
            ListNode t2 = t.next.next;
            t1.next = t2.next;
            t.next = t2;
            t2.next = t1;
            t = t.next.next;
        }
        return h;
    }
}
