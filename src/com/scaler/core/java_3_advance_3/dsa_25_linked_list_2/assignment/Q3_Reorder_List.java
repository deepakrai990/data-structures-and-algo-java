package com.scaler.core.java_3_advance_3.dsa_25_linked_list_2.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/04/23 6:45 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Reorder_List {
    private static ListNode reorderList(ListNode A) {
        ListNode part1, part2, slow = A, fast = A;
        while ((fast.next != null) && (fast.next.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        part1 = A;
        part2 = slow.next;
        slow.next = null;
        part2 = reverseList(part2);
        // if(1 == 1){ return part2; }
        ListNode newNodeList = part1;
        ListNode tmp = newNodeList;
        part1 = part1.next;

        int i = 0;

        while (part1 != null || part2 != null) {
            // System.out.println("tmp = " + tmp.val);
            if (i % 2 == 0) {
                tmp.next = part2;
                tmp = part2;
                part2 = part2.next;
            } else {
                tmp.next = part1;
                tmp = part1;
                part1 = part1.next;
            }
            i++;
        }
        return newNodeList;
    }

    private static ListNode reverseList(ListNode A) {
        ListNode pre = null, curr = A;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}
