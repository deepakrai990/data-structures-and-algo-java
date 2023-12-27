package com.scaler.core.java_3_advance_3.dsa_26_linked_list_3;

import java.util.HashMap;

/**
 * @author Deepak Kumar Rai
 * @created 18/10/23
 * @project scaler_course_code
 */
public class LRUCache<K, V> { // add to last
    private final int capacity;
    private final HashMap<K, Node> map;
    private final Node head;
    private final Node tail;

    class Node {
        K key;
        V value;
        Node prev;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToTail(node);
            return node.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node toRemove = map.get(key);
            map.remove(toRemove.key);
            remove(toRemove);
        } else if (map.size() >= capacity) {
            // Remove the least recently used node (head.next)
            Node toRemove = head.next;
            map.remove(toRemove.key);
            remove(toRemove);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToTail(newNode);
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToTail(Node node) {
        Node prevNode = tail.prev; // getting previous node [key = 5]
        prevNode.next = node; // node(5) -> node(3)
        node.prev = prevNode; // node(5)  <- node(3)
        node.next = tail; // node(3) -> node(null)
        tail.prev = node; // node(3) <- node(null)
    }

    private void moveToTail(Node node) {
        remove(node);
        addToTail(node);
    }
}
