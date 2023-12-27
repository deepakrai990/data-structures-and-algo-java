### Q2. Simple Reverse
#### Problem Description
```text
Given a string A, you are asked to reverse the string and 
return the reversed string.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>1 &lt;= |A| &lt;= 10<sup>5</sup></p>
    <p>String A consist only of lowercase characters.</p>
</div>

```text
1 <= |A| <= 105

String A consist only of lowercase characters.
```
#### Input Format
```text
First and only argument is a string A.
```
#### Output Format
```text
Return a string denoting the reversed string.
```
#### Example Input
```text
Input 1:
 A = "scaler"

Input 2:
 A = "academy"
```
#### Example Output
```text
Output 1:
 "relacs"

Output 2:
 "ymedaca"
```
#### Example Explanation
```text
Explanation 1:
    Reverse the given string.
```
### Hints
* Hint 1
```text
One idea is to create new string, iterate A in reverse order
store each character in the new string.
Can you save the memory?
```
* Solution Approach
```text
One idea is to create new string, iterate A in reverse order
store each character in the new string.


Other is to do inplace reverse operation on the string. 

This can be done, by iterating the first half of the string,
let's say we are at index i then, swap(A[i], A[n-i-1])
where n is the length of string.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(String A) {
        char[] s = A.toCharArray();
        int n = A.length();
        for (int i = 0; i < n / 2; i++) {
            char tmp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = tmp;
        }
        return new String(s);
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //return a strings
    solve: function (A) {
        return A.split('').reverse().join('');
    }
};
```
* * Solution in C++
```cpp
string Solution::solve(string A) {
    int n = A.size();
    for(int i = 0; i < n/2; i++){
        swap(A[i], A[n-i-1]);
    }
    return A;
}

```

