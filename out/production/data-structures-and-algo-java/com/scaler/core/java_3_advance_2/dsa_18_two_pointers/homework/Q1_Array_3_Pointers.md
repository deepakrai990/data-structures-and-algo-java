### Q1. Array 3 Pointers
#### Problem Description
```text
You are given 3 sorted arrays A, B and C.

Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
```
#### Problem Constraints
* <p>0 &lt;= len(A), len(B), len(c) &lt;= 10<sup>6</sup></p>
* <p> 0 &lt;= A[i], B[i], C[i] &lt;= 10<sup>7</sup></p>
```text
0 <= len(A), len(B), len(c) <= 10^6

0 <= A[i], B[i], C[i] <= 10^7
```
#### Input Format
```text
First argument is an integer array A.

Second argument is an integer array B.

Third argument is an integer array C.
```
#### Output Format
```text
Return an single integer denoting the minimum 
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
```
#### Example Input
```text
Input 1:
 A = [1, 4, 10]
 B = [2, 15, 20]
 C = [10, 12]

Input 2:
 A = [3, 5, 6]
 B = [2]
 C = [3, 4]
```
#### Example Output
```text
Output 1:
 5

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    With 10 from A, 15 from B and 10 from C.
Explanation 2:
    With 3 from A, 2 from B and 3 from C.
```
### Hints
* Hint 1
```text
The bruteforce solution is to pick one element 
each from a, b and c in a loop. O(N^3).

Obviously something better is required in this case .

A better approach might be to:

    * Iterate over all elements of a,
    * Binary search for element just smaller than or equal to in b and c, 
      and note the difference.
    * Repeat the process for b and c. O(n log n).

Note: As we move over the element in a, the elements in b and c that 
we are trying to find will also move forward. *
```
* Solution Approach
```text
Windowing strategy works here.

Lets say the arrays are A,B and C.

    * Take 3 pointers X, Y and Z
    * Initialize them to point to the start of arrays A, B and C
    * Find min of X, Y and Z.
    * Compute max(X, Y, Z) - min(X, Y, Z).
    * If new result is less than current result, change it to the new result.
    * Increment the pointer of the array which contains the minimum.

Note: that we increment the pointer of the array which has 
the minimum, because our goal is to decrease the difference. Increasing 
the maximum pointer is definitely going to increase the 
difference. Increase the second maximum pointer can potentially 
increase the difference ( however, it certainly will not 
decrease the difference ).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int diff = Integer.MAX_VALUE;
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int i, j, k;
        for(i = 0, j = 0, k = 0; i < A.length && j < B.length && k < C.length;) {
            //  max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) = max(A[i], B[j], C[k]) - min(A[i], B[j], C[k])
            minimum = Math.min(A[i], Math.min(B[j], C[k]));
            maximum = Math.max(A[i], Math.max(B[j], C[k]));
            diff = Math.min(diff, maximum - minimum);
            if (diff == 0) break;
            if (A[i] == minimum) i++;
            else if (B[j] == minimum) j++;
            else k++;
        }
        return diff;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    minimize: function (a, b, c) {
        let diff = 2e9;
        let minimum = 2e9;
        let maximum = -2e9;
        let i, j, k;
        for (i = 0, j = 0, k = 0; i < a.length && j < b.length && k < c.length; ) {
            // max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) = max(A[i], B[j], C[k]) - min(A[i], B[j], C[k])
            minimum = Math.min(a[i], Math.min(b[j], c[k]));
            maximum = Math.max(a[i], Math.max(b[j], c[k]));
            diff = Math.min(diff, maximum - minimum);
            if (diff == 0) break;
            if (a[i] == minimum) i++;
            else if (b[j] == minimum) j++;
            else k++;
        }
        return diff;
    },
};
```
* * Solution in C++
```cpp
int Solution::minimize(const vector<int> &A, const vector<int> &B, const vector<int> &C) {
    int diff = INT_MAX;
    int minimum = INT_MAX;
    int maximum = INT_MIN;
    int i, j, k;
    for(i = 0, j = 0, k = 0; i < A.size() && j < B.size() && k < C.size();) {
        //  max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) = max(A[i], B[j], C[k]) - min(A[i], B[j], C[k])
        minimum = min(A[i], min(B[j], C[k]));
        maximum = max(A[i], max(B[j], C[k]));
        diff = min(diff, maximum - minimum);
        if (diff == 0) break;
        if (A[i] == minimum) i++;
        else if (B[j] == minimum) j++;
        else k++;
    }
    return diff;
}
```

