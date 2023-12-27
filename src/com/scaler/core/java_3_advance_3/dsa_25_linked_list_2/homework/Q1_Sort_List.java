package com.scaler.core.java_3_advance_3.dsa_25_linked_list_2.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sort_List {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMiddle(head);
        ListNode H2 = mid.next;
        mid.next = null;
        ListNode H1 = head;
        H1 = sortList(H1);
        H2 = sortList(H2);
        return mergeTwoLists(H1, H2);
    }

    private static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode sortedHead = null;
        if (A == null) {
            sortedHead = B;
        } else if (B == null) {
            sortedHead = A;
        } else {
            ListNode headA = A;
            ListNode headB = B;

            if (headA.val < headB.val) {
                sortedHead = headA;
                headA = headA.next;
            } else {
                sortedHead = headB;
                headB = headB.next;
            }
            ListNode temp = sortedHead;

            while (headA != null && headB != null) {
                if (headA.val < headB.val) {
                    temp.next = headA;
                    headA = headA.next;
                } else {
                    temp.next = headB;
                    headB = headB.next;
                }
                temp = temp.next;
            }
            if (headA == null) {
                temp.next = headB;
            } else {
                temp.next = headA;
            }
        }
        return sortedHead;
    }

    private static ListNode getMiddle(ListNode head) {
        // Take care of this special case where we want N/2 for even and (N/2)+1 for odd number of elements.
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
