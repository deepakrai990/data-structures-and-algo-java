### Q3. Check Palindrome
#### Problem Description
```text
Write a recursive function that checks whether string A is 
a palindrome or Not.

Return 1 if the string A is a palindrome, else return 0.

Note: A palindrome is a string that's the same when read 
forward and backward.
```
#### Problem Constraints
```text
1 <= |A| <= 50000

String A consists only of lowercase letters.
```
#### Input Format
```text
The first and only argument is a string A.
```
#### Output Format
```text
Return 1 if the string A is a palindrome, else return 0.
```
#### Example Input
```text
Input 1:
 A = "naman"

Input 2:
 A = "strings"
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
    "naman" is a palindomic string, so return 1.

Explanation 2:
    "strings" is not a palindrome, so return 0.
```
### Hints
* Hint 1
```text
Consider two indexes, i and j, initially at the first and 
last index of the string, respectively.

If the character at both i and j index is the same, check 
recursively for i+1, j-1.
```
* Solution Approach
```text
Consider two indexes i and j, initially at the first and 
last index of the string, respectively.

If the character at both i and j index is the same, check 
recursively for i+1, j-1.

We can say that, F(i, j) tell if the string from i to j is 
palindrome or not:

if(A[i] == A[j])
F(i, j) = F(i+1, j-1)
else
F(i, j) = 0
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int i, int j, String A) {
        if (i >= j) {
            return 1;
        }
        if (A.charAt(i) != A.charAt(j)) {
            return 0;
        }
        return solve(i + 1, j - 1, A);
    }

    public int solve(String A) {
        return solve(0, A.length() - 1, A);
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : string
    //return an integer
    solve : function(A){
       function check_palindrome(A,left,right) {
           if(left >= right)
               return 1;
           if(A[left] == A[right])
               return check_palindrome(A,left+1,right-1);
           else 
               return 0;
       }
       let n = A .length;
       return check_palindrome(A,0,n-1);
    }
};
```
* * Solution in C++
```cpp
int checkpalindrome(string &A, int i, int j){
    if(i >= j){
        return 1;
    }
    if(A[i] == A[j]){
        return checkpalindrome(A, i+1, j-1);
    }
    return 0;
}

int Solution::solve(string A) {
    return checkpalindrome(A, 0, A.size()-1);
}
```

