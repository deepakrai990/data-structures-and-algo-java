package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class MyLinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        list.display(); // Display the list: 1 -> 2 -> 3 -> 4 -> null
        System.out.println("Length of the list: " + list.length()); // Length of the list: 4
        int target = 3;
        if (list.search(target)) {
            System.out.println("Value " + target + " found in the list.");
        } else {
            System.out.println("Value " + target + " not found in the list.");
        }
        list.delete(2); // Delete the node with value 2

        list.display(); // Display the modified list: 1 -> 3 -> 4 -> null
    }
}
