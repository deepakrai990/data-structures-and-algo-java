package com.scaler.core.java_3_advance_3.dsa_25_linked_list_2.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Merge_Two_Sorted_Lists {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    private static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = null, temp;
        /* 1st we are giving direction to head of merged LL */
        if (A.val < B.val) {
            head = A;
            temp = A;
            A = A.next;
        } else {
            head = B;
            temp = B;
            B = B.next;
        }
        /* now we are merging using merge 2 sorted arrays concept */
        while (A != null && B != null) {
            if (A.val < B.val) {
                temp.next = A;
                temp = A;
                A = A.next;
            } else {
                temp.next = B;
                temp = B;
                B = B.next;
            }
        }
        if (A == null) {
            temp.next = B;
        }
        if (B == null) {
            temp.next = A;
        }
        return head;
    }
}
