package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:50 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Remove_Nth_Node_from_List_End {
    private ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode t1 = A;
        ListNode t2 = A;
        // calculating the size of linked list;
        int size = 0;
        while (t1 != null) {
            size++;
            t1 = t1.next;
        }
        //formula "[ x=size-B-1 ]" for the starting of Linked list instead of last;
        if (B >= size) {
            A = A.next;
            return A;
        } else {
            for (int i = 0; i < size - B - 1; i++) {
                t2 = t2.next;
            }
            t2.next = t2.next.next;
        }
        return A;
    }

    public ListNode removeNthFromEnd1(ListNode head, int B) {
        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer B+1 nodes ahead
        for (int i = 0; i < B + 1; i++) {
            // Handle the case where B is greater than or equal to the size of the list
            if (fast == null) {
                assert head != null;
                return head.next; // Remove the first node
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Adjust pointers to skip the B-th node from the end
        assert slow != null;
        slow.next = slow.next.next;

        return head;
    }
}
