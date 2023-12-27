### Q2. Class Fraction
#### Problem Description
```text
Construct a class Fraction which stores a fraction. 
It should contain the

-Numerator
-Denominator

Assume denominator will never be 0.

The class should support the following functionalities

add(Fraction) -> Returns the sum of two fractions

subtract(Fraction) -> Returns the difference of two fractions

multiply(Fraction) -> Returns the product of two fractions

The fraction returned needs to be in the simplest form. If 
the fraction is p/q then p and q must be co-prime.

You may define any properties in the class as you see appropriate.
```

* Complete Solution
* * Solution in Java
```java
class Fraction {
    int numerator, denominator;

    // Define constructor here
    Fraction(int u, int v) {
        this.numerator = u;
        this.denominator = v;
    }

    Fraction add(Fraction a) {
        // Complete the function
        int denom = this.denominator * a.denominator;
        int num = this.denominator * a.numerator + this.numerator * a.denominator;
        int temp = gcd(Math.abs(num), Math.abs(denom));
        num /= temp;
        denom /= temp;
        return new Fraction(num, denom);
    }

    Fraction subtract(Fraction a) {
        // Complete the function
        int denom = this.denominator * a.denominator;
        int num = this.numerator * a.denominator - this.denominator * a.numerator;
        int temp = gcd(Math.abs(num), Math.abs(denom));
        num /= temp;
        denom /= temp;
        return new Fraction(num, denom);
    }

    Fraction multiply(Fraction a) {
        // Complete the function
        int denom = this.denominator * a.denominator;
        int num = this.numerator * a.numerator;
        int temp = gcd(Math.abs(num), Math.abs(denom));
        num /= temp;
        denom /= temp;
        return new Fraction(num, denom);
    }
    
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

```
* * Solution in Javascript
```javascript
class Fraction {
    gcd(a, b) {
        if (b == 0) {
            return a;
        }
        return this.gcd(b, a % b);
    }

    // Define constructor here
    constructor(u, v) {
        this.numerator = u;
        this.denominator = v;
    }

    add(a) {
        // Complete the function
        let denom = this.denominator * a.denominator;
        let num = this.denominator * a.numerator + this.numerator * a.denominator;
        let temp = this.gcd(Math.abs(num), Math.abs(denom));
        num /= temp;
        denom /= temp;
        return new Fraction(num, denom);
    }

    subtract(a) {
        // Complete the function
        let denom = this.denominator * a.denominator;
        let num = this.numerator * a.denominator - this.denominator * a.numerator;
        let temp = this.gcd(Math.abs(num), Math.abs(denom));
        num /= temp;
        denom /= temp;
        return new Fraction(num, denom);
    }

    multiply(a) {
        // Complete the function
        let denom = this.denominator * a.denominator;
        let num = this.numerator * a.numerator;
        let temp = this.gcd(Math.abs(num), Math.abs(denom));
        num /= temp;
        denom /= temp;
        return new Fraction(num, denom);
    }
};

/*
    let x = new Fraction(2, 3)  // 2/3
	let y = new Fraction(4, 5) // 4/5
    let z = x.add(y) // 22/15
    let z = x.subtract(y) // -2/15
    let z = x.multiply(y) // 8/15
*/
```
* * Solution in C++
```cpp
class Fraction {
	public :
	    int numerator, denominator;
		
		// Define constructor here
		Fraction(int u, int v){
			this -> numerator = u;
			this -> denominator = v;
		}
		
		Fraction add(Fraction a){
			// Complete the function
			int denom = this->denominator * a.denominator;
			int num = this->denominator * a.numerator + this->numerator * a.denominator;
			int temp = __gcd(abs(num) , abs(denom));
			num /= temp;
			denom /= temp;
			return Fraction(num, denom);
		}
		
		Fraction subtract(Fraction a){
			// Complete the function
			int denom = this->denominator * a.denominator;
			int num = this->numerator * a.denominator - this->denominator * a.numerator;
			int temp = __gcd(abs(num) , abs(denom));
			num /= temp;
			denom /= temp;
			return Fraction(num, denom);
		}
		
		Fraction multiply(Fraction a){
			// Complete the function
			int denom = this->denominator * a.denominator;
			int num = this->numerator * a.numerator;
			int temp = __gcd(abs(num) , abs(denom));
			num /= temp;
			denom /= temp;
			return Fraction(num, denom);
		}
};
```