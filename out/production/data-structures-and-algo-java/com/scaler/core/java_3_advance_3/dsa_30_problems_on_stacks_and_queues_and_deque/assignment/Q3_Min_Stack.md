### Q3. Min Stack
#### Problem Description
```text
Design a stack that supports push, pop, top, and retrieve the minimum element in 
constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
NOTE:
    All the operations have to be constant time operations.
    getMin() should return -1 if the stack is empty.
    pop() should return nothing if the stack is empty.
    top() should return -1 if the stack is empty.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= Number of Function calls &lt;= 10<sup>7</sup>
</div>

```text
1 <= Number of Function calls <= 10^7
```
#### Input Format
```text
Functions will be called by the checker code automatically.
```
#### Output Format
```text
Each function should return the values as defined by the problem statement.
```
#### Example Input
```text
Input 1:
 push(1)
 push(2)
 push(-2)
 getMin()
 pop()
 getMin()
 top()

Input 2:
 getMin()
 pop()
 top()
```
#### Example Output
```text
Output 1:
 -2 1 2

Output 2:
 -1 -1
```
#### Example Explanation
```text
Explanation 1:
    Let the initial stack be : []
    1) push(1) : [1]
    2) push(2) : [1, 2]
    3) push(-2) : [1, 2, -2]
    4) getMin() : Returns -2 as the minimum element in the stack is -2.
    5) pop() : Return -2 as -2 is the topmost element in the stack.
    6) getMin() : Returns 1 as the minimum element in stack is 1.
    7) top() : Return 2 as 2 is the topmost element in the stack.

Explanation 2:
    Let the initial stack be : []
    1) getMin() : Returns -1 as the stack is empty.
    2) pop() :  Returns nothing as the stack is empty.
    3) top() : Returns -1 as the stack is empty.
```
### Hints
* Hint 1
```text
Let us look at solution number 1.

What if you maintained two queues. One stores the actual stack of elements, and the 
other stores the minimum of elements.
So when pushing a new element,
min = min(top of minimum stack, current value), pushed to the minimum stack.

However, this uses 2N memory.

Can you think of minor optimizations to this?
```
* Solution Approach
```text
What if you maintained the current minimum in a variable and only stored the places 
where the minimum changes or the element is the same as the minimum.

pop() becomes a little trickier in such a case.
You only pop() from the min stack if the top() of the min stack is the same as the 
current minimum.

Space complexity: O(N + X) where X = number of places where minimum changes or the 
element is the same as the minimum.
```
* Complete Solution
* * Solution in Java
```java
class Solution {
  private Stack < Integer > stack;
  private Stack < Integer > minStack;

  public Solution() {
    stack = new Stack < > ();
    minStack = new Stack < > ();
  }

  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty())
      minStack.push(x);
    else if (x <= minStack.peek()) {
      minStack.push(x);
    }
  }

  public void pop() {
    if (stack.isEmpty())
      return;
    int num = stack.pop();
    if (num == minStack.peek())
      minStack.pop();
  }

  public int top() {
    if (stack.isEmpty())
      return -1;

    return stack.peek();
  }

  public int getMin() {
    if (minStack.isEmpty())
      return -1;

    return minStack.peek();
  }
}
```
* * Solution in Javascript
```javascript
function solve() {
  this.elements = [];
}
solve.prototype.push = function (x) {
  this.elements.push({
    value: x,
    min: this.elements.length === 0 ? x : Math.min(x, this.getMin()),
  });
};
solve.prototype.pop = function () {
  if (this.elements.length) return this.elements.pop();
  return;
};
solve.prototype.top = function () {
  if (this.elements.length == 0) return -1;
  return this.elements[this.elements.length - 1].value;
};
solve.prototype.getMin = function () {
  if (this.elements.length == 0) return -1;
  return this.elements[this.elements.length - 1].min;
};
module.exports = {
  solve: solve,
};
```
* * Solution in C++
```cpp
stack < int > elementStack;
stack < int > minimumStack;
int minElement = -1;
MinStack::MinStack() {
    while (elementStack.empty() == false)
        elementStack.pop();
    while (minimumStack.empty() == false)
        minimumStack.pop();
    minElement = -1;
}

void MinStack::push(int x) {
    elementStack.push(x);
    if (elementStack.size() == 1 || x <= minElement) {
        minimumStack.push(x);
        minElement = x;
    }
}

void MinStack::pop() {
    if (elementStack.empty()) return;
    if (elementStack.top() == minElement) {
        minimumStack.pop();
        if (!minimumStack.empty()) {
            minElement = minimumStack.top();
        } else {
            minElement = -1;
        }
    }
    elementStack.pop();
}

int MinStack::top() {
    if (elementStack.empty()) return -1;
    return elementStack.top();
}

int MinStack::getMin() {
    if (elementStack.empty()) return -1;
    return minElement;
}
```
