package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.model;

/**
 * @author Deepak Kumar Rai
 * @created 21/11/23
 * @project scaler_course_code
 */
public class NodeCDLL {
    // Circular Doubly Linked List
    public int val;
    public NodeCDLL next;
    public NodeCDLL prev;

    public NodeCDLL(int x) {
        val = x;
        next = prev = null;
    }

}
