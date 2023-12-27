package com.scaler.core.java_3_advance_3.dsa_26_linked_list_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deepak Kumar Rai
 * @created 21/10/23
 * @project scaler_course_code
 */
class Node {
    int data;
    Node next;
    Node random;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}
public class Q4_Create_Clone_of_random_LinkedList {
    /**
     * Given a LinkedList, which also has a random pointer.
     * Create and return clone of it.
     * **/
    private static Node cloneLinkedList(Node head1) {
        if (head1 == null) return head1;
        // Step 1: Create clone node
        Node temp1 = head1.next;
        Node head2 = new Node(head1.data);
        Node temp2 = head2;
        while (temp1 != null) {
            Node newNode = new Node(temp1.data);
            temp2.next = newNode;
            temp2 = newNode;
            temp1 = temp1.next;
        }
        // Step 2: Create HashMap<Node, Node> and map a1 -> b1, a2 -> b2,...
        Map<Node, Node> map = prepareMap(head1, head2);
        // Step 3: Fill random values of all nodes in clone using Map
        Node clone = fillRandomNodes(map, head1, head2);
        return clone;
    }
    private static Node fillRandomNodes(Map<Node, Node> map, Node h1, Node h2) {
        Node temp1 = h1, temp2 = h2;
        while (temp1 != null) {
            temp2.random = map.get(temp1.random);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return h2;
    }
    private static Map<Node, Node> prepareMap(Node h1, Node h2) {
        Node temp1 = h1;
        Node temp2 = h2;
        Map<Node, Node> map = new HashMap<>();
        while (temp1 != null) {
            map.put(temp1, temp2);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return map;
    }
    private static Node cloneLinkedListWithRandom(Node head) {
        if (head == null) return null;
        // Step 1: Create a shallow copy of the original LinkedList without random pointers.
        Node original = head;
        Node clone = new Node(original.data);
        Node cloneHead = clone;
        // Step 2: Use a HashMap to store the mapping between nodes in the original and clone LinkedLists.
        HashMap<Node, Node> mapping = new HashMap<>();
        mapping.put(original, clone);
        // Step 3: Iterate through the original LinkedList to establish the mapping.
        while (original.next != null) {
            original = original.next;
            clone.next = new Node(original.data);
            clone = clone.next;
            mapping.put(original, clone);
        }
        // Step 4: Iterate through the original LinkedList to set the random pointers in the clone.
        original = head;
        clone = cloneHead;
        while (original != null) {
            if (original.random != null) {
                clone.random = mapping.get(original.random);
            }
            original = original.next;
            clone = clone.next;
        }
        return cloneHead;
    }
    // Optimization with O(1) space
    private static Node cloneLinkedList_1(Node head1) {
        Node temp1 = head1;
        while (temp1 != null) {
            Node newNode = new Node(temp1.data);
            newNode.next = temp1.next;
            temp1.next = newNode;
            temp1 = newNode.next;
        }
        temp1 = head1;
        Node head2 = head1.next;
        Node temp2 = head2;
        while (temp1 != null) {
            temp2.random = temp1.random.next;
            temp1 = temp2.next;
            if (temp1 == null) break;
            temp2 = temp1.next;
        }
        temp1 = head1;
        temp2 = head2;
        while (temp1 != null) {
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if (temp1 == null) break;
            temp2.next = temp1.next;
            temp2 = temp2.next;
        }
        return head2;
    }
    private static Node cloneLinkedListWithRandom_1(Node head) {
        if (head == null) return null;
        // Step 1: Duplicate each node and insert it after the original node.
        Node current = head;
        while (current != null) {
            Node clone = new Node(current.data);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }
        // Step 2: Set random pointers for the clone nodes.
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        // Step 3: Separate the original and clone LinkedLists.
        Node original = head;
        Node clone = head.next;
        Node cloneHead = head.next;
        while (original != null) {
            original.next = original.next.next;
            original = original.next;
            if (original != null) {
                clone.next = clone.next.next;
                clone = clone.next;
            }
        }
        return cloneHead;
    }
    public static void main(String[] args) {
        Node head = createRandomLinkedList();
        System.out.println("Original LinkedList: ");
        printRandomLinkedList(head);
        Node clone = cloneLinkedList(head);
        System.out.println("Clone LinkedList: ");
        printRandomLinkedList(clone);
        Node clone1 = cloneLinkedListWithRandom(head);
        System.out.println("Clone1 LinkedList: ");
        printRandomLinkedList(clone1);
        Node clone2 = cloneLinkedList_1(head);
        System.out.println("Clone2 LinkedList: ");
        printRandomLinkedList(clone2);
        Node clone3 = cloneLinkedListWithRandom_1(head);
        System.out.println("Clone3 LinkedList: ");
        printRandomLinkedList(clone3);
    }

    private static Node createRandomLinkedList() {
        Node node1 = new Node(8);
        Node node2 = new Node(9);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(4);

        node1.next = node2;
        node1.random = node5;

        node2.next = node3;
        node2.random = node2;

        node3.next = node4;
        node3.random = node1;

        node4.next = node5;
        node4.random = node3;
        node5.random = node3;

        return node1;
    }

    private static void printRandomLinkedList(Node head) {
        while (head != null) {
            System.out.print("[ Node(" + head.data+ "), random Node(" + head.random.data + ")]");
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
