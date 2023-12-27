package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_27_linked_list_3_problems_and_doubly_linked_list;

import java.util.HashMap; /**
 * @created 02/03/23 10:08 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    private class ListNode {
        public int key;
        public int val;
        public ListNode next, prev;
        ListNode(int x, int y) {
            key = x;
            val = y;
            next = null;
        }

    }
    static int capacity = 0;
    HashMap < Integer, ListNode > hm = new HashMap < > ();
    ListNode head = null, tail = null;

    // Constructor
    public LiveClassQuestion1(int capacity) {
        this.hm = new HashMap <> ();
        this.capacity = capacity;
        this.head=new ListNode(-1, -1);
        this.tail=new ListNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;

    }

    public int get(int key) {

        if (hm.containsKey(key)) {

            ListNode node = hm.get(key);
            delete(node.key);
            insert(node.key, node.val);
            return node.val;

        } else {
            return -1;
        }

    }

    public void delete(int key) {

        ListNode curr = hm.get(key);
        ListNode prv = curr.prev;
        ListNode nxt = curr.next;
        prv.next = nxt;
        nxt.prev = prv;
        hm.remove(key);

    }

    public void insert(int key, int value) {

        ListNode node = new ListNode(key, value);
        hm.put(key, node);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev=node;

    }

    public void set(int key, int value) {

        if (hm.containsKey(key)) {
            delete(key);
            insert(key, value);
        } else {
            if (hm.size() == capacity) {
                delete(head.next.key);
                insert(key, value);
            } else {
                insert(key, value);
            }
        }

    }
}
