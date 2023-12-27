package com.scaler.core.java_3_advance_3.dsa_25_linked_list_2;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 14/10/23
 * @project scaler_course_code
 */
public class Q6_Find_Intersection {
    private static Node findIntersection(Node headA, Node headB) {
        if (headA == null || headB == null) return null; // No intersection if either list is empty
        // Find the lengths of both linked lists
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        // Reset the pointers to the beginning of the lists
        Node a = headA;
        Node b = headB;
        // Move the pointer of the longer list to match the length of the shorter list
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                a = a.next;
            }
        } else if (lengthB > lengthA) {
            for (int i = 0; i < lengthB - lengthA; i++) {
                b = b.next;
            }
        }
        // Traverse both lists together until they meet at the intersection
        while (a != null && b != null) {
            if (a == b) return a; // Intersection point found
            a = a.next;
            b = b.next;
        }
        return null; // No intersection found
    }

    private static int getLength(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void main(String[] args) {
        // Create two linked lists
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        Node headA = node1;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node headB = node3;

        CreateLinkedList.printLL(headA);
        System.out.println();
        CreateLinkedList.printLL(headB);
        System.out.println();
        // Find the intersection
        Node intersection = findIntersection(headA, headB);
        if (intersection != null) {
            System.out.println("Intersection found at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
