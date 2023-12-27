package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Remove_Duplicates_from_Sorted_List {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    private ListNode deleteDuplicates(ListNode A) {
        if (A == null) {
            return null;
        }
        if (A.next == null) {
            return A;
        }
        ListNode t1 = A;
        ListNode t2 = A;
        while (t2 != null) {
            while (t2 != null && t2.val == t1.val) {
                t2 = t2.next;
            }
            t1.next = t2;
            t1 = t2;
        }
        return A;
    }
}
