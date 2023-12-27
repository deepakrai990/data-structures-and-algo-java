package com.scaler.core.java_3_advance_3.dsa_26_linked_list_3.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:44 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Partition_List {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    private static ListNode partition(ListNode A, int B) {
        ListNode beforeStart = null;
        ListNode beforeEnd = null;

        ListNode afterStart = null;
        ListNode afterEnd = null;

        while (A != null) {
            ListNode nxt = A.next;
            A.next = null;
            if (A.val < B) {
                if (beforeStart == null) {
                    beforeStart = A;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = A;
                    beforeEnd = A;
                }
            } else {
                if (afterStart == null) {
                    afterStart = A;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = A;
                    afterEnd = A;
                }
            }
            A = nxt;
        }
        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
