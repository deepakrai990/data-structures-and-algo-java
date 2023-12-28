package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.homework;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.ListNode;

/**
 * @created 21/02/23 3:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Compare_Linked_List {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * public int val;
     * public ListNode next;
     * ListNode(int x) { val = x; next = null; }
     * }
     */
    public int solve(ListNode A, ListNode B) {
        while (A.next != null || B.next != null) {
            if (A.val != B.val) {
                return 0;
            }
            A = A.next;
            B = B.next;
        }
        return 1;
    }
}
