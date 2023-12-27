package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.LinkedListNode;
import com.scaler.core.utils.PrintUtils;

/**
 * @created 25/02/23 11:18 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(3);
        head.next = new LinkedListNode(-1);
        head.next.next = new LinkedListNode(7);
        head.next.next.next = new LinkedListNode(2);
        head.next.next.next.next = new LinkedListNode(9);
        head.next.next.next.next.next = new LinkedListNode(8);
        int k = 9;
        boolean result = head.search(head, k);

        PrintUtils.printBool(result);
    }
}
