### Q3. Evaluate Expression
#### Problem Description
```text
An arithmetic expression is given by a string array A of size N. 
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= N <= 10^5
```
#### Input Format
```text
The only argument given is string array A.
```
#### Output Format
```text
Return the value of arithmetic expression formed 
using reverse Polish Notation.
```
#### Example Input
```text
Input 1:
 A =   ["2", "1", "+", "3", "*"]

Input 2:
 A = ["4", "13", "5", "/", "+"]
```
#### Example Output
```text
Output 1:
 9

Output 2:
 6
```
#### Example Explanation
```text
Explanation 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9

Explanation 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
```
### Hints
* Hint 1
```text
Start processing from the start.
What happens when you encounter an operand?
How are elements affected?
Can you simulate it?
```
* Solution Approach
```text
This is pretty much a simulation problem.
Think using stack.

When you encounter an operator, that is when you need the 
top 2 numbers on the stack, perform the operation on them, 
and put them on the stack.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> values = new Stack<Integer>();
        int first;
        int second;
        for (String str : A) {
            // on encountering an operator, pop the top two elements from the stack, 
            // perform the operation and push that back into the stack
            if (equal(str, "+")) {
                second = values.pop();
                first = values.pop();
                values.push(first + second);
            } else if (equal(str, "*")) {
                second = values.pop();
                first = values.pop();
                values.push(first * second);
            } else if (equal(str, "/")) {
                second = values.pop();
                first = values.pop();
                values.push(first / second);
            } else if (equal(str, "-")) {
                second = values.pop();
                first = values.pop();
                values.push(first - second);
            } else {
                first = Integer.parseInt(str);
                values.push(first);
            }
        }
        return values.peek();
    }

    public boolean equal(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    evalRPN: function (A) {
        var stack = [];
        for (var i = 0; i < A.length; i++) {
            if (A[i] === "*" || A[i] === "+" || A[i] === "/" || A[i] === "-") {
                // pop the top two elements from the stack, perform the operation 
                // and push that back into the stack
                var num2 = "(" + stack.pop() + ")";
                var num1 = "(" + stack.pop() + ")";
                stack.push(eval(num1 + A[i] + num2));
            } else {
                stack.push(A[i]);
            }
        }
        return parseInt(stack[0]);
    },
};
```
* * Solution in C++
```cpp
int Solution::evalRPN(vector<string> &A) {
    stack < int > st;
    for (int i = 0; i < A.size(); ++i) {
        if (A[i] == "+" || A[i] == "-" || A[i] == "*" || A[i] == "/") {
            // pop the top two elements from the stack, perform the operation 
            // and push that back into the stack
            int v1 = st.top();
            st.pop();
            int v2 = st.top();
            st.pop();
            switch (A[i][0]) {
            case '+':
                st.push(v2 + v1);
                break;
            case '-':
                st.push(v2 - v1);
                break;
            case '*':
                st.push(v2 * v1);
                break;
            case '/':
                st.push(v2 / v1);
                break;
            }
        } else {
            st.push(atoi(A[i].c_str()));
        }
    }
    return st.top();
}
```

