package com.scaler.core.java_3_advance_3.dsa_26_linked_list_3;

import com.scaler.core.java_3_advance_3.dsa_26_linked_list_3.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 21/10/23
 * @project scaler_course_code
 */
public class Q2_Insert_a_new_node_just_before_tail_node_in_DDL {
    /**
     * Insert a new node just before tail node of a Doubly LinkedList.
     * **/
    private static void insertJustBeforeTail(Node newNode, Node tail) {
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }
    public static void main(String[] args) {
        Node node1 = new Node(11);
        Node node2 = new Node(12);
        Node node3 = new Node(13);
        Node node4 = new Node(14);
        Node node5 = new Node(15);

        node1.next = node2;
        node2.prev = node1;

        node2.next = node3;
        node3.prev = node2;

        node3.next = node4;
        node4.prev = node3;

        node4.next = node5;
        node5.prev = node4;

        Node node6 = new Node(20);

        insertJustBeforeTail(node6, node5);
        printDLL(node1);
    }
    private static void printDLL(Node head) {
        while (head != null) {
            System.out.print(head);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }
}
