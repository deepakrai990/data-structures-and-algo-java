package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_26_linked_list_2_sorting_and_detecting_loop.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 28/02/23 10:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    public ListNode solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        // Slow and fast pointer : Hare and tortoise
        slow = slow.next;
        fast = fast.next.next;
        while (slow != fast) { // slow and fast will meet at transaction point
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = A; // reinitializing slow to head of node
        ListNode temp = null;
        while (slow != fast) {
            temp = fast;
            // to move 2 slow pointers which will meet at loop
            slow = slow.next;
            fast = fast.next;
        }
        // to break the loop
        if (slow.next == slow) {
            slow.next = null;
        } else {
            temp.next = null;
        }
        return A;
    }
}
