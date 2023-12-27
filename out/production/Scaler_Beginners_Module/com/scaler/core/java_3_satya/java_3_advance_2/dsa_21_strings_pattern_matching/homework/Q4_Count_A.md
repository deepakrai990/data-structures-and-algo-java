### Q4. Count A
#### Problem Description
```text
You are given a string A. Find the number of substrings that start and end with 'a'.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A| &lt;= 10<sup>5</sup></p>
    <p>The string will have only lowercase English letters.</p>
</div>

```text
1 <= |A| <= 10^5

The string will have only lowercase English letters.
```
#### Input Format
```text
Given the only argument is a String A.
```
#### Output Format
```text
Return number of substrings that start and end with 'a'.
```
#### Example Input
```text
Input 1:
 A = "aab"

Input 2:
 A = "bcbc"
```
#### Example Output
```text
Output 1:
 3

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    Substrings that start and end with 'a' are:
        1. "a"
        2. "aa"
        3. "a"

Explanation 2:
    There are no substrings that start and end with 'a'.
```
### Hints
* Hint 1
```text
You need to look for an optimal way for finding the number of substrings in a string 
that starts and ends with ‘a’.

Think of how counting a’s can help.
```
* Solution Approach
```text
You need to look for an optimal way for finding the number of substrings in a 
string that starts and ends with ‘a’.

Count the number of a’s, let that number be N.

Then the number of substrings that start and end with ‘a’ will be (N * (N + 1)) / 2.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A) {
        int n = (int) A.length();
        // traverse the string and count the frequency of 'a'
        int count_A = 0;
        for (int i = 0; i < n; i += 1) {
            if (A.charAt(i) == 'a')
                count_A += 1;
        }
        // return the number of strings that start and end with 'a'
        return (count_A * (count_A + 1)) / 2;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        let n = A.length;
        let count_A = 0;
        // traverse the string and count the frequency of 'a'
        for (let i = 0; i < n; i += 1) {
          count_A += A[i] == "a";
        }
        // return the number of strings that start and end with 'a'
        return Math.floor((count_A * (count_A + 1)) / 2);
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(string A) {
    int n = (int) A.length();
    // traverse the string and count the frequency of 'a'
    int count_A = 0;
    for (int i = 0; i < n; i += 1) {
        count_A += (A[i] == 'a');
    }
    // return the number of strings that start and end with 'a'
    return (count_A * (count_A + 1)) / 2;
}
```

