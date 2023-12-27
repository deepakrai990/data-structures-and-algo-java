### Q6. Another Count Rectangles
#### Problem Description
```text
Given a sorted array of distinct integers A and an integer B, find and 
return how many rectangles with distinct configurations can be created 
using elements of this array as length and breadth whose 
area is lesser than B.

(Note that a rectangle of 2 x 3 is different from 3 x 2 if we take 
configuration into view)
```
#### Problem Constraints
* <p>1 &lt;= <strong>|A|</strong> &lt;= 100000</p>
* <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
* <p>1 &lt;= B &lt;= 10<sup>9</sup></p>
```text
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9
```
#### Input Format
```text
The first argument given is the integer array A.

The second argument given is integer B.
```
#### Output Format

<p>Return the number of rectangles with distinct configurations with 
area less than B modulo (10<sup>9</sup> + 7).</p>

```text
Return the number of rectangles with distinct configurations with 
area less than B modulo (10^9 + 7).
```
#### Example Input
```text
Input 1:
 A = [1, 2]
 B = 5

Input 2:
 A = [1, 2]
 B = 1
```
#### Example Output
```text
Output 1:
 4

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    All 1X1, 2X2, 1X2 and 2X1 have area less than 5.

Explanation 2:
    No Rectangle is valid.
```
### Hints
* Hint 1
```text
Consider every element as a dimension and then try
to compute what is the answer if one dimension is the selected number.
```
* Solution Approach
```text
2 pointer technique is absolutely valid here.

We would like to consider every length and breadth and calculate it.
You can create two pointers l and r out of which initially one will 
point to index 0 and another will point to last index of the array 
and it the rectangle formed by them is valid the include all possible 
rectangles with A[l] and A[r] as length or breadth of rectangle.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList < Integer > A, int B) {
        long ans = 0, mod = (long)(1000000000 + 7);
        int l = 0, r = A.size() - 1;
        while (l < A.size() && r >= 0) {
            if ((long) A.get(l) * A.get(r) < B) {
                // A[l] can form rectangles with any of A[0..r]
                ans = (ans + r + 1) % mod;
                l++;
            } else r--;
        }
        return (int) ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A, B) {
        let ans = 0, mod = 1e9 + 7;
        let l = 0, r = A.length - 1;
        while (l < A.length && r >= 0) {
            if (A[l] * A[r] < B) {
                // A[l] can form rectangles with any of A[0..r]
                ans = (ans + r + 1) % mod;
                l++;
            } else r--;
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A, int B) {
    long ans = 0, mod = (long)(1e9 + 7);
    int l = 0, r = A.size() - 1;
    while(l < A.size() && r >= 0) {
        if(1L * A[l] * A[r] < B) {
            // A[l] can form rectangles with any of A[0..r]
            ans = (ans + r + 1) % mod;
            l++;
        } else  r--;
    }
    return (int)ans;
}
```

