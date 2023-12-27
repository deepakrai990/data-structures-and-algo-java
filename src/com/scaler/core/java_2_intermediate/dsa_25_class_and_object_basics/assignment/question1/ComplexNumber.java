package com.scaler.core.java_2_intermediate.dsa_25_class_and_object_basics.assignment.question1;

/**
 * @created 21/02/23 1:34 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class ComplexNumber {
    float real, imaginary;

    // Define constructor here
    ComplexNumber(float real, float imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    ComplexNumber add(ComplexNumber x) {
        // Complete the function
        return new ComplexNumber(this.real + x.real, this.imaginary + x.imaginary);

    }

    ComplexNumber subtract(ComplexNumber x) {
        // Complete the function
        return new ComplexNumber(this.real - x.real, this.imaginary - x.imaginary);
    }

    ComplexNumber multiply(ComplexNumber x) {
        // Complete the function
        float r = x.real * this.real - x.imaginary * this.imaginary;
        float i = this.imaginary * x.real + this.real * x.imaginary;
        return new ComplexNumber(r, i);
    }

    ComplexNumber divide(ComplexNumber x) {
        // Complete the function
        float r = (this.real * x.real + this.imaginary * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
        float i = (this.imaginary * x.real - this.real * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
        return new ComplexNumber(r, i);
    }
}
