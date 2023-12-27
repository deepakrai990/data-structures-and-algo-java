package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms.model.Item;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 28/11/23
 * @project scaler_course_code
 */
public class Q2_Super_Market {
    /**
     * Question: In Super Market
     * If needed, we can pick a single Kg from each item. We can eat 70 Kgs in total.
     * What is the max protein we can eat?
     * **/
    private static int maxProtein(Item[] items, int totalWeight) {
        Arrays.sort(items);

        int maxProtein = 0;
        int remainingWeight = totalWeight;

        for (Item item : items) {
            int weightToTake = Math.min(item.weight, remainingWeight);
            maxProtein += weightToTake * item.protein / item.weight;
            remainingWeight -= weightToTake;

            if (remainingWeight == 0) {
                break;
            }
        }

        return maxProtein;
    }
    // Need to work
    public static void main(String[] args) {
        Item[] items = {
                new Item("Tomato", 20, 200),
                new Item("Apples", 15, 80),
                new Item("Onion", 50, 250),
                new Item("Chicken", 10, 150),
                new Item("Potato", 25, 200),
                new Item("Mango", 12, 132),
                new Item("Fish", 5, 100)
        };
        int totalWeight = 70;
        int result = maxProtein(items, totalWeight);
        System.out.println("Maximum protein gained: " + result + "p");
    }
}
