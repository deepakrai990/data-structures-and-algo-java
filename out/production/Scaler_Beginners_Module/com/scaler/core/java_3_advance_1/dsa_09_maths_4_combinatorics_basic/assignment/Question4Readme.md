### Q4. Excel Column Title
#### Problem Description
```text
Given a positive integer A, return its corresponding column 
title as it appears in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
```
#### Problem Constraints
* <p>1 &lt;= A &lt;= 10<sup>9</sup></p>
```text
1 <= A <= 10^9
```
#### Input Format
```text
First and only argument of input contains single integer A
```
#### Output Format
```text
Return a string denoting the corresponding title.
```
#### Example Input
```text
Input 1:
 A = 3

Input 2:
 A = 27
```
#### Example Output
```text
Output 1:
 "C"

Output 2:
 "AA"
```
#### Example Explanation
```text
Explanation 1:
    3 corresponds to C.

Explanation 2:
    1 -> A,
    2 -> B,
    3 -> C,
    ...
    26 -> Z,
    27 -> AA,
    28 -> AB 
```
### Hints
* Hint 1
```text
Simple math.
This is just like base 26 number conversion.
```
* Solution Approach
```text
Think of it like this.

How would you convert a number to binary?

Can you apply the same principle here now that the base is different?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String convertToTitle(int A) {
        char[] array = new char[26];
        for (int i = 0; i < 26; i++)
            array[i] = (char)('A' + i);
        int num = 26;
        int index;
        String res = "";
        // find the characters from right to left
        while (A > 0) {
            index = (A - 1 + num) % num;
            A = (A - 1) / num;
            res = array[index] + res;
        }
        return res;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
   //param a : integer
    //return a string
	convertToTitle : function(colnum){
        var colstr = '';
        var pow = 26;
        var anum = 'A'.charCodeAt( 0 );
        // find the characters from right to left
        while(colnum > 0) {
            var rem = colnum % pow;
            if(!rem)
                rem = 26;
            colstr = (String.fromCharCode(anum + rem - 1) + colstr);
            colnum -= rem;
            colnum /= pow;
        }
        return colstr;
	}
};
```
* * Solution in C++
```cpp
string Solution::convertToTitle(int n) {
    string ans;
    // find the characters from right to left
    while (n) {
        ans = char((n - 1) % 26 + 'A') + ans;
        n = (n - 1) / 26;
    }
    return ans;
}
```

