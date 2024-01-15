package com.scaler.core.java_2_intermediate.dsa_21_hashing_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q2_Number_of_states_in_each_country {
    /**
     * Problem: Store number of states in each country in HashMap
     * **/
    // Helper method to add country, state, and state count to the HashMap
    private static void addCountryStateCount(Map<String, Map<String, Integer>> countryStateCount,
                                             String country, String state, int count) {
        // Check if the country already exists in the outer HashMap
        if (!countryStateCount.containsKey(country)) {
            countryStateCount.put(country, new HashMap<>());
        }
        // Add the state and state count to the inner HashMap
        countryStateCount.get(country).put(state, count);
    }

    // Helper method to get the number of states for a specific country and state
    private static int getStateCount(Map<String, Map<String, Integer>> countryStateCount,
                                     String country, String state) {
        // Check if the country and state exist in the HashMap
        if (countryStateCount.containsKey(country) &&
                countryStateCount.get(country).containsKey(state)) {
            return countryStateCount.get(country).get(state);
        } else {
            // Return a default value or handle the case when data is not available
            return 0;
        }
    }
    public static void main(String[] args) {
        // Create a HashMap to store the number of states in each country
        Map<String, Map<String, Integer>> countryStateCount = new HashMap<>();
        // Add data to the HashMap
        addCountryStateCount(countryStateCount, "USA", "California", 58);
        addCountryStateCount(countryStateCount, "USA", "Texas", 254);
        addCountryStateCount(countryStateCount, "India", "Maharashtra", 36);
        addCountryStateCount(countryStateCount, "India", "Tamil Nadu", 38);
        // Add more countries, states, and state counts as needed
        // Retrieve and print the number of states for a specific country and state
        String countryToQuery = "USA";
        String stateToQuery = "California";
        int stateCount = getStateCount(countryStateCount, countryToQuery, stateToQuery);
        System.out.println("Number of states in " + countryToQuery + ", " + stateToQuery + ": " + stateCount);
        // Print all countries, states, and state counts
        System.out.println("All Countries, States, and State Counts:");
        for (Map.Entry<String, Map<String, Integer>> countryEntry : countryStateCount.entrySet()) {
            String country = countryEntry.getKey();
            Map<String, Integer> stateCountMap = countryEntry.getValue();

            for (Map.Entry<String, Integer> stateCountEntry : stateCountMap.entrySet()) {
                String state = stateCountEntry.getKey();
                int count = stateCountEntry.getValue();
                System.out.println(country + ", " + state + ": " + count);
            }
        }
    }
}
