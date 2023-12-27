package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.assignment;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.ListNode;

/**
 * @created 18/10/22 1:12 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    public void solve(ListNode A) {
        ListNode current = A;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //A = 4 -> 3 -> 2 -> 1
        ListNode head = new ListNode(4);
        ListNode next1 = new ListNode(3);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(1);
        head.next = next1;
        head.next.next = next2;
        head.next.next.next = next3;

    }
}
