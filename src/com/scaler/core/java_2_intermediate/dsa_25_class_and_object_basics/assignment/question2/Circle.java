package com.scaler.core.java_2_intermediate.dsa_25_class_and_object_basics.assignment.question2;

/**
 * @created 21/02/23 1:34 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Circle {
    // Define properties here
    float radius;
    float PI = 3.14f;

    // Define constructor here
    Circle(float radius) {
        this.radius = radius;
    }

    float perimeter() {
        // Complete the function
        return (float) 2 * PI * this.radius;
    }

    float area() {
        // Complete the function
        return PI * this.radius * this.radius;
    }
}
