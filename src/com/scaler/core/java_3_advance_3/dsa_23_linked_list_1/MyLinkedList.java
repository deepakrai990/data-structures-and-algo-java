package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1;

/**
 * @author Deepak Kumar Rai
 * @created 12/10/23
 * @project scaler_course_code
 */
public class MyLinkedList {
    Node head;

    // Static class of Node
    static class Node {
        int val;
        Node next;
    public Node (int val) {
            this.val = val;
            this.next = null;
        }
    }
    public MyLinkedList() {
        this.head = null;
    }
    // Insert a new node at the end of the linked list
    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) head = newNode;
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    // Display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
    }
    // Search for a specific value in the linked list
    public boolean search(int target) {
        Node current = head;
        while (current != null) {
            if (current.val == target) return true; // Value found
            current = current.next;
        }
        return false; // Value isn't found
    }
    // Delete a node with a specific value from the linked list
    public void delete(int target) {
        if (head == null) return;
        if (head.val == target) {
            head = head.next; // Remove the first node
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.val == target) {
                current.next = current.next.next; // Remove the node with the target value
                return;
            }
            current = current.next;
        }
    }
    // Get the length of the linked list
    public int length () {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
