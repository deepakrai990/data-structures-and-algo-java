package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 25/02/23 2:25 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    public ListNode deleteDuplicates(ListNode A) {
        if (A == null) {
            return null;
        }
        if (A.next == null) {
            return A;
        }
        ListNode t1 = A;
        ListNode t2 = A;
        while (t2 != null) {
            while (t2 != null && t2.val == t1.val) {
                t2 = t2.next;
            }
            t1.next = t2;
            t1 = t2;
        }
        return A;
    }
}
