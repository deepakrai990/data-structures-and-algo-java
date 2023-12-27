### Q1. Class Complex Number
#### Problem Description
```text
Construct a class called ComplexNumber which stores two properties

real - The real part
imaginary - The imaginary part

The name of the properties should be strictly real and imaginary


Implement the following functionalities inside this class :-

add(ComplexNumber) -> Returns an object of ComplexNumber 
                      having sum of the two complex numbers.

subtract(ComplexNumber) -> Returns an object of ComplexNumber 
                           having difference of the two complex numbers.

multiply(ComplexNumber) -> Returns an object of ComplexNumber 
                           having multiplication of the two complex numbers.

divide(ComplexNumber) -> Returns an object of ComplexNumber 
                         having division of the two complex numbers.
```

* Complete Solution
* * Solution in Java
```java
class ComplexNumber {
    // Define properties here
	float real, imaginary;
	
	// Define constructor here
	ComplexNumber(float x, float y){
		this.real = x;
		this.imaginary = y;
	}
	
	ComplexNumber add(ComplexNumber x){
		// Complete the function
		return new ComplexNumber(this.real + x.real , this.imaginary + x.imaginary);
	}
	
	ComplexNumber subtract(ComplexNumber x){
		// Complete the function
		return new ComplexNumber(this.real - x.real , this.imaginary - x.imaginary);
	}
	
	ComplexNumber multiply(ComplexNumber x){
		// Complete the function
		float r =  x.real * this.real - x.imaginary * this.imaginary;
		float i = this.imaginary * x.real + this.real * x.imaginary;
		return new ComplexNumber(r, i);
	}
	
	ComplexNumber divide(ComplexNumber x){
		// Complete the function
		float r = (this.real * x.real + this.imaginary * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
		float i = (this.imaginary * x.real - this.real * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
		return new ComplexNumber(r, i);
	}
}
```
* * Solution in Javascript
```javascript
class ComplexNumber { 
    
	// Define constructor here
	constructor(x, y){
	    this.real = x;
		this.imaginary = y;
	}
		
	add(x){
		// Complete the function
		return new ComplexNumber(this.real + x.real , this.imaginary + x.imaginary);
	}
		
	subtract(x){
		// Complete the function
		return new ComplexNumber(this.real - x.real , this.imaginary - x.imaginary);
	}
		
	multiply(x){
		// Complete the function
		let r =  x.real * this.real - x.imaginary * this.imaginary;
		let i = this.imaginary * x.real + this.real * x.imaginary;
		return new ComplexNumber(r, i);
	}
	
	divide(x){
		// Complete the function
		let r = (this.real * x.real + this.imaginary * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
		let i = (this.imaginary * x.real - this.real * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
		return new ComplexNumber(r, i);
	}
	
}

/*
    let a = new ComplexNumber(10, 5)
	let b = new ComplexNumber(2, 3)
	let c1 = a.add(b) 
	let c2 = a.subtract(b)
	let c3 = a.multiply(b)
	let c4 = a.divide(b)

*/
```
* * Solution in C++
```cpp
class ComplexNumber {
	public :
	    // Define properties here
		float real, imaginary;
		
		// Define constructor here
		ComplexNumber(float x, float y){
			this->real = x;
			this->imaginary = y;
		}
		
		ComplexNumber add(ComplexNumber x){
			// Complete the function
			return ComplexNumber(this->real + x.real , this->imaginary + x.imaginary);
		}
		
		ComplexNumber subtract(ComplexNumber x){
			// Complete the function
			return ComplexNumber(this->real - x.real , this->imaginary - x.imaginary);
		}
		
		ComplexNumber multiply(ComplexNumber x){
			// Complete the function
			float r =  x.real * this->real - x.imaginary * this->imaginary;
			float i = this->imaginary * x.real + this->real * x.imaginary;
			return ComplexNumber(r, i);
		}
		
		ComplexNumber divide(ComplexNumber x){
			// Complete the function
			float r = (this->real * x.real + this->imaginary * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
			float i = (this->imaginary * x.real - this->real * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
			return ComplexNumber(r, i);
		}
};
```

