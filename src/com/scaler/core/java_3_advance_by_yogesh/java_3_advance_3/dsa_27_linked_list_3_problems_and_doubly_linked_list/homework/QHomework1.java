package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_27_linked_list_3_problems_and_doubly_linked_list.homework;

/**
 * @created 02/03/23 1:34 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    /*
    class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }
    */
    ListNode flatten(ListNode root) {
    //Solution idea:
    //1.Flattening the list
    //2.Sorting using merge Sort
        ListNode curr = root, head = root;
        while (curr != null) {
            ListNode temp = curr.down, next = curr.right;
            if (temp == null) {
                curr.down = curr.right;
                curr.right = null;
            }
            while (temp != null && temp.down != null) {
                temp = temp.down;
            }
            if (temp != null) {
                temp.down = curr.right;
                curr.right = null;
            }
            curr = next;
        }
        head = mergeSort(head);
        return head;
    }

    public ListNode mergeSort(ListNode A) {
        if (A == null || A.down == null)
            return A;
        ListNode h1 = A;
        ListNode midNode = findMidNode(A);
        ListNode h2 = midNode.down;
        midNode.down = null;
        h1 = mergeSort(h1);
        h2 = mergeSort(h2);
        return mergeList(h1, h2);
    }

    public ListNode findMidNode(ListNode A) {
        ListNode slow = A, fast = A;

        while (fast != null && fast.down != null) {
            fast = fast.down.down;
            if (fast != null)
                slow = slow.down;
        }
        return slow;
    }

    public ListNode mergeList(ListNode h1, ListNode h2) {
        ListNode head = null;

        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        if (h1.val < h2.val) {
            head = h1;
            h1 = h1.down;
        } else {
            head = h2;
            h2 = h2.down;
        }
        ListNode temp = head;
        while (h1 != null & h2 != null) {
            if (h1.val < h2.val) {
                temp.down = h1;
                h1 = h1.down;
            } else {
                temp.down = h2;
                h2 = h2.down;
            }
            temp = temp.down;
        }
        if (h1 == null)
            temp.down = h2;
        if (h2 == null)
            temp.down = h1;
        return head;
    }
    class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }
}
