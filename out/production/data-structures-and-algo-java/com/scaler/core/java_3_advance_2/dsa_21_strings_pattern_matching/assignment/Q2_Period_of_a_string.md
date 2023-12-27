### Q2. Period of a string
#### Problem Description
```text
You are given a string A of length N consisting of lowercase 
alphabets. Find the period of the string.

Period of the string is the minimum value of k (k >= 1), 
that satisfies A[i] = A[i % k] for all valid i.
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
First and only argument is a string A of length N.
```
#### Output Format
```text
Return an integer, denoting the period of the string.
```
#### Example Input
```text
Input 1:
 A = "abababab"

Input 2:
 A = "aaaa"
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Period of the string will be 2: 
    Since, for all i, A[i] = A[i%2]. 

Explanation 2:
    Period of the string will be 1.
```
### Hints
* Hint 1
```text
Think of using a pattern matching technique to find the 
solution in linear time. 
```
* Solution Approach
<pre>
A simple approach is to check for all values of K 
from 1 to n-1, but this will take O(N<sup>2</sup>).
</pre>

```text
A simple approach is to check for all values of K from 1 
to n-1, but this will take O(N^2).

We can do this in linear time using a pattern matching 
algorithm (Z algorithm).

First, we will construct the Z array, i.e., for a string 
str[0..n-1], Z array is of the same length as a string. 
An element Z[i] of the Z array stores length of the 
longest substring starting from str[i], which is also a 
prefix of str[0..n-1]. The first entry of the Z array is 
meaningless as the complete string is always a prefix of itself.

This can be used, for any i (1 <= i < n), if i + Z[i] == N , 
then the period of the string is i.

If there is no such period, then N will be the period.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A) {
        ArrayList < Integer > Z = getZArr(A);
        int n = A.length();
        for (int i = 1; i < n; i++) {
            if (i + Z.get(i) == n) {
                return i;
            }
        }
        return n;
    }
    public ArrayList < Integer > getZArr(String str) {
        int n = str.length();
        // Z array
        ArrayList < Integer > Z = new ArrayList < Integer > ();
        for (int i = 0; i < n; i++) Z.add(0);
        int L, R, k;
        // [L, R] make a window which matches with prefix of str
        L = R = 0;
        for (int i = 1; i < n; ++i) {
            // if i > R nothing matches, so we will calculate Z[i] using naive way
            if (i > R) {
                L = R = i;
                // R - L = 0 in starting, so it will start checking from 0'th index
                while (R < n && str.charAt(R - L) == str.charAt(R))
                    R++;
                Z.set(i, R - L);
                R--;
            } else {
                // k = i - L so k corresponds to number which matches in [L,R] interval
                k = i - L;
                // if Z[k] is less than remaining interval then Z[i] will be equal to Z[k].
                if (Z.get(k) < R - i + 1)
                    Z.set(i, Z.get(k));
                else {
                    // else start from R and check manually
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R))
                        R++;
                    Z.set(i, R - L);
                    R--;
                }
            }
        }
        return Z;
    }
}
```
* * Solution in Javascript
```javascript
function getZarr(str) {
    let n = str.length;
    let Z = new Array(n);
    let L, R, k;
    L = R = 0;
    // Z[i] of the Z array stores length of the longest substring starting from str[i], 
    // which is also a prefix of str[0..n-1]
    for (let i = 1; i < n; ++i) {
        if (i > R) {
            L = R = i;
            while (R < n && str[R - L] == str[R]) 
                R++;
            Z[i] = R - L;
            R--;
        } else {
            k = i - L;
            if (Z[k] < R - i + 1) 
                Z[i] = Z[k];
            else {
                L = i;
                while (R < n && str[R - L] == str[R]) 
                    R++;
                Z[i] = R - L;
                R--;
            }
        }
    }
    return Z;
}

module.exports = {
    solve: function (A) {
        let Z = getZarr(A);
        let n = A.length;
        for (let i = 1; i < n; i++) {
            if (i + Z[i] == n) {
                return i;
            }
        }
        return n;
    },
};
```
* * Solution in C++
```cpp
vector < int > getZarr(string str) {
    int n = str.length();
    // Z array
    vector < int > Z(n);
    int L, R, k;
    // [L,R] make a window which matches with prefix of str
    L = R = 0;
    for (int i = 1; i < n; ++i) {
        // if i > R nothing matches so we will calculate Z[i] using naive way
        if (i > R) {
            L = R = i;
            // R - L = 0 in starting, so it will start checking from 0'th index
            while (R < n && str[R - L] == str[R])
                R++;
            Z[i] = R - L;
            R--;
        } else {
            // k = i - L so k corresponds to number which matches in [L,R] interval
            k = i - L;
            // if Z[k] is less than remaining interval then Z[i] will be equal to Z[k].
            if (Z[k] < R - i + 1)
                Z[i] = Z[k];
            else {
                // else start from R and check manually
                L = i;
                while (R < n && str[R - L] == str[R])
                    R++;
                Z[i] = R - L;
                R--;
            }
        }
    }
    return Z;
}

int Solution::solve(string A) {
    vector < int > Z = getZarr(A);
    int n = A.size();
    for (int i = 1; i < n; i++) {
        if (i + Z[i] == n) {
            return i;
        }
    }
    return n;
}
```

