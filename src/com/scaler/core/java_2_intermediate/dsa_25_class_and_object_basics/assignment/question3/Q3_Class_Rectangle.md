### Q3. Class Rectangle
#### Problem Description
```text
Construct a class Rectangle that represents a rectangle.

The class should support the following functionalities:-
perimeter() -> returns the perimeter of the rectangle
area() -> returns the area of the rectangle

You may define any properties in the class as you see appropriate.
```

* Complete Solution
* * Solution in Java
```java
class Rectangle {
    // Define properties here
    int l,b;

    // Define constructor here
    Rectangle(int x,int y) {
		this.l = x;
		this.b = y;
	}

    int perimeter(){
		// Complete the function
		return 2 * (this.l + this.b);
	}
	
	int area(){
		// Complete the function
		return (this.l * this.b);
	}
}
```
* * Solution in Javascript
```javascript
class Rectangle { 
	
	// Define constructor here
	constructor(x, y){
	    this.l = x;
	    this.b = y;
	}	
		
	perimeter(){
		// Complete the function
		return 2 * (this.l + this.b);
	}
	
	area(){
		// Complete the function
		return (this.l * this.b);
	}
	
}

/*
    let a = new Rectangle(2, 3)  // Length = 2, Breadth = 3
	a.perimeter() // Should give 10
    a.area() // Should give 6

*/
```
* * Solution in C++
```cpp
class Rectangle {
	public :
	    // Define properties here
		int l,b;
		
		// Define constructor here
		Rectangle(int x,int y) {
			this->l = x;
			this->b = y;
		}
		
		int perimeter(){
			// Complete the function
			return 2 * (this->l + this->b);
		}
		
		int area(){
			// Complete the function
			return (this-> l * this->b);
		}
};
```