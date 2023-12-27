### Q3. Make String Palindrome
#### Problem Description
```text
Given a string A of size N consisting only of lowercase alphabets. 
The only operation allowed is to insert characters in the 
beginning of the string.

Find and return how many minimum characters are needed to be 
inserted to make the string a palindrome string.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>6</sup></p>
</div>

```text
1 <= N <= 10^6
```
#### Input Format
```text
The only argument given is a string A.
```
#### Output Format
```text
Return an integer denoting the minimum characters needed to be 
inserted in the beginning to make the string a palindrome string.
```
#### Example Input
```text
Input 1:
 A = "abc"

Input 2:
 A = "bb"
```
#### Example Output
```text
Output 1:
 2

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    Insert 'b' at beginning, string becomes: "babc".
    Insert 'c' at beginning, string becomes: "cbabc".

Explanation 2:
    There is no need to insert any character at the 
    beginning as the string is already a palindrome. 
```
### Hints
* Hint 1
```text
Try to learn about the LPS array used in the KMP string 
matching algorithm. 

Modify your string and compute its LPS array to 
derive the answer.
```
* Solution Approach
```text
Each index of the LPS array contains the longest prefix, which 
is also a suffix. Now take the string and reverse of a string 
and combine them with a sentinel character in between them and 
compute the LPS array of this combined string. Now take the last 
value of the LPS array and subtract it from the length of the 
original string. This will give us the minimum number of 
insertions required at the beginning of the string.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A) {
        String s = new String(A);
        StringBuilder sb = new StringBuilder(A);
        s += sb.reverse();
        int lps[];
        // lps array contains the longest prefix, which is also a suffix
        lps = computeLPS(s);
        return Math.max(A.length() - lps[s.length() - 1], 0);
    }
    public int[] computeLPS(String s) {
        int l = 0, i = 1;
        int lps[] = new int[s.length()];
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(l)) {
                lps[i] = ++l;
                i++;
            } else {
                if (l > 0) {
                    l = lps[l - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        function lps(str) {
            var arr = [0];
            var j = 0;
            var i = 1;
            while (i < str.length) {
                if (str[j] === str[i]) {
                    arr[i] = j + 1;
                    j++;
                    i++;
                } else if (j === 0) {
                    arr[i] = j;
                    i++;
                } else {
                    j = arr[j - 1];
                }
            }
            return arr;
        }
        var rev = A.concat("&").concat(A.split("").reverse().join(""));
        // lps array contains the longest prefix, which is also a suffix
        var arr = lps(rev);
        return A.length - arr[arr.length - 1];
    },
};
```
* * Solution in C++
```cpp
vector < int > computeLPSArray(string str) {
    int M = str.length();
    vector < int > lps(M);
    int len = 0;
    lps[0] = 0;
    int i = 1;
    while (i < M) {
        if (str[i] == str[len]) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = lps[len - 1];

            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}

int Solution::solve(string str) {
    string revStr = str;
    reverse(revStr.begin(), revStr.end());
    string concat = str + "$" + revStr;
    // LPS array contains the longest prefix, which is also a suffix
    vector < int > lps = computeLPSArray(concat);
    return (str.length() - lps.back());
}
```

