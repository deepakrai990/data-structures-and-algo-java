### Q1. Boring substring
#### Problem Description
```text
You are given a string A of lowercase English alphabets. Rearrange 
the characters of the given string A such that there is no 
boring substring in A.

A boring substring has the following properties:

    * Its length is 2.
    * Both the characters are consecutive, for 
      example - "ab", "cd", "dc", "zy" etc.(If the 
      first character is C then the next character can 
      be either (C+1) or (C-1)).

Return 1 if it is possible to rearrange the letters of A such 
that there are no boring substrings in A else, return 0.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A| &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= |A| <= 10^5
```
#### Input Format
```text
The only argument given is a string A.
```
#### Output Format
```text
Return 1 if it is possible to rearrange the letters 
of A such that there are no boring substrings in A else, return 0.
```
#### Example Input
```text
Input 1:
 A = "abcd"

Input 2:
 A = "aab"
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
    String A can be rearranged into "cadb" or "bdac" 

Explanation 2:
    No arrangement of string A can make it free of boring substrings.

```
### Hints
* Hint 1
```text
Think in terms of parity of ASCII values of the characters.

All odd parity needs to stay together.
Similarly, all even parity characters need to stay together.
```
* Solution Approach
```text
No specific knowledge is required to solve this question.
You need to observe and find an existing pattern hidden in 
the parities of ASCII value of characters.

‘a’ could be present near ‘c’ , similarly ‘c’ could be 
near ‘e’ as we can see odd characters can be put aside 
each other, and there will be no boring substring in it.

Like: “acegik…” No boring substring is present in this string.

Similarly for even characters.

Now traverse in the string and form two strings, one containing 
the odd characters and the other even characters.

Sort both of them and check if placing them together 
doesn’t make a boring substring at their join point.

For example:
A = “abcdefg”
So ,
odd = “aceg”
even= “bdf”

Check the string s = odd+even or s=even+odd doesn’t contain 
any boring substring.

Time Complexity: O(A)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public boolean check(String s) {
        boolean ok = true;
        for (int i = 0; i + 1 < s.length(); ++i)
            ok &= (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1);
        return ok;
    }
    public int solve(String A) {
        String odd = "", even = "";
        // odd and even stores odd and even characters respective
        for (int i = 0; i < A.length(); ++i) {
            char c = A.charAt(i);
            if (c % 2 == 0)
                odd += c;
            else
                even += c;
        }
        char[] ar = odd.toCharArray();
        Arrays.sort(ar);
        odd = String.valueOf(ar);
        ar = even.toCharArray();
        Arrays.sort(ar);
        even = String.valueOf(ar);
        // check if either (odd + even) or (even + odd) has no boring substrings
        if (check(odd + even))
            return 1;
        else if (check(even + odd))
            return 1;
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
function check(s) {
  let ok = true;
  for (let i = 0; i + 1 < s.length; ++i)
    ok &= Math.abs(s[i].charCodeAt(0) - s[i + 1].charCodeAt(0)) != 1;
  return ok;
}

module.exports = {
    solve: function (A) {
        let odd = "",
            even = "";
        // odd and even stores odd and even characters respective
        for (let i = 0; i < A.length; ++i) {
            let c = A[i].charCodeAt(0);
            if (c % 2 == 0) odd += String.fromCharCode(c);
            else even += String.fromCharCode(c);
        }
        odd = odd.split("").sort().join("");
        even = even.split("").sort().join("");
        // check if either (odd + even) or (even + odd) has no boring substrings
        if (check(odd + even)) return 1;
        else if (check(even + odd)) return 1;
        return 0;
    },
};
```
* * Solution in C++
```cpp
bool check(string s) {
    bool ok = true;
    for (int i = 0; i + 1 < s.size(); ++i)
        ok &= (abs(s[i] - s[i + 1]) != 1);
    return ok;
}
int solveit(string s) {
    string odd = "", even = "";
    // odd and even stores odd and even characters respective
    for (int i = 0; i < s.size(); ++i) {
        if (s[i] % 2 == 0)
            odd += s[i];
        else
            even += s[i];
    }
    sort(odd.begin(), odd.end());
    sort(even.begin(), even.end());
    // check if either (odd + even) or (even + odd) has no boring substrings
    if (check(odd + even))
        return 1;
    else if (check(even + odd))
        return 1;
    return 0;
}
int Solution::solve(string A) {
    return solveit(A);
}
```

