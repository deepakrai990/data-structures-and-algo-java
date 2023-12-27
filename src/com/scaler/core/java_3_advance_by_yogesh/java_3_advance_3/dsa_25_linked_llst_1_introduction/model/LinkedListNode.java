package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model;

/**
 * @created 25/02/23 1:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Question 1. Search a given K in a linkedList
     * Rule 1. neven move your head;
     * Rule 2. Always look for null pointer Exception
     * @param head
     * '@param head' pass head as ListNode
     * @param k
     * '@param k' pass an integer value to check it's present or not in ListNode
     * @return
     * return a boolean value
     */
    public boolean search(LinkedListNode head, int k) {
        LinkedListNode temp = head;
        while (temp != null) {
            if (temp.data == k) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void insertAtHead(int val) {
        LinkedListNode new_node = new LinkedListNode(val);
        new_node.next = next;
        next = new_node;
    }

    public void insertAtTail(int val) {
        LinkedListNode new_node = new LinkedListNode(val);
        if (next == null) {
            next = new LinkedListNode(val);
            return;
        }
        new_node.next = null;
        LinkedListNode last_node = next;
        while (last_node.next != null) {
            last_node = last_node.next;
        }
        last_node.next = new_node;
        return;
    }

    public void insertAfter(LinkedListNode prev_node, int val) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        LinkedListNode new_node = new LinkedListNode(val);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void insertAtPosition(int position, int val) {
        LinkedListNode new_node = new LinkedListNode(val);
        LinkedListNode temp_node = this;
        while (position < 1) {
            temp_node = temp_node.next;
            position--;
        }
        new_node.next = temp_node.next;
        temp_node.next = new_node;
    }
    public void deleteAtHead() {
        if (data != Integer.MIN_VALUE) {
            System.out.println("List is empty");
        } else {
            next = next.next;
        }
    }

    public void deleteAtTail() {
        if (this == null) {
            return;
        }
        if (this.next == null) {
            return;
        }
        LinkedListNode temp_node = this;
        while (temp_node.next.next != null) {
            temp_node = temp_node.next;
        }
        temp_node.next = null;
    }

    // Delete the first occurrence of given element
    public LinkedListNode deleteFirstOccurrence(int k) {
        if (this.data == k) return this.next;
        LinkedListNode temp_node = this;
        while (temp_node.next.data != k) {
            temp_node = temp_node.next;
        }
        temp_node.next = temp_node.next.next;
        return temp_node;
    }
    /**
     * Delete all occurrences of K
     * Homework
     * **/


}
