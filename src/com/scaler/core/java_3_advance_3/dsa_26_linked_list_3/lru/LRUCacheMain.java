package com.scaler.core.java_3_advance_3.dsa_26_linked_list_3.lru;

/**
 * @author Deepak Kumar Rai
 * @created 19/10/23
 * @project scaler_course_code
 */
public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.put(1, "One");
        cache.put(2, "Two");

        System.out.println(cache.get(1)); // Output: One
        System.out.println(cache.get(2)); // Output: Two

        cache.put(3, "Three");

        System.out.println(cache.get(1)); // Output: null (not found)
        System.out.println(cache.get(2)); // Output: Two
        System.out.println(cache.get(3)); // Output: Three
    }
}
