package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;
import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 12/10/23
 * @project scaler_course_code
 */
public class Q1_Size_of_LinkedList {
    private static int size(Node head) {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(5, 2, 7, 9, 11, 6, 21);
        int result = size(head);
        PrintUtils.print(result);
    }
}
