### Q2. Class Circle
#### Problem Description
```text
Construct a class Circle that represents a Circle.


The class should support the following functionalities:-
perimeter() -> returns the perimeter of the circle
area() -> returns the area of the circle


Assume Π (pi) = 3.14 for calculations.
You may define any properties in the class as you see appropriate.
```

* Complete Solution
* * Solution in Java
```java
class Circle {
    // Define properties here
    int radius;
	
    // Define constructor here
    Circle(int x) {
        this.radius = x;
    }

    float perimeter() {
        // Complete the function
        return (float) (2 * 3.14 * this.radius);
    }

    float area() {
        // Complete the function
        return (float) (3.14 * this.radius * this.radius);
    }
}
```
* * Solution in Javascript
```javascript
class Circle {
    // Define constructor here
    constructor(x) {
        this.radius = x;
    }

    perimeter() {
        // Complete the function
        return 2 * 3.14 * this.radius;
    }

    area() {
        // Complete the function
        return 3.14 * this.radius * this.radius;
    }
}
```
* * Solution in C++
```cpp
class Circle {
	public :
	    // Define properties here
		int radius;
		
		// Define constructor here
		Circle(int x){
		    this->radius = x;
		}
		
		float perimeter(){
			// Complete the function
			return 2 * 3.14 * this->radius;
		}
		
		float area(){
			// Complete the function
			return 3.14 * this->radius * this->radius;
		}
};
```

