package com.scaler.core.java_3_advance_3.dsa_26_linked_list_3.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:43 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Longest_Palindromic_List {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    private static int solve(ListNode head) {
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

    private static int count(ListNode backward, ListNode forward) {
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
