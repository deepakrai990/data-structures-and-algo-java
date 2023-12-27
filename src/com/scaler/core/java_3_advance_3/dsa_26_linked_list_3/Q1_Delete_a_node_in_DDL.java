package com.scaler.core.java_3_advance_3.dsa_26_linked_list_3;

import com.scaler.core.java_3_advance_3.dsa_26_linked_list_3.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 20/10/23
 * @project scaler_course_code
 */
public class Q1_Delete_a_node_in_DDL {

    /**
     * Delete a node in Doubly LinkedList
     * Note 1: Node reference/address is given in Doubly LinkedList
     * Note 2: Given Node is not a head/tail node
     * <></>
     * <></>
     * Observation: To delete a node in Doubly LinkedList, the current node address is sufficient!
     * **/
    private static void deleteNode(Node deleteNode /* Can't be head or tail */) {
        deleteNode.prev.next = deleteNode.next;
        deleteNode.next.prev = deleteNode.prev;
        deleteNode.next = null; // isolating the node, deallocating the memory for language like C/C++, can skip for java
        deleteNode.prev = null;
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

        deleteNode(node3);
        printDLL(node1);

    }
    private static void printDLL(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
    }
}
