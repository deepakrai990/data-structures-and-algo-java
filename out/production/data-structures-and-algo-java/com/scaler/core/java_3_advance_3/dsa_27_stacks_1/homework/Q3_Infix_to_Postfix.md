### Q3. Infix to Postfix
#### Problem Description
```text
Given string A denoting an infix expression. Convert 
the infix expression into a postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase 
English alphabets where lowercase English alphabets are 
operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:

    ^ has the highest precedence.
    / and * have equal precedence but greater than + and -.
    + and - have equal precedence and lowest precedence 
      among given operators.
```
#### Problem Constraints
```text
1 <= length of the string <= 500000
```
#### Input Format
```text
The only argument given is string A.
```
#### Output Format
```text
Return a string denoting the postfix conversion of A.
```
#### Example Input
```text
Input 1:
 A = "x^y/(a*z)+b"

Input 2:
 A = "a+b*(c^d-e)^(f+g*h)-i"
```
#### Example Output
```text
Output 1:
 "xy^az*/b+"

Output 2:
 "abcd^e-fgh*+^*+i-"
```
#### Example Explanation
```text
Explanation 1:
    Output denotes the postfix expression of the given input.
```
### Hints
* Hint 1
```text
Use stack to store the last operator used.

Keep the precedence of the operator such that the resultant 
postfix expression is correct.
```
* Solution Approach
```text
Given the algorithm below, we have used a stack to keep the 
operators in the precedence order.

Algorithm:

    1. Scan the infix expression from left to right.
    2. If the scanned character is an operand, output it.
    3. Else,
        3.1 If the precedence of the scanned operator is greater than 
            that of the operator in the stack(or the stack is empty, 
            or the stack contains a ‘(‘ ), push it.
        3.2 Else, Pop all the operators from the stack which are 
            greater than or equal to in precedence than that of 
            the scanned operator. After doing that, Push the scanned 
            operator to the stack. (If you encounter parenthesis 
            while popping, stop there and push the scanned operator 
            in the stack.)
    4. If the scanned character is an ‘(‘, push it to the stack.
    5. If the scanned character is an ‘)’, pop the stack and 
       output it until a ‘(‘ is encountered, and discard both 
       the parenthesis.
    6. Repeat steps 2-6 until infix expression is scanned.
    7. Print the output
    8. Pop and output from the stack until it is not empty.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(String A) {
        return infixToPostfix(A);
    }
    public int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
    // Function to convert infix expression
    //to postfix expression
    public String infixToPostfix(String s) {
        Stack < Character > st = new Stack < Character > ();
        st.push('N');
        ArrayList < Character > ns = new ArrayList < Character > ();
        for (int i = 0; i < s.length(); i++) {
            char C = s.charAt(i);
            // If the scanned character is an operand, add it to output string.
            if ((C >= 'a' && C <= 'z') || (C >= 'A' && C <= 'Z'))
                ns.add(C);
            // If the scanned character is an '(', push it to the stack.
            else if (C == '(')
                st.push('(');
            // If the scanned character is an ')', pop and to output string from the stack
            // until an '(' is encountered.
            else if (C == ')') {
                while (st.peek() != 'N' && st.peek() != '(') {
                    char c = st.peek();
                    st.pop();
                    ns.add(c);
                }
                if (st.peek() == '(') {
                    char c = st.peek();
                    st.pop();
                }
            }
            //If an operator is scanned
            else {
                while (st.peek() != 'N' && prec(C) <= prec(st.peek())) {
                    char c = st.peek();
                    st.pop();
                    ns.add(c);
                }
                st.push(C);
            }
        }
        //Pop all the remaining elements from the stack
        while (st.peek() != 'N') {
            char c = st.peek();
            st.pop();
            ns.add(c);
        }
        StringBuilder result = new StringBuilder(ns.size());
        for (Character c: ns) {
            result.append(c);
        }
        return result.toString();
    }
}
```
* * Solution in Javascript
```javascript
function prec(c) {
    if (c == "^") return 3;
    else if (c == "*" || c == "/") return 2;
    else if (c == "+" || c == "-") return 1;
    else return -1;
}

// The main function to convert infix expression to postfix expression
function infixToPostfix(s) {
    let st = [];
    st.push("N");
    let l = s.length;
    let ns = "";
    for (let i = 0; i < l; i++) {
        // If the scanned character is an operand, add it to output string.
        if (s[i] >= "a" && s[i] <= "z") ns += s[i];
        // If the scanned character is an ‘(‘, push it to the stack.
        else if (s[i] == "(") st.push("(");
        // If the scanned character is an ‘)’, pop and to output string from the stack
        // until an ‘(‘ is encountered.
        else if (s[i] == ")") {
            while (st[st.length - 1] != "N" && st[st.length - 1] != "(") {
                let c = st[st.length - 1];
                st.pop();
                ns += c;
            }
            if (st[st.length - 1] == "(") {
                let c = st[st.length - 1];
                st.pop();
            }
        }
        // If an operator is scanned
        else {
            while (st[st.length - 1] != "N" && prec(s[i]) <= prec(st[st.length - 1])) {
                let c = st[st.length - 1];
                st.pop();
                ns += c;
            }
            st.push(s[i]);
        }
    }
    // Pop all the remaining elements from the stack
    while (st[st.length - 1] != "N") {
        let c = st[st.length - 1];
        st.pop();
        ns += c;
    }
    return ns;
}

module.exports = {
    solve: function (A) {
        return infixToPostfix(A);
    },
};
```
* * Solution in C++
```cpp
int prec(char c) {
    if (c == '^')
        return 3;
    else if (c == '*' || c == '/')
        return 2;
    else if (c == '+' || c == '-')
        return 1;
    else
        return -1;
}

// The main function to convert infix expression
//to postfix expression
string infixToPostfix(string & s) {
    stack < char > st;
    st.push('N');
    int l = s.length();
    string ns;
    for (int i = 0; i < l; i++) {
        // If the scanned character is an operand, add it to output string.
        if ((s[i] >= 'a' && s[i] <= 'z'))
            ns += s[i];
        // If the scanned character is an ‘(‘, push it to the stack.
        else if (s[i] == '(')
            st.push('(');
        // If the scanned character is an ‘)’, pop and to output string from the stack
        // until an ‘(‘ is encountered.
        else if (s[i] == ')') {
            while (st.top() != 'N' && st.top() != '(') {
                char c = st.top();
                st.pop();
                ns += c;
            }
            if (st.top() == '(') {
                char c = st.top();
                st.pop();
            }
        }
        // If an operator is scanned
        else {
            while (st.top() != 'N' && prec(s[i]) <= prec(st.top())) {
                char c = st.top();
                st.pop();
                ns += c;
            }
            st.push(s[i]);
        }
    }
    // Pop all the remaining elements from the stack
    while (st.top() != 'N') {
        char c = st.top();
        st.pop();
        ns += c;
    }
    return ns;

}
string Solution::solve(string A) {
    return infixToPostfix(A);
}
```

