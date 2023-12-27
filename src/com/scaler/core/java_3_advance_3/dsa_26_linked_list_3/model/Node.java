package com.scaler.core.java_3_advance_3.dsa_26_linked_list_3.model;

/**
 * @author Deepak Kumar Rai
 * @created 20/10/23
 * @project scaler_course_code
 */
public class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
