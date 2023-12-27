package com.scaler.core.java_2_intermediate.dsa_25_class_and_object_basics.assignment.question3;

/**
 * @created 21/02/23 1:34 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Rectangle {
    // Define properties here
    int length;
    int breadth;

    // Define constructor here
    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    int perimeter() {
        // Complete the function
        return 2 * (this.length + this.breadth);
    }

    int area() {
        // Complete the function
        return this.length * this.breadth;
    }
}
