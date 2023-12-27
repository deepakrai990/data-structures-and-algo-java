package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_27_linked_list_3_problems_and_doubly_linked_list.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/03/23 1:21 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    public int lPalin(ListNode head) {
        if (head == null || head.next == null)
            return 1;
        ListNode mid = getMid(head);
        ListNode h2 = mid.next;
        mid.next = null;
        ListNode h1 = head;
        h2 = getReversedLinkedList(h2);

        while (h1 != null && h2 != null) {
            if (h1.val != h2.val)
                return 0;
            h1 = h1.next;
            h2 = h2.next;
        }

        //even length palindrome
        if (h1 == null && h2 == null)
            return 1;

        //odd length palndrome
        if (h1 != null && h1.next == null) {
            return 1;
        }

        return 0;
    }

    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode getReversedLinkedList(ListNode head) {
        if (head == null && head.next == null)
            return head;

        ListNode h1 = head;
        ListNode h2 = head.next;

        while (h2 != null) {
            ListNode temp = h2.next;
            h2.next = h1;
            h1 = h2;
            h2 = temp;
        }
        head.next = null;
        return h1;
    }
}
