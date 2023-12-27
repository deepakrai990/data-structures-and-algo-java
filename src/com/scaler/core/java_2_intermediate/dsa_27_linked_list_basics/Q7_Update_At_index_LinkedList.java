package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 10/10/23
 * @project scaler_course_code
 */
public class Q7_Update_At_index_LinkedList {
    private static Node insertAtIndex(Node head, int val, int k) {
        if (k == 0) {
            head =  insertAtStart(head, val);
        } else {
            int count = 0;
            Node temp = new Node(val);
            Node curr = head;
            while (count < k - 1) {
                curr = curr.next;
                count++;
            }
            temp.next = curr.next.next;
            curr.next = temp;
        }
        return head;
    }
    private static Node insertAtStart(Node head, int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        return head;
    }
    public static void main(String[] args) {
        Node head_ = CreateLinkedList.build(16, 12, 15, 20, 7, 78);
        int k_ = 4;
        int val_ = 35;
        Node result_ = insertAtIndex(head_, val_, k_);
        CreateLinkedList.printLL(result_);
    }
}
