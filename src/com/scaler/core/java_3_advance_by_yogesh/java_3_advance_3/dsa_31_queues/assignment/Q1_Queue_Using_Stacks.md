### Q1. Queue Using Stacks
#### Problem Description
```text
Implement a First In First Out (FIFO) queue using stacks only.

The implemented queue should support all the functions of a 
normal queue (push, peek, pop, and empty).

Implement the UserQueue class:

    * void push(int X) : Pushes element X to the back of the queue.
    * int pop() : Removes the element from the front of the queue 
      and returns it.
    * int peek() : Returns the element at the front of the queue.
    * boolean empty() : Returns true if the queue is empty, false otherwise.

NOTES:

    * You must use only standard operations of a stack, which means 
      only push to top, peek/pop from top, size, and is empty 
      operations are valid.
    * Depending on your language, the stack may not be supported 
      natively. You may simulate a stack using a list or 
      deque (double-ended queue) as long as you use only 
      a stack's standard operations.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= <strong>X</strong> &lt;= 10<sup>9</sup></p>
    <p>At most 1000 calls will be made to <strong>push</strong>, 
    <strong>pop</strong>, <strong>peek</strong>, and 
    <strong>empty</strong> function.</p>
    <p>All the calls to pop and peek are valid. i.e. pop and peek 
    are called only when the queue is non-empty.</p>
</div>

```text
1 <= X <= 10^9

At most 1000 calls will be made to push, pop, peek, and empty function.

All the calls to pop and peek are valid. i.e. pop and peek are 
called only when the queue is non-empty.
```
#### Input Format
```text
/** Not available **/
```
#### Output Format
```text
/** Not available **/
```
#### Example Input
```text
Input 1:
 1) UserQueue()
 2) push(20)
 3) empty()
 4) peek()
 5) pop()
 6) empty()
 7) push(30)
 8) peek()
 9) push(40)
 10) peek()

Input 2:
 1) UserQueue()
 2) push(10)
 3) push(20)
 4) push(30)
 5) pop()
 6) pop()
```
#### Example Output
```text
Output 1:
 false
 20
 20
 true
 30
 30 

Output 2:
 10
 20
```
#### Example Explanation
```text
Explanation 1:
    Queue => 20
    Queue => -
    Queue => 30
    Queue => 30, 40 

Explanation 2:
    Queue => 10
    Queue => 10, 20
    Queue => 10, 20, 30
    Queue => 20, 30
    Queue => 30
```
### Hints
* Hint 1
```text
Try simulating the queue with the help of two stacks.
```
* Solution Approach
```text
In order to implement queue using stacks, we need to maintain 
two stacks s1 and s2.

Algorithm:

1) For push: 
The new element is always added to the top of stack s1 and it 
is kept as rear element 
of the queue.

2) For pop:
We have to remove element in front of the queue. This is the first 
inserted element in the stack s1 and it is positioned at the bottom 
of the stack because of stack's LIFO (last in - first out) policy. 
To remove the bottom element from s1, we have to pop all elements 
from s1 and to push them on to an additional stack s2, which helps 
us to store the elements of s1 in reversed order. This way the 
bottom element of s1 will be positioned on top of s2 and we can 
simply pop it from stack s2. Once s2 is empty, the algorithm transfer 
data from s1 to s2 again.

3) For empty:
Both stacks s1 and s2 contain all stack elements, so the algorithm 
checks s1 and s2 size to return if the queue is empty.

4) For peek:
The rear element is the bottom element of s1. We will do the same 
operations done in pop except for the operation of removing the element.
```
* Complete Solution
* * Solution in Java
```java
public static class UserQueue {
    static Stack<Integer> s;
    static Stack<Integer> s1;

    /** Initialize your data structure here. */
    UserQueue() {
        s = new Stack<>();
        s1 = new Stack<>();
    }

    /** Push element X to the back of queue. */
    static void push(int X) {
        s.push(X);
    }

    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        if (s1.isEmpty()) {
            while (!s.isEmpty()) {
                s1.push(s.pop());
            }
        }
        return s1.pop();
    }

    /** Get the front element of the queue. */
    static int peek() {
        if (s1.isEmpty()) {
            while (!s.isEmpty()) {
                s1.push(s.pop());
            }
        }
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    static boolean empty() {
        return s1.isEmpty() && s.isEmpty();
    }
}
```
* * Solution in Javascript
```javascript
class UserQueue {
    constructor() {
        this.s1 = [];
        this.s2 = [];
    }

    push(X) {
        this.s1.push(X);
    }

    pop() {
        if (this.s2.length === 0) {
            while (this.s1.length > 0) {
                const x = this.s1.pop();
                this.s2.push(x);
            }
        }

        const remEl = this.s2.pop();
        return remEl;
    }

    peek() {
        if (this.s2.length > 0) {
            return this.s2[this.s2.length - 1];
        }

        while (this.s1.length > 0) {
            const x = this.s1.pop();
            this.s2.push(x);
        }

        return this.s2[this.s2.length - 1];
    }

    empty() {
        return this.s1.length === 0 && this.s2.length === 0;
    }
}
```
* * Solution in C++
```cpp
class UserQueue{
    public:
   
    stack<int> s1, s2;
    
    /** Initialize your data structure here. */
    UserQueue() {
        while(s1.size())
            s1.pop();
        
        while(s2.size())
            s2.pop();
    }
    
    /** Push element X to the back of queue. */
    void push(int X) {
        s1.push(X);  
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        
        if (s2.empty()) {
            while (!s1.empty()){
                int x = s1.top();
                s1.pop();
                s2.push(x);
            }
        }
        
        int remEl = s2.top();
        s2.pop(); 
 
        return remEl; 
    }
    
    /** Get the front element of the queue. */
    int peek() {
        
        if (!s2.empty()) {
            return s2.top();
        }
        
        while (!s1.empty()){
            int x = s1.top();
            s1.pop();
            s2.push(x);
        }
        
        return s2.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return (s1.empty() && s2.empty());
    }

};
```

