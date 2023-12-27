package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.RandomListNode;

/**
 * @created 25/02/23 11:21 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode temp = head;
        RandomListNode next = null;
        RandomListNode random = null;
        //Insert new nodes between previous nodes.
        while (temp != null) {
            next = temp.next;
            RandomListNode nw = new RandomListNode(temp.label);
            temp.next = nw;
            nw.next = next;
            temp = next;
        }
        //Point new nodes with their random values.
        temp = head;
        while (temp != null) {
            random = temp.random;
            if (random != null)
                temp.next.random = random.next;
            temp = temp.next.next;
        }
        //Unlink previous nodes and return list of new nodes
        head = head.next;
        temp = head;
        while (temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return head;
    }
}
