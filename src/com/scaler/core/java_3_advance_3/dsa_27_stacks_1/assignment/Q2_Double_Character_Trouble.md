### Q2. Double Character Trouble
#### Problem Description
```text
You are given a string A.

An operation on the string is defined as follows:

Remove the first occurrence of the same consecutive 
characters. eg for a string "abbcd", the first occurrence 
of same consecutive characters is "bb".

Therefore the string after this operation will be "acd".

Keep performing this operation on the string until there are 
no more occurrences of the same consecutive characters and return 
the final string.
```
#### Problem Constraints
```text
1 <= |A| <= 100000
```
#### Input Format
```text
First and only argument is string A.
```
#### Output Format
```text
Return the final string.
```
#### Example Input
```text
Input 1:
 A = abccbc

Input 2:
 A = ab
```
#### Example Output
```text
Output 1:
 "ac"

Output 2:
 "ab"
```
#### Example Explanation
```text
Explanation 1:
    Remove the first occurrence of same consecutive characters. 
    eg for a string "abbc", the first occurrence of same 
    consecutive characters is "bb".
    
    Therefore the string after this operation will be "ac".

Explanation 2:
    No removals are to be done.
```
### Hints
* Hint 1
```text
There are many ways to implement the given problem.
Which would be the easiest?
Think about the problem in the direction of a stack.
```
* Solution Approach
```text
Consider an example string abba.

When we remove the “bb”, the remaining string is “aa” which has 
to be removed as well.

So we need to keep track of the characters before the first 
occurrence of similar consecutive characters.

We can do this using a stack.

We keep pushing the characters in a stack, if the current 
character is equal to the top of the stack, we pop from the 
stack since they represent a pair of similar characters.

Finally, we print the stack in reverse.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(String A) {
        // we maintain a stack for the characters of the string
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < A.length(); i++) {
            // if the current character is equal to the top of the stack then they form 
            // a pair of consecutive similar characters therefore we pop from the stack,
            // else we push the charcter in the stack
            if (!st.empty() && st.peek() == A.charAt(i)) {
                st.pop();
            } else st.push(A.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        return sb.toString();
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        stack = [];
        // we maintain a stack for the characters of the string
        stack.push("#");
        stack.push(A[0]);
        for (let i = 1; i < A.length; i++) {
            // if the current character is equal to the top of the stack then they form 
            // a pair of consecutive similar characters therefore we pop from the stack,
            // else we push the charcter in the stack
            if (A[i] == stack[stack.length - 1]) stack.pop();
            else stack.push(A[i]);
        }
        let i = 1;
        let ans = "";
        while (i < stack.length) {
            ans += stack[i];
            i = i + 1;
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
typedef int ll;
string Solution::solve(string A) {
    string s = A;
    stack < char > st;
    
    // we maintain a stack for the characters of the string
    st.push('#');
    st.push(s[0]);
    
    for (ll i = 1; i < s.length(); i++) {
        // if the current character is equal to the top of the stack then they form 
        // a pair of consecutive similar characters therefore we pop from the stack,
        // else we push the charcter in the stack
        if (s[i] == st.top())
            st.pop();
        else
            st.push(s[i]);
    }
    
    vector < char > ans;
    // we store the contents of the stack in a vector of characters.
    while (st.top() != '#') {
        ans.push_back(st.top());
        st.pop();
    }
    
    // since the final string is in reverse order, we reverse it and return the string
    reverse(ans.begin(), ans.end());
    string final = "";
    for (ll i = 0; i < ans.size(); i++)
        final += ans[i];
    return final;
}
```

