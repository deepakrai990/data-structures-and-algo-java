package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.assignment;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.ListNode;

import java.util.Stack;

/**
 * @created 21/02/23 3:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Print_Reverse_Linked_List {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    public void solve(ListNode A) {
        Stack<Integer> st = new Stack<>();
        ListNode current = A;
        while (current != null) {
            st.push(current.val);
            current = current.next;
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }
}
