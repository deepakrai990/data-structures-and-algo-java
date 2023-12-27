package com.scaler.core.java_3_advance_3.dsa_25_linked_list_2.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:44 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_List_Cycle {
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a, fast = a;
        //move fast by 2 nodes and slow by one node, until
        //1- slow == fast -> loop found
        //2- fast != null && fast.next != null -> no loops found
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        // if slow !=fast -> no loop found
        if (slow != fast) return null;
        //set slow to head
        slow = a;
        //now move slow and fast by 1 node each, and stop when both reach same node
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
