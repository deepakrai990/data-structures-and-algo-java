package com.scaler.core.java_2_intermediate.dsa_21_hashing_1;

import java.util.HashMap;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q1_Population_of_every_country {
    /**
     * Problem: Store population of every country in HashMap
     * **/
    public static void main(String[] args) {
        // Create a HashMap to store country populations
        HashMap<String, Long> countryPopulations = new HashMap<>();
        // Add country populations to the HashMap
        countryPopulations.put("USA", 331002651L);  // Example: USA population
        countryPopulations.put("China", 1444216107L); // Example: China population
        countryPopulations.put("India", 1380004385L); // Example: India population
        // Add more countries as needed
        // Retrieve and print the population of a specific country
        String countryToQuery = "USA";
        if (countryPopulations.containsKey(countryToQuery)) {
            long population = countryPopulations.get(countryToQuery);
            System.out.println("Population of " + countryToQuery + ": " + population);
        } else {
            System.out.println("Population data not available for " + countryToQuery);
        }

        // Print all countries and their populations
        System.out.println("All Countries and their Populations:");
        for (String country : countryPopulations.keySet()) {
            long population = countryPopulations.get(country);
            System.out.println(country + ": " + population);
        }
    }
}
