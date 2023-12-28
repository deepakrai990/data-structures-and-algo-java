### Q3. Longest Palindromic Substring
#### Problem Description
```text
Given a string A of size N, find and return the 
longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is 
palindrome if reverse(A) = A.

In case of conflict, return the substring which occurs 
first ( with the least starting index).
```
#### Problem Constraints
```text
1 <= N <= 6000
```
#### Input Format
```text
First and only argument is a string A.
```
#### Output Format
```text
Return a string denoting the longest palindromic substring of string A.
```
#### Example Input
```text
Input 1:
 A = "aaaabaaa"
```
#### Example Output
```text
Output 1:
 "aaabaaa"
```
#### Example Explanation
```text
Explanation 1:
    We can see that longest palindromic substring is of length 7 
    and the string is "aaabaaa".
```
### Hints
* Hint 1
```text
A common mistake:

Some people will be tempted to come up with a quick solution, 
which is unfortunately flawed (however can be corrected easily):

Reverse S and become S’. Find the longest common substring 
between S and S’, which must also be the 
longest palindromic substring.

This seemed to work, let’s see some examples below.

For example,

S = “caba” 
S’ = “abac”
The longest common substring between S and S’ is “aba”, which is the answer.

Let’s try another example:

S = “abacdfgdcaba”
S’ = “abacdgfdcaba”

The longest common substring between S and S’ is “abacd”. Clearly, 
this is not a valid palindrome.

Brute force solution, O(N^3):
The obvious brute force solution is to pick all possible 
starting and ending positions for a substring, and verify if it 
is a palindrome. There are a total of C(N, 2) such 
substrings (excluding the trivial solution where a character 
itself is a palindrome).

Since verifying each substring takes O(N) time, 
the run time complexity is O(N^3).

Can you come up with a O(N^2) time complexity and O(1) space solution ?
```
* Solution Approach
```text
A simpler approach, O(N^2) time and O(1) space:

In fact, we could solve it in O(N^2) time without any extra space.

We observe that a palindrome mirrors around its center. Therefore, 
a palindrome can be expanded from its center, and there are 
only 2N-1 such centers.

You might be asking why there are 2N-1 but not N centers?

The reason is that the center of a palindrome can be in 
between two letters.

Such palindromes have even number of letters (such as “abba”) and 
their center are between the two ‘b’s.

Since expanding a palindrome around its center could take O(N) time, 
the overall complexity is O(N^2).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String expandAroundCenter(String s, int c1, int c2) {
        int l = c1, r = c2;
        int n = s.length();
        while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
    public String longestPalindrome(String A) {
        int n = A.length();
        if (n == 0)
            return "";
        String longest = A.substring(0, 1); // a single char itself is a palindrome
        for (int i = 0; i < n - 1; i++) {
            String p1 = expandAroundCenter(A, i, i);
            if (p1.length() > longest.length())
                longest = p1;
            String p2 = expandAroundCenter(A, i, i + 1);
            if (p2.length() > longest.length())
                longest = p2;
        }
        return longest;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //return a strings
    longestPalindrome: function (s) {
        var str = '';
        for (let i = 0; i < s.length; i++) {
            for (let j = 0; j < 2; j++) {
                var left = i;
                var right = left + j;
                while (s[left] && s[left] === s[right]) {
                    left--;
                    right++;
                }
                if (right - left - 1 > str.length) {
                    str = s.slice(left + 1, right);
                }
            }
        }
        return str;
    }
};
```
* * Solution in C++
```cpp
string expandAroundCenter(string s, int c1, int c2) {
    int l = c1, r = c2;
    int n = s.length();
    while (l >= 0 && r <= n - 1 && s[l] == s[r]) {
        l--;
        r++;
    }
    return s.substr(l + 1, r - l - 1);
}

string Solution::longestPalindrome(string s) {
    int n = s.length();
    if (n == 0)
        return "";
    string longest = s.substr(0, 1); // a single char itself is a palindrome
    for (int i = 0; i < n - 1; i++) {
        string p1 = expandAroundCenter(s, i, i);
        if (p1.length() > longest.length())
            longest = p1;
        string p2 = expandAroundCenter(s, i, i + 1);
        if (p2.length() > longest.length())
            longest = p2;
    }
    return longest;
}
```

