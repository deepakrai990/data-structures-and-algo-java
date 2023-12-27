### Q2. Minimum Absolute Difference
#### Problem Description
```text
Given an array of integers A, find and return the minimum 
value of | A [ i ] - A [ j ] | where i != j and |x| denotes 
the absolute value of x.
```
#### Problem Constraints
* <p>2 &lt;= length of the array &lt;= 100000</p>
* <p>-10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup></p>
```text
2 <= length of the array <= 100000

-10^9 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return the minimum value of | A[i] - A[j] |.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]

Input 2:
 A = [5, 17, 100, 11]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 6
```
#### Example Explanation
```text
Explanation 1:
    The absolute difference between any two adjacent 
    elements is 1, which is the minimum value.

Explanation 2:
    The minimum value is 6 (|11 - 5| or |17 - 11|).
```
### Hints
* Hint 1
```text
Think of sorting the array.

Can you find the minimum value in O(N) after sorting?
```
* Solution Approach
```text
Sort the array.

We can observe that the answer will be the minimum value of 
absolute difference between the adjacent elements.

We can iterate over the sorted array and maintain the 
minimum value of absolute difference.

Return the answer.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList < Integer > A) {
        int n = A.size();
        // sort the array 
        Collections.sort(A);
        // initialize the ans variable
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            // store the minimum value
            ans = Math.min(ans, A.get(i) - A.get(i - 1));
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        // sort the array 
        A.sort((a, b) => a - b);
        // initialize the ans variable
        let ans = Number.MAX_SAFE_INTEGER;
        for (let i = 1; i < A.length; i++) {
            // store the minimum value
            ans = Math.min(ans,A[i] - A[i - 1]);
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A) {
    int n = A.size();
    // sort the array 
    sort(A.begin(), A.end());
    // initialize the ans variable
    int ans = A[1] - A[0];
    for (int i = 1; i < n; i++) {
        // store the minimum value
        ans = min(ans, A[i] - A[i - 1]);
    }
    return ans;
}
```

