### Q4. Longest valid Parentheses
#### Problem Description
```text
Given a string A containing just the characters '(' and ')'.

Find the length of the longest valid (well-formed) parentheses substring.
```
#### Problem Constraints
```text
1 <= length(A) <= 750000
```
#### Input Format
```text
The only argument given is string A.
```
#### Output Format
```text
Return the length of the longest valid (well-formed) parentheses substring.
```
#### Example Input
```text
Input 1:
 A = "(()"

Input 2:
 A = ")()())"
```
#### Example Output
```text
Output 1:
 2

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    The longest valid parentheses substring is "()", which has length = 2.

Explanation 2:
    The longest valid parentheses substring is "()()", which has length = 4.
```
### Hints
* Hint 1
```text
If you know the longest parenthesis ending at index i, can you use that to compute answer?

Try to simulate using DP.
```
* Solution Approach
```text
Lets construct longest[i] where longest[i] denotes the longest set of parenthesis ending 
at index i.

    * If s[i] is ‘(‘, set longest[i] to 0, because any string end with ‘(‘ cannot be a valid one.
    * Else if s[i] is ‘)’
      If s[i-1] is ‘(‘, longest[i] = longest[i-2] + 2
      Else if s[i-1] is ‘)’ and s[i-longest[i-1]-1] == ‘(‘, longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]

Now that we know the longest set of parenthesis ending at each i , we can simply take 
its maximum and return it as the answer.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int longestValidParentheses(String A) {
        int max = 0;
        int last = -1;
        Stack < Integer > left = new Stack < > ();
        char c;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            c = A.charAt(i);
            if (c == '(') {
                left.push(i);
            } else {
                if (left.isEmpty()) {
                    last = i;
                } else {
                    left.pop();
                    if (left.isEmpty())
                        max = Math.max(max, i - last);
                    else
                        max = Math.max(max, i - left.peek());
                }
            }
        }
        return max;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //return an integer
    longestValidParentheses: function (s) {
        const n = s.length;
        const S = [-1];
        let x = 0;
        for (let i = 0; i < n; ++i)
            if (s[i] === '(')
                S.push(i); // open; mark start index
            else {
                S.pop(); // close; remove a start index
                if (!S.length)
                    S.push(i); // invalid; reset index to new start
                else
                    x = Math.max(x, i - S[S.length - 1]); // valid; save the length
            }
        return x;
    }
};
```
* * Solution in C++
```cpp
int Solution::longestValidParentheses(string A) {
    if (A.length() <= 1) return 0;
    int curMax = 0;
    vector < int > longest(A.size(), 0);
    for (int i = 1; i < A.length(); i++) {
        if (A[i] == ')' && i - longest[i - 1] - 1 >= 0 && A[i - longest[i - 1] - 1] == '(') {
            longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
            curMax = max(longest[i], curMax);
        }
    }
    return curMax;
}
```

