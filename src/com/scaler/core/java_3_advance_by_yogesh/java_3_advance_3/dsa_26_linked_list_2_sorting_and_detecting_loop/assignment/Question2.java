package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_26_linked_list_2_sorting_and_detecting_loop.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 28/02/23 10:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    public int solve(ListNode A) {
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
