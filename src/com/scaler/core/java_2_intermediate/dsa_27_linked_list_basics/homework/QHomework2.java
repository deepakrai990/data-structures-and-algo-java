package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.homework;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.ListNode;

/**
 * @created 21/02/23 3:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    public int solve(ListNode A) {
        while (A.next != null) {
            int temp = A.next.val;
            if (A.val > temp) {
                return 0;
            }
            temp = A.val;
            A = A.next;
        }
        return 1;
    }
}
