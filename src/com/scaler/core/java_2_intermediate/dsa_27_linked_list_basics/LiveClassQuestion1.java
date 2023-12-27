package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @created 18/10/22 10:19 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    public static Node insertAtStart(Node head, int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        return head;
    }

    private static Node insertAtEnd(Node head, int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
            return head;
        }
    }
    public static Node insertAtKthPosition(Node head, int val, int k) {
        if (k == 0) {
            head = insertAtStart(head, val);
            return head;
        } else {
            int count = 0;
            Node temp = new Node(val);
            Node current = head;
            while (count < k - 1) {
                current = current.next;
                count++;
            }
            temp.next = current.next;
            current.next = temp;
            head = current;
            return head;
        }
    }
    public static Node solve(Node A, int B, int C) {
        if (C == 0) {
            A = insertAtStart(A, B);
            return A;
        } else {
            int count = 0;
            Node temp = new Node(B);
            Node current = A;
            while (count < C - 1) {
                current = current.next;
                count++;
            }
            temp.next = current.next;
            current.next = temp;
            return current;
        }
    }

    public static void main(String[] args) {

    }
}
