### Q4. Sort stack using another stack
#### Problem Description
```text
Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A| &lt;= 5000</p>
    <p>0 &lt;= A[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= |A| <= 5000

0 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument is a stack given as an integer array A.
```
#### Output Format
```text
Return the array of integers after sorting the stack using another stack.
```
#### Example Input
```text
Input 1:
 A = [5, 4, 3, 2, 1]

Input 2:
 A = [5, 17, 100, 11]
```
#### Example Output
```text
Output 1:
 [1, 2, 3, 4, 5]

Output 2:
 [5, 11, 17, 100]
```
#### Example Explanation
```text
Explanation 1:
    Just sort the given numbers.

Explanation 2:
    Just sort the given numbers.
```
### Hints
* Hint 1
```text
Looking at the constraints, it seems like O(N^2) will pass.
Can you think of an algo now??
```
* Solution Approach
```text
1. Create a temporary stack say B.

2. While input stack is not empty:

    1. pop an element from input stack calls it x.
    
    2. while the temporary stack is not empty and top of the 
       temporary stack is greater than x pop from the temporary stack 
       and push it into input stack.
    
    3. push x in the temporary stack.

3. The sorted numbers are in the temporary stack.

Worst case time complexity O(n^2).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A) {

        if (A.length <= 1) return A;

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> helper = new Stack<Integer>();
        for (int i = 0; i < A.length; i++) {
            s1.push(A[i]);
        }

        while (!s1.empty()) {
            int temp = s1.peek();
            s1.pop();
            // keep popping from helper till its peek value is more than temp
            while (!helper.empty() && helper.peek() > temp) {
                s1.push(helper.peek());
                helper.pop();
            }
            helper.push(temp);
        }
        while (!helper.empty()) {
            s1.push(helper.peek());
            helper.pop();
        }

        int ans[] = new int[A.length], i = 0;
        while (!s1.empty()) {
            ans[i] = s1.peek();
            ;
            s1.pop();
            i++;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
class Stack {
  constructor() {
    this.items = [];
  }
  push(element) {
    this.items.push(element);
  }
  pop() {
    if (this.items.length == 0) return "Underflow";
    return this.items.pop();
  }
  top() {
    return this.items[this.items.length - 1];
  }
  empty() {
    return this.items.length == 0;
  }
  printStack() {
    var str = "";
    for (var i = 0; i < this.items.length; i++) str += this.items[i] + " ";
    return str;
  }
  clear() {
    this.items = [];
  }
}

module.exports = {
  solve: function (A) {
    if (A.length <= 1) return A;
    let s1 = new Stack(),
      helper = new Stack();
    for (let i = 0; i < A.length; i++) {
      s1.push(A[i]);
    }
    while (!s1.empty()) {
      let temp = s1.top();
      s1.pop();
      // keep popping from helper till its top value is more than temp
      while (!helper.empty() && helper.top() > temp) {
        s1.push(helper.top());
        helper.pop();
      }
      helper.push(temp);
    }
    while (!helper.empty()) {
      s1.push(helper.top());
      helper.pop();
    }
    let arr = [];
    while (!s1.empty()) {
      arr.push(s1.top());
      s1.pop();
    }
    return arr;
  },
};
```
* * Solution in C++
```cpp
vector < int > Solution::solve(vector < int > & A) {
    if (A.size() <= 1) return A;
    stack < int > s1, helper;
    for (int i = 0; i < A.size(); i++) {
        s1.push(A[i]);
    }
    while (!s1.empty()) {
        int temp = s1.top();
        s1.pop();
        // keep popping from helper till its top value is more than temp
        while (!helper.empty() && helper.top() > temp) {
            s1.push(helper.top());
            helper.pop();
        }
        helper.push(temp);
    }
    while (!helper.empty()) {
        s1.push(helper.top());
        helper.pop();
    }
    vector < int > arr;
    while (!s1.empty()) {
        arr.push_back(s1.top());
        s1.pop();
    }
    return arr;
}
```

