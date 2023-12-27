package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_27_linked_list_3_problems_and_doubly_linked_list.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/03/23 1:29 pm
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
    public int solve(ListNode head) {
        ListNode prev = null, curr = head;
        int result = 0;
        while (curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            result = Math.max(result, 2 * count(prev, currNext) + 1);
            result = Math.max(result, 2 * count(curr, currNext));
            prev = curr;
            curr = currNext;
        }
        return result;
    }

    private int count(ListNode backward, ListNode forward) {
        int count = 0;
        while (backward != null && forward != null) {
            if (backward.val == forward.val) {
                count++;
            } else {
                break;
            }
            backward = backward.next;
            forward = forward.next;
        }
        return count;
    }
}
