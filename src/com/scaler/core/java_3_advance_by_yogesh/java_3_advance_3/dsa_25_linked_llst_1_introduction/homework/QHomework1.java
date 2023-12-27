package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 25/02/23 2:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode t1 = A;
        ListNode t2 = A;
        // calculating the size of linked list;
        int size = 0;
        while (t1 != null) {
            size++;
            t1 = t1.next;
        }
        //formula "[ x=size-B-1 ]" for the starting of Linkedlist instead of last;
        if (B >= size) {
            A = A.next;
            return A;
        } else {
            for (int i = 0; i < size - B - 1; i++) {
                t2 = t2.next;
            }
            t2.next = t2.next.next;
        }
        return A;
    }

}
