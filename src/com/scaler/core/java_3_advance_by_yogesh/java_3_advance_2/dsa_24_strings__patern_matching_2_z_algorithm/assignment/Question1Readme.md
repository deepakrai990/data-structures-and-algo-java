### Q1. Cyclic Permutations
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given two binary strings <strong>A</strong> and 
    <strong>B</strong>, count how many <strong>cyclic shift
    </strong> of <strong>B</strong> when taken <strong>XOR</strong> 
    with <strong>A</strong> give <strong>0</strong>.</p>
    <p><strong>NOTE: </strong>If there is a string, 
    <strong>S<sub>0</sub>, S<sub>1</sub>, ... S<sub>n-1</sub> 
    </strong>, then it is a cyclic shift is of the form 
    <strong>S<sub>k</sub>, S<sub>k+1</sub>, ... S<sub>n-1</sub>, 
    S<sub>0</sub>, S<sub>1</sub>, ... S<sub>k-1</sub></strong> 
    where k can be any integer from 0 to N-1.</p>
</div>

#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 ≤ length(A) = length(B) ≤ 10<sup>5</sup></p>
</div>

```text
1 ≤ length(A) = length(B) ≤ 10^5
```
#### Input Format
```text
The first argument is a string A.
The second argument is a string B.
```
#### Output Format
```text
Return an integer denoting the required answer.
```
#### Example Input
```text
Input 1:
 A = "1001"
 B = "0011"

Input 2:
 A = "111"
 B = "111"
```
#### Example Output
```text
Output 1:
 1

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    4 cyclic shifts of B exists: "0011", "0110", "1100", "1001".  
    There is only one cyclic shift of B i.e. "1001" which 
    has 0 xor with A.

Explanation 2:
    All cyclic shifts of B are same as A and give 0 when 
    taken xor with A. So, the ans is 3.
```
### Hints
* Hint 1
```text
Xor of two elements is zero only when the two elements are equal.

Can we use the above fact to simplify the problem?
```
* Solution Approach
```text
We know that the Xor of two elements is zero only when both the 
elements are equal.

We have to check if the A == B or not. To overcome the cyclic 
shift problem, we can append the string A[0:len(A)-1] to A

For example : if A = “abc”, After appending the 
string A[0:len(A)-1] to A, A becomes “abcab”.

Now, we have to find the number of occurrences of the 
string B in string A. We can use any string matching algorithm 
like the KMP Z algorithm to find the number of occurrences

Time Complexity : O(N + M)
Space Complexity : O(N + M)

where N = length of A and M = length of B
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A, String B) {
        // append B to B to tackle cyclic permutations 
        B += B;
        int n = A.length(), m = B.length();
        int lps[] = new int[n];
        computeLPS(lps, A);
        int i = 0, l = 0, ans = 0;
        while (i < m - 1) {
            if (B.charAt(i) == A.charAt(l)) {
                i++;
                l++;
            }
            if (l == n) {
                l = lps[l - 1];
                ans++;
            } else if (i < m && B.charAt(i) != A.charAt(l)) {
                if (l > 0) {
                    l = lps[l - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;
    }

    // function used to the longest proper suffix array
    public void computeLPS(int lps[], String s) {
        int n = s.length();
        lps[0] = 0;
        int l = 0, i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(l)) {
                lps[i] = l + 1;
                i++;
                l++;
            } else {
                if (l > 0) {
                    l = lps[l - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
```
* * Solution in Javascript
```javascript
function computeLPS(lps, s) {
    // function used to longest proper suffix array
    let n = s.length;
    lps[0] = 0;
    let l = 0,
        i = 1;

    while (i < n) {
        if (s[i] == s[l]) {
            lps[i] = l + 1;
            i++;
            l++;
        } else {
            if (l > 0) {
                l = lps[l - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
}

module.exports = {
    solve: function (A, B) {
        // append A to A to tackle cyclic permutations 
        A += A;
        let n = A.length,
            m = B.length;
        let lps = new Array(m).fill(0);
        computeLPS(lps, B);
        let i = 0,
            l = 0,
            ans = 0;
        while (i < n - 1) {
            if (A[i] == B[l]) {
                i++;
                l++;
            }
    
            if (l == m) {
                l = lps[l - 1];
                ans++;
            } else if (i < n && A[i] != B[l]) {
                if (l > 0) {
                    l = lps[l - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
void computeLPS(int lps[], string & s) {
    int n = s.size();
    lps[0] = 0;
    // lps[i] finds the longest proper prefix of s[0..i] 
    // which is also a suffix of s[0..i]
    int l = 0, i = 1;
    while (i < n) {
        if (s[i] == s[l]) {
            lps[i] = l + 1;
            i++;
            l++;
        } else {
            if (l > 0) {
                l = lps[l - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
}

int Solution::solve(string A, string B) {
    A += A;
    int n = A.size(), m = B.size();
    int lps[m];
    computeLPS(lps, B);
    int i = 0, l = 0, ans = 0;
    // checks for the number of occurences of B in A
    while (i < n - 1) {
        if (A[i] == B[l]) {
            i++;
            l++;
        }
        if (l == m) {
            l = lps[l - 1];
            ans++;
        } else if (i < n && A[i] != B[l]) {
            if (l > 0) {
                l = lps[l - 1];
            } else {
                i++;
            }
        }
    }
    return ans;
}
```

