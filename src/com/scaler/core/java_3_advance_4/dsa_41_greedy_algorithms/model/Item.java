package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms.model;

/**
 * @author Deepak Kumar Rai
 * @created 28/11/23
 * @project scaler_course_code
 */
public class Item implements Comparable<Item> {
    public String name;
    public int weight;
    public int protein;

    public Item(String name, int weight, int protein) {
        this.name = name;
        this.weight = weight;
        this.protein = protein;
    }

    @Override
    public int compareTo(Item other) {
        return Double.compare((double) other.protein / other.weight, (double) this.protein / this.weight);
    }
}
