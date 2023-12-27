package com.scaler.core.java_3_advance_3.dsa_26_linked_list_3.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:42 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Palindrome_List {
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

    public int lPalin_1(ListNode A) {
        if (A == null) return 0; //If Linked List is empty
        ListNode p1 = A;
        ListNode middle = getMiddle(A); //get the middle of LL
        ListNode p2 = middle.next; //assign middle next element as head of LL 2
        middle.next = null; //Break the linked list
        ListNode rl = reverse(p2); //Reverse the LL
        while (p1 != null && rl != null) {   //Compare val of two LL if not equal return 0 else inc both LL
            if (p1.val == rl.val) {
                p1 = p1.next;
                rl = rl.next;
            } else {
                return 0;
            }
        }
        return 1;
    }
    //Get the middle node of the linked list
    static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //Reverse the given Linked List
    static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
