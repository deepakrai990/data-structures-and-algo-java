package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees;

import com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.model.NodeCDLL;

/**
 * @author Deepak Kumar Rai
 * @created 21/11/23
 * @project scaler_course_code
 */
public class Q5_Given_two_CDLL_combine_them {
    private static NodeCDLL combine(NodeCDLL head1, NodeCDLL head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        NodeCDLL temp1 = head1.prev;
        NodeCDLL temp2 = head2.prev;
        temp1.next = head2;
        head2.prev = temp1;
        head1.prev = temp2;
        temp2.next = head1;
        return head1;
    }
    private static void printCDLL(NodeCDLL head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        NodeCDLL temp = head;
        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    public static void main(String[] args) {
        NodeCDLL head1 = createCDLLHead1();
        NodeCDLL head2 = createCDLLHead2();

        NodeCDLL results = combine(head1, head2);
        printCDLL(results);
    }

    private static NodeCDLL createCDLLHead1() {
        NodeCDLL head1 = insert(null,10);
        insert(head1, 6);
        insert(head1, 8);
        return head1;
    }

    private static NodeCDLL createCDLLHead2() {
        NodeCDLL head1 = insert(null,4);
        insert(head1,9);
        insert(head1,2);
        return head1;
    }
    private static NodeCDLL insert(NodeCDLL head, int data) {
        NodeCDLL newNode = new NodeCDLL(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            NodeCDLL last = head.prev;
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = last;
            last.next = newNode;
        }
        return head;
    }

}
