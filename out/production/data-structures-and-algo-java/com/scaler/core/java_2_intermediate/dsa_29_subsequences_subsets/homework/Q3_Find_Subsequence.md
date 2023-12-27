### Q3. Find subsequence
#### Problem Description
```text
Given two strings A and B, find if A is a subsequence of B.

Return "YES" if A is a subsequence of B, else return "NO".
```
#### Problem Constraints
```text
1 <= lenght(A), length(B) <= 100000

'a' <= A[i], B[i] <= 'z'
```
#### Input Format
```text
The first argument given is the string A.
The second argument given is the string B.
```
#### Output Format
```text
Return "YES" if A is a subsequence of B, else return "NO".
```
#### Example Input
```text
Input 1:
 A = "bit"
 B = "dfbkjijgbbiihbmmt"

Input 2:
 A = "apple"
 B = "appel"
```
#### Example Output
```text
Output 1:
 YES

Output 2:
 "NO"
```
#### Example Explanation
```text
/** not available **/
```
### Hints
* Hint 1
```text
Think about greedily finding a character and moving to next 
character when the current character is found.
```
* Solution Approach
```text
1. Traverse both A and B from left to right. If we find a 
   matching character, we move ahead in both strings. Otherwise, 
   we move ahead only in B.

2. if A finishes first, return "YES"

3. Else return "NO"
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(String A, String B) {
        int m = A.length();
        int n = B.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == m) {
            return "YES";
        }
        return "NO";
    }
}
```
* * Solution in Javascript
```javascript
/** not available **/
```
* * Solution in C++
```cpp
string Solution::solve(string A, string B) {
    int m = A.length();
    int n = B.length();
    int i=0,j=0;
    while(i<m && j<n)
    {
        if(A[i] == B[j])
        {
            i++;
            j++;
        }
        else
        {
            j++;
        }
    }
    if(i == m)
    {
        return "YES";
    }
    return "NO";
}
```

