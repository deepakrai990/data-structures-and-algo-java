### Q2. Redundant Braces
#### Problem Description
```text
Given a string A denoting an expression. It contains the 
following operators '+', '-', '*', '/'.

Check whether A has redundant braces or not.

NOTE: A will be always a valid expression and will not contain 
any white spaces.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A| &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= |A| <= 10^5
```
#### Input Format
```text
The only argument given is string A.
```
#### Output Format
```text
Return 1 if A has redundant braces else, return 0.
```
#### Example Input
```text
Input 1:
 A = "((a+b))"

Input 2:
 A = "(a+(a+b))"
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    ((a+b)) has redundant braces so answer will be 1.

Explanation 2:
    (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
```
### Hints
* Hint 1
```text
Can you maintain a stack for removing a sub-expression?
```
* Solution Approach
```text
If we somehow pick out sub-expressions surrounded by ( and ), 
then if we are left with () as a part of the string, we know 
we have redundant braces.

Let us take an example:

(a+(a+b))

We keep pushing elements onto the stack till we encounter ')'. 

When we encounter ')', we start popping elements until we 
find a matching '('. 

If the number of elements popped does not correspond 
to '()', we are fine, and we can move forward. 

Otherwise, voila! Matching braces have been found. 

Some Extra Hints:

Try to run your code on test cases like (a*(a))  and (a) ??

Happy Coding
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    
    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    public int braces(String A) {
        char s[] = A.toCharArray();
        int n = s.length;
        Stack <Character> st = new Stack<>();
        for(char c : s) {
            if(c == '(') {
                st.push(c);
            } else if(c == ')') {
                // finds the no of characters between adjacent '(' and ')' pair
                char top = st.peek();
                if( !isOperator(top) )    return 1;
                while ( isOperator(st.peek()) )   st.pop();
                if(st.peek() != '(')    return 1;
                st.pop();
            } else if(isOperator(c)) {
                st.push(c);
            }
        }
        while ( !st.isEmpty() && isOperator(st.peek()) )   
            st.pop();
        return st.isEmpty() ? 0 : 1;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    braces: function (A) {
        let N = A.length;
        let Stk = [];
        for (let i = 0; i < N; ++i) {
            if (A[i] == ")") {
                // finds the no of characters between adjacent '(' and ')' pair
                cnt = 0;
                while (Stk.length && Stk[Stk.length - 1] != "(") {
                    Stk.pop();
                    cnt++;
                }
                if (Stk.length) Stk.pop();
                if (cnt < 2) return 1;
            } else {
                Stk.push(A[i]);
            }
        }
    
        let is = true;
        while (Stk.length) {
            if (Stk[Stk.length - 1] == "(" || Stk[Stk.length - 1] == ")") {
                is = false;
                break;
            }
            Stk.pop();
        }
    
        if (!is) return 1;
        return 0;
    },
};
```
* * Solution in C++
```cpp
int Solution::braces(string A) {
    int N = A.size();
    stack < char > Stk;
    for (int i = 0; i < N; ++i) {
        if (A[i] == ')') {
            int cnt = 0;
            // finds the no of characters between adjacent '(' and ')' pair
            while (Stk.empty() == false && Stk.top() != '(') {
                Stk.pop();
                cnt++;
            }
            if (Stk.empty() == false)
                Stk.pop();
            if (cnt < 2)
                return 1;
        } else {
            Stk.push(A[i]);
        }
    }

    bool is = true;
    while (Stk.empty() == false) {
        if (Stk.top() == '(' || Stk.top() == ')') {
            is = false;
            break;
        }
        Stk.pop();
    }

    if (!is)
        return 1;
    return 0;
}
```

