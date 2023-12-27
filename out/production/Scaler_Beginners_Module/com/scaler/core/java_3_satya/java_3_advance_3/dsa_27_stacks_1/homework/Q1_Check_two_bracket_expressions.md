### Q1. Check two bracket expressions
#### Problem Description
```text
Given two strings A and B. Each string represents an expression consisting of 
lowercase English alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are identical, 
return 1 else, return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and 
every operand appears only once.
```
#### Problem Constraints
```text
1 <= length of the each String <= 100
```
#### Input Format
```text
The given arguments are string A and string B.
```
#### Output Format
```text
Return 1 if they represent the same expression else return 0.
```
#### Example Input
```text
Input 1:
 A = "-(a+b+c)"
 B = "-a-b-c"

Input 2:
 A = "a-b-(c-d)"
 B = "a-b-c-d"
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
    The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B. 

Explanation 2:
    Both the expression are different.
```
### Hints
* Hint 1
```text
Since each operand appears at most once, in both strings A and B, there should be 
an equal sign on each operand.

Can you use the stack to simplify the expression A and B?
```
* Solution Approach
```text
We will evaluate each expression one by one.

Calculate the sign on each operand present from ‘a’ to ‘z’ for first string A.

Now, repeat the same process on string B but with the opposite sign.

If the total sign on each operand is 0, return 1.

Else return 0.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {

    int MAX_CHAR = 26;

    public int solve(String A, String B) {
        if (areSame(A, B))
            return 1;
        return 0;
    }

    Boolean areSame(String expr1, String expr2) {
        int v[] = new int[MAX_CHAR];
        eval(expr1, v, true);
        // calls the second expression with opposite sign
        eval(expr2, v, false);
        // checks if both the expressions are equal
        for (int i = 0; i < MAX_CHAR; i++)
            if (v[i] != 0)
                return false;
        return true;
    }

    void eval(String s, int v[], Boolean add) {
        Stack < Boolean > stk = new Stack < Boolean > ();
        stk.push(true);
        int i = 0;
        // we evaluate the contribution of each character in the expression
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                i++;
                continue;
            }
            if (c == '(') {
                if (adjSign(s, i))
                    stk.push(stk.peek());
                else
                    stk.push(!stk.peek());
            } else if (c == ')')
                stk.pop();
            else {
                if (stk.peek())
                    v[c - 'a'] += (adjSign(s, i) ? add ? 1 : -1 :
                        add ? -1 : 1);
                else
                    v[c - 'a'] += (adjSign(s, i) ? add ? -1 : 1 :
                        add ? 1 : -1);
            }
            i++;
        }
    }
    
    Boolean adjSign(String s, int i) {
        if (i == 0)
            return true;
        if (s.charAt(i - 1) == '-')
            return false;
        return true;
    };
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
};

const MAX_CHAR = 26;

function adjSign(s, i) {
	if (i == 0)
		return 1;
	if (s[i - 1] == '-')
		return 0;
	return 1;
}

function eval(s, v, add) {
	let stk = new Stack();
	stk.push(1);
	let i = 0;
	// we evaluate the contribution of each character in the expression
	while (i < s.length) {
		if (s[i] == '+' || s[i] == '-') {
			i++;
			continue;
		}
		if (s[i] == '(') {
			if (adjSign(s, i))
				stk.push(stk.top());
			else
				stk.push(!stk.top());
		} else if (s[i] == ')')
			stk.pop();
		else {
			if (stk.top()) {
				if (adjSign(s, i)) {
					if (add == 1)
						v[s[i].charCodeAt(0) - 97] += 1
					else
						v[s[i].charCodeAt(0) - 97] -= 1
				} else {
					if (add == 1)
						v[s[i].charCodeAt(0) - 97] -= 1
					else
						v[s[i].charCodeAt(0) - 97] += 1
				}
			} else {
				if (adjSign(s, i)) {
					if (add == 1)
						v[s[i].charCodeAt(0) - 97] -= 1
					else
						v[s[i].charCodeAt(0) - 97] += 1
				} else {
					if (add == 1)
						v[s[i].charCodeAt(0) - 97] += 1
					else
						v[s[i].charCodeAt(0) - 97] -= 1
				}
			}
		}
		i++;
	}
}

function areSame(expr1, expr2) {
	let v = new Array(MAX_CHAR).fill(0);
	eval(expr1, v, true);
	// calls the second expression with opposite sign
	eval(expr2, v, false);
	// checks if both the expressions are equal
	for (let i = 0; i < MAX_CHAR; i++)
		if (v[i] != 0)
			return false;
	return true;
}

module.exports = {
	solve: function (A, B) {
		if (areSame(A, B))
			return 1;
		return 0;
	}
};
```
* * Solution in C++
```cpp
const int MAX_CHAR = 26;
bool adjSign(string & s, int i) {
    if (i == 0)
        return true;
    if (s[i - 1] == '-')
        return false;
    return true;
};

void eval(string & s, vector < int > & v, bool add) {
    stack < bool > stk;
    stk.push(true);
    int i = 0;
    // we evaluate the contribution of each character in the expression
    while (s[i] != '\0') {
        if (s[i] == '+' || s[i] == '-') {
            i++;
            continue;
        }
        if (s[i] == '(') {
            if (adjSign(s, i))
                stk.push(stk.top());
            else
                stk.push(!stk.top());
        } else if (s[i] == ')')
            stk.pop();

        else {
            if (stk.top())
                v[s[i] - 'a'] += (adjSign(s, i) ? add ? 1 : -1 :
                    add ? -1 : 1);
            else
                v[s[i] - 'a'] += (adjSign(s, i) ? add ? -1 : 1 :
                    add ? 1 : -1);
        }
        i++;
    }
};

bool areSame(string & expr1, string & expr2) {
    vector < int > v(MAX_CHAR, 0);
    eval(expr1, v, true);
    // calls the second expression with opposite sign
    eval(expr2, v, false);
    // checks if both the expressions are equal
    for (int i = 0; i < MAX_CHAR; i++)
        if (v[i] != 0)
            return false;

    return true;
}

int Solution::solve(string A, string B) {
    if (areSame(A, B))
        return 1;
    return 0;
}
```

