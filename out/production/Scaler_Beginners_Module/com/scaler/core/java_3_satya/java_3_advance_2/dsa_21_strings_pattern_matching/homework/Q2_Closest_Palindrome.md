### Q2. Closest Palindrome
#### Problem Description
```text
Groot has a profound love for palindrome which is why he keeps fooling around with strings.
A palindrome string is one that reads the same backward as well as forward.

Given a string A of size N consisting of lowercase alphabets, he wants to know if it is 
possible to make the given string a palindrome by changing exactly one of its character.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup> </p>
</div>

```text
1 <= N <= 10^5
```
#### Input Format
```text
The first and only argument is a string A.
```
#### Output Format
```text
Return the string YES if it is possible to make the given string a palindrome by 
changing exactly 1 character. Else, it should return the string NO.
```
#### Example Input
```text
Input 1:
 A = "abbba"

Input 2:
 A = "adaddb"
```
#### Example Output
```text
Output 1:
 "YES"
Output 2:
 "NO"
```
#### Example Explanation
```text
Explanation 1:
    We can change the character at index 3(1-based) to any other character. The string will be palindromic.
Explanation 2:
    To make the string palindromic we need to change 2 characters. 
```
### Hints
* Hint 1
```text
For a string to be transformed into a palindrome, it has to have exactly 1 set of 
mirror indices with different characters.
```
* Solution Approach
```text
We apply our standard palindrome checking algorithm and count the number of times a 
set of mirror indices has different characters.

If at the end of processing, this count is greater than 1, then it can never be 
possible since we will have to change more than one character to make it a palindrome.

If the count is 1, the answer is always yes.

A corner case that needs to be considered is the case when the count is 0.

If the count is 0 and the palindrome length is even, then we cannot change exactly 
one character to make it a palindrome. We will have to change two mirror indices.

But if the count is 0 and the length is odd, then it is possible as we can change 
the middlemost character to anything.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(String A) {
        int N = A.length();
        int i = 0;
        int j = N - 1;
        int cnt = 0;
        // find the count of positions where the character in A is not same as that in reverse of A
        while (i < j) {
            if (A.charAt(i) != A.charAt(j)) 
                cnt += 1;
            i += 1;
            j -= 1;
        }
        if (cnt != 1) {
            if (cnt == 0 && N % 2 == 1) 
                return "YES";
            return "NO";
        } 
        return "YES";
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : string
 //return a strings
	solve : function(A){
        let len = A.length;
        let i = 0, j = len - 1;
        let cnt = 0;
        // find the count of positions where the character in A is not same as that in reverse of A
        while (i < j) {
            if (A[i] != A[j]) 
                cnt += 1;
            i += 1;
            j -= 1;
        }
        if (cnt != 1) {
            if (cnt == 0 && len % 2 == 1) 
                return "YES";
            return "NO";
        } 
        return "YES";
	}
};
```
* * Solution in C++
```cpp
string Solution::solve(string A) {
    int N = A.size();
    int i = 0;
    int j = N - 1;
    int cnt = 0;
    // find the count of positions where the character in A is not same as that in reverse of A
    while (i < j) {
        if (A[i] != A[j]) 
            cnt += 1;
        i += 1;
        j -= 1;
    }
    if (cnt != 1) {
        if (cnt == 0 and N % 2 == 1) 
            return "YES";
        return "NO";
    } 
    return "YES";
}
```

