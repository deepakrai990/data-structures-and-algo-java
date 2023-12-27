package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_27_linked_list_3_problems_and_doubly_linked_list.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/03/23 1:34 pm
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
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if (A == null || B == null) {
            return null;
        }

        ListNode tempA = A;
        while (A.next != null) {
            A = A.next;
        }
        A.next = tempA;
        ListNode slow = B.next;
        if (B.next == null) {
            return null;
        }
        ListNode fast = B.next.next;
        while (fast != slow) {
            if (slow == null || fast == null || fast.next == null) {
                return null;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        slow = B;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        A.next = null;
        return slow;
    }
}
