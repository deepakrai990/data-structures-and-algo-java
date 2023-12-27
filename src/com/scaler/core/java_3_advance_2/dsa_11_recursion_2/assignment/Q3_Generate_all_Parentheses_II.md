### Q3. Generate all Parentheses II
#### Problem Description
```text
Given an integer A pairs of parentheses, write a function 
to generate all combinations of well-formed parentheses 
of length 2*A.
```
#### Problem Constraints
```text
1 <= A <= 10
```
#### Input Format
```text
First and only argument is integer A.
```
#### Output Format
```text
Return a sorted list of all possible parenthesis.
```
#### Example Input
```text
Input 1:
 A = 3

Input 2:
 A = 1
```
#### Example Output
```text
Output 1:
 [ "((()))", "(()())", "(())()", "()(())", "()()()" ]

Output 2:
 [ "()" ]
```
#### Example Explanation
```text
Explanation 1:
    All parenthesis are given in the output list.

Explanation 2:
    All parenthesis are given in the output list.
```
### Hints
* Hint 1
```text
You can try thinking of recursion such that our solution is 
valid at every step.

How to define this valid thing now?
```
* Solution Approach
```text
Again, think recursion.
At every step, you have two options :
1) Add ‘(‘ to the string.
OR
2) Add ‘)’ to the string.
However, you need to make sure that the number of closing brackets 
does not exceed the number of opening brackets at any point in time.

Also, make sure that the number of opening brackets never exceeds n.

The list of strings would be sorted by default as in our recursive 
function we first handle the case of ‘(‘ and then ‘)’.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    ArrayList < String > ans;
    // cnt denotes remaining open brackets (
    // dif denotes the difference between open and closed brackets
    void solve(int cnt, int dif, int n, String s) {
        if (n == 0) {
            ans.add(s);
            return;
        }
        // Now we have 2 options. We can either add '(' to the string or add ')' to the string. 
        // Option 1. Add '(' 
        if (cnt > 0)
            solve(cnt - 1, dif + 1, n - 1, s + '(');
        // Option 2. Add ')'
        if (dif > 0)
            solve(cnt, dif - 1, n - 1, s + ')');
    }
    public ArrayList < String > generateParenthesis(int A) {
        ans = new ArrayList < > ();
        solve(A, 0, 2 * A, "");
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
var ans;
function generate (i, A, temp, co, cc) {
    if (i == 2 * A && cc == co) {
        ans.push(temp);
        return;
    }
    // Now we have 2 options. We can either add '(' to the string or add ')' to the string. 
    // Option 1. Add '('
    if (co < A) {
        generate(i + 1, A, temp + '(', co + 1, cc);
    }
    // Option 2. Add ')'
    if (cc < co) {
        generate(i + 1, A, temp + ')', co, cc + 1);
    }
}

module.exports = { 
 //param A : integer
 //return a array of strings
	generateParenthesis : function(A){
	    ans = [];
	    var temp = "";
	    generate(0, A, temp, 0, 0);
	    return ans;
	}
};
```
* * Solution in C++
```cpp
void generateHelper(string & current, int numOpenBrackets, int numClosedBrackets, int n, vector < string > & ans) {
    if (numOpenBrackets == numClosedBrackets && numOpenBrackets == n) {
        ans.push_back(current);
        return;
    }
    if (numOpenBrackets > n || numClosedBrackets > n) {
        // Invalid. 
        return;
    }
    // Now we have 2 options. We can either add '(' to the string or add ')' to the string. 
    // Option 1. Add '(' 
    if (numOpenBrackets < n) {
        current.push_back('(');
        generateHelper(current, numOpenBrackets + 1, numClosedBrackets, n, ans);
        current.pop_back();
    }
    // Option 2. Add ')'
    if (numClosedBrackets < numOpenBrackets) {
        current.push_back(')');
        generateHelper(current, numOpenBrackets, numClosedBrackets + 1, n, ans);
        current.pop_back();
    }
}
vector < string > Solution::generateParenthesis(int A) {
    vector < string > ans;
    string current = "";
    int numOpenBrackets = 0, numClosedBrackets = 0;
    generateHelper(current, numOpenBrackets, numClosedBrackets, A, ans);
    return ans;
}
```

