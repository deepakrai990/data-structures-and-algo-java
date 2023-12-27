### Q2. Excel Column Number
#### Problem Description
```text
Given a column title as appears in an Excel sheet, return 
its corresponding column number.
```
#### Problem Constraints
```text
1 <= length of the column title <= 5
```
#### Input Format
```text
The only argument is a string that represents the column 
title in the excel sheet.
```
#### Output Format
```text
Return a single integer that represents the corresponding column number.
```
#### Example Input
```text
Input 1:
 AB

Input 2:
 BB
```
#### Example Output
```text
Output 1:
 28

Output 2:
 54
```
#### Example Explanation
```text
Explanation 1:
     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28

Explanation 2:
     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     ...
     AZ -> 52
     BA -> 53
     BB -> 54
```
### Hints
* Hint 1
```text
Try something related to base conversion.
It is the same as the number formation with base 26.
```
* Solution Approach
```text
Simple math.

This is just like base 26 number conversion.

number = 26^0 * (S[n - 1] - ‘A’ + 1) + 26^1 * (S[n - 2] - ‘A’ + 1) + ….

We recommend you to check out the piece on base number 
conversion in articles again. Please also attempt the 
sample problem associated with it.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
	public int titleToNumber(String A) {
	    int value = 0;
	    // traverse each character
	    for(int i = 0; i < A.length(); i++){
	        char c = A.charAt(i);
	        value = value * 26 + (c - 'A' + 1);
	    }
	    return value;
	}
}
```
* * Solution in Javascript
```javascript
module.exports = {
    titleToNumber: function (A) {
        A = [...A].reverse().join("");
        let ans = 0, cur = 1;
        // traverse each character
        [...A].forEach((ele) => {
            ans += cur * (ele.charCodeAt(0) - "A".charCodeAt(0) + 1);
            cur *= 26;
        });
        return ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::titleToNumber(string A) {
    int r = 0;
    // traverse each character
    for(int i = 0; i < A.length(); ++i) {
        r = r * 26 + A[i] - 64;
    }
    return r;
}
```

