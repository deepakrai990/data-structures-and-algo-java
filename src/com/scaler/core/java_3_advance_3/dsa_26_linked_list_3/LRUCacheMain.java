package com.scaler.core.java_3_advance_3.dsa_26_linked_list_3;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(5);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.put(4, "Four");
        cache.put(5, "Five");

        System.out.println("-----------------------------");

        System.out.println(cache.get(1)); // Output: One
        System.out.println(cache.get(2)); // Output: Two
        System.out.println(cache.get(3)); // Output: Two
        System.out.println(cache.get(4)); // Output: Two
        System.out.println(cache.get(5)); // Output: Two

        System.out.println("-----------------------------");

        cache.put(3, "Eight");

        System.out.println(cache.get(1)); // Output: One
        System.out.println(cache.get(2)); // Output: Two
        System.out.println(cache.get(3)); // Output: Two
        System.out.println(cache.get(4)); // Output: Two
        System.out.println(cache.get(5)); // Output: Two

        System.out.println("-----------------------------");
    }
}
