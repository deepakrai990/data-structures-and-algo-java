package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_26_linked_list_2_sorting_and_detecting_loop.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 01/03/23 1:34 pm
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
    private static ListNode addTwoNumbers(ListNode A, ListNode B) {
        if (B == null) return A;
        if (A == null) return B;

        ListNode t1 = A;
        ListNode t2 = B;
        int carry = 0;
        int sum = 0;
        int actualsum = t1.val + t2.val;
        sum = actualsum % 10;
        carry = actualsum / 10;
        ListNode h = new ListNode(sum);
        ListNode t = h;
        ListNode pt1 = t1.next;
        ListNode pt2 = t2.next;
        while (pt1 != null || pt2 != null) {
            int actsum = 0;
            if (pt1 != null) {
                actsum += pt1.val;
                pt1 = pt1.next;
            }
            if (pt2 != null) {
                actsum += pt2.val;
                pt2 = pt2.next;
            }

            actsum += carry;
            sum = actsum % 10;
            carry = actsum / 10;
            t.next = new ListNode(sum);
            t = t.next;
        }
        while (carry > 0) {
            int s = carry % 10;
            carry = carry / 10;
            t.next = new ListNode(s);
            t = t.next;
        }
        return h;
    }
}
