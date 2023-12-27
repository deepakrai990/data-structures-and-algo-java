package com.scaler.core.java_2_intermediate.dsa_25_class_and_object_basics.homework.qhomework2;

/**
 * @created 21/02/23 1:31 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Fraction {
    int numerator, denominator;

    // Define constructor here
    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    Fraction() {}

    Fraction add(Fraction a) {
        // Complete the function
        // check preconditions
        if ((this.denominator == 0) || (a.denominator == 0))
            throw new IllegalArgumentException("invalid denominator");
        // find lowest common denominator
        int common = this.lcd(this.denominator, a.denominator);
        // convert fractions to lcd
        Fraction commonA = new Fraction();
        Fraction commonB = new Fraction();
        commonA = this.convert(common);
        commonB = a.convert(common);
        // create new fraction to return as sum
        Fraction sum = new Fraction();
        // calculate sum
        sum.numerator = commonA.numerator + commonB.numerator;
        sum.denominator = common;
        // reduce the resulting fraction
        sum = sum.reduce();
        return sum;


    }

    Fraction subtract(Fraction a){
        // Complete the function
        // check preconditions
        if ((this.denominator == 0) || (a.denominator == 0))
            throw new IllegalArgumentException("invalid denominator");
        // find lowest common denominator
        int common = lcd(this.denominator, a.denominator);
        // convert fractions to lcd
        Fraction commonA = new Fraction();
        Fraction commonB = new Fraction();
        commonA = convert(common);
        commonB = a.convert(common);
        // create new fraction to return as difference
        Fraction diff = new Fraction();
        // calculate difference
        diff.numerator = commonA.numerator - commonB.numerator;
        diff.denominator = common;
        // reduce the resulting fraction
        diff = diff.reduce();
        return diff;
    }

    Fraction multiply(Fraction a){
        // Complete the function
        // check preconditions
        if ((this.denominator == 0) || (a.denominator == 0))
            throw new IllegalArgumentException("invalid denominator");
        // create new fraction to return as product
        Fraction product = new Fraction();
        // calculate product
        product.numerator = this.numerator * a.numerator;
        product.denominator = this.denominator * a.denominator;
        // reduce the resulting fraction
        product = product.reduce();
        return product;
    }

    private int lcd(int denom1, int denom2) {
        int factor = denom1;
        while ((denom1 % denom2) != 0)
            denom1 += factor;
        return denom1;
    }
    private int gcd(int denom1, int denom2) {
        int factor = denom2;
        while (denom2 != 0) {
            factor = denom2;
            denom2 = denom1 % denom2;
            denom1 = factor;
        }
        return denom1;
    }
    private Fraction convert(int common) {
        Fraction result = new Fraction();
        int factor = common / this.denominator;
        result.numerator = this.numerator * factor;
        result.denominator = common;
        return result;
    }
    private Fraction reduce() {
        Fraction result = new Fraction();
        int common = 0;
        // get absolute values for numerator and denominator
        int num = Math.abs(this.numerator);
        int den = Math.abs(this.denominator);
        // figure out which is less, numerator or denominator
        if (num > den)
            common = gcd(num, den);
        else if (num < den)
            common = gcd(den, num);
        else  // if both are the same, don't need to call gcd
            common = num;

        // set result based on common factor derived from gcd
        result.numerator = this.numerator / common;
        result.denominator = this.denominator / common;
        return result;
    }
}
