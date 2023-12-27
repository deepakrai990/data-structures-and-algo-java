### Q1. Smallest Prefix String
#### Problem Description
```text
Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, 
find the lexicographically smallest string that can be formed by concatenating 
non-empty prefixes of A and B (in that order).

Note: The answer string has to start with a non-empty prefix of string A followed 
      by a non-empty prefix of string B.
```
#### Problem Constraints
```text
1 <= N, M <= 100000
```
#### Input Format
```text
The first argument is a string A of size N.
The second argument is a string B of size M.
```
#### Output Format
```text
Return lexicographically smallest string that can be formed by concatenating 
non-empty prefixes of A and B (in that order).
```
#### Example Input
```text
Input 1:
 A = "abba"
 B = "cdd"

Input 2:
 A = "acd"
 B = "bay"
```
#### Example Output
```text
Output 1:
 "abbac"

Output 2:
 "ab"
```
#### Example Explanation
```text
Explanation 1:
    We can concatenate prefix of A i.e "abba" and prefix of B i.e "c".
    The lexicographically smallest string will be "abbac".

Explanation 2:
    We can concatenate prefix of A i.e "a" and prefix of B i.e "b".
    The lexicographically smallest string will be "ab".
```
### Hints
* Hint 1
```text
The first character of both the first and second strings will be in the answer string.

But how many characters of the first string should be appended before taking the 
first character of the second string?

Formally, what length prefix of the first string should be appended to the answer 
string to make it lexicographically smallest before adding the first character of 
the second string.
```
* Solution Approach
```text
Adding to the hint, we keep appending characters from the first string till the 
current character is less than the first character of the second string.

After that, we add the first character of the second string, and we have our answer.

(Since we want the lexicographically smallest string)

Time Complexity:- O(A)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String smallestPrefix(String A, String B) {
        String ans = "";
        int i = 1;
        ans += A.charAt(0);
        // keep appending A[i] till it is smaller than B[0]
        while (i < A.length() && A.charAt(i) < B.charAt(0)) {
            ans += A.charAt(i);
            i++;
        }
        ans += B.charAt(0);
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    smallestPrefix: function (A, B) {
        let ans = "";
        let i = 1;
        ans += A[0];
        // keep appending A[i] till it is smaller than B[0]
        while (i < A.length && A[i].charCodeAt(0) < B[0].charCodeAt(0)) {
            ans += A[i];
            i++;
        }
        ans += B[0];
        return ans;
    },
};
```
* * Solution in C++
```cpp
string Solution::smallestPrefix(string A, string B) {
    string ans = "";
    ans.push_back(A[0]);
    // keep appending A[i] till it is smaller than B[0]
    for (int i = 1; A[i] != '\0'; i++) {
        if (A[i] < B[0])
            ans.push_back(A[i]);
        else
            break;
    }
    ans.push_back(B[0]);
    return ans;
}
```

