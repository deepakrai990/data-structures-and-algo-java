package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 25/02/23 2:25 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    public ListNode reverseList(ListNode A, int B) {
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
