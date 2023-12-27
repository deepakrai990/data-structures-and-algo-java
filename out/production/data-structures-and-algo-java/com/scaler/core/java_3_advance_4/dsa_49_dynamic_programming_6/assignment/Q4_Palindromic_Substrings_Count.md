### Q4. Palindromic Substrings Count
#### Problem Description
```text
Given a string A consisting of lowercase English alphabets. Your task is to find how 
many substrings of A are palindrome.

The substrings with different start indexes or end indexes are counted as different 
substrings even if they consist of same characters.

Return the count of palindromic substrings.

Note: A string is palindrome if it reads the same from backward and forward.
```
#### Problem Constraints
```text
1 <= length of the array <= 1000
```
#### Input Format
```text
The only argument given is string A.
```
#### Output Format
```text
Return the count of palindromic substrings.
```
#### Example Input
```text
Input 1:
    A = "abab"
    
Input 2:
    A = "ababa"
```
#### Example Output
```text
Output 1:
    6
    
Output 2:
    9
```
#### Example Explanation
```text
Explanation 1:
    6 palindromic substrings are:
    "a", "aba", "b", "bab", "a" and "b".
    
Explanation 2:
    9 palindromic substrings are:
    "a", "a", "a", "b", "b" , "aba" ,"bab", "aba" and "ababa".
```
### Hints
* Hint 1
```text
Trivial approach: For each substring chechk whether it is palindrome or not.
Time complexity : O(N^2)

We can do better?
We know that each palindrome has a center.
Think how can we count number of palindromic strings for each center.
```
* Solution Approach
```text
Let N be the length of the string. The middle of the palindrome could be in one 
of 2N - 1 positions: either at letter or between two letters.

For each center, let’s count all the palindromes that have this center. Notice 
that if [a, b] is a palindromic interval (meaning S[a], S[a+1], …, S[b] is a palindrome), 
then [a+1, b-1] is one too.

For each possible palindrome center, let’s expand our candidate palindrome on the 
interval [left, right] as long as we can. The condition for expanding is left >= 0 
and right < N and S[left] == S[right]. That means we want to count 
a new palindrome S[left], S[left+1], …, S[right].
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A) {
        int n = A.length() , ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int k = i, j = i; k < n && j >= 0; ++k, --j)
                if (A.charAt(k) == A.charAt(j))
                    ++ans;
                else
                    break;
            for (int k = i, j = i - 1; k < n && j >= 0; ++k, --j)
                if (A.charAt(k) == A.charAt(j))
                    ++ans;
                else
                    break;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
function countSubstrings(s) {
    let ans = 0;
    let n = s.length;
    for (let i = 0; i < n; ++i) {
        for (let k = i, j = i; k < n && j >= 0; ++k, --j)
            if (s[k] == s[j])
                ++ans;
            else
                break;
        for (let k = i, j = i - 1; k < n && j >= 0; ++k, --j)
            if (s[k] == s[j])
                ++ans;
            else
                break;
    }
    return ans;
}
module.exports = { 
    //param A : string
    //return an integer
	solve : function(A){
        return countSubstrings(A);
	}
};
```
* * Solution in C++
```cpp
int countSubstrings(string s) {
    int ans = 0;
    int n = s.size();
    for (int i = 0; i < n; ++i) {
        for (int k = i, j = i; k < n && j >= 0; ++k, --j)
            if (s[k] == s[j])
                ++ans;
            else
                break;
        for (int k = i, j = i - 1; k < n && j >= 0; ++k, --j)
            if (s[k] == s[j])
                ++ans;
            else
                break;
    }
    return ans;
}
```

