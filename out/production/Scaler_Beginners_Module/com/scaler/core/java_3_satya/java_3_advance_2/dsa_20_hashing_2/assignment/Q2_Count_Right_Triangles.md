### Q2. Count Right Triangles
#### Problem Description
```text
Given two arrays of integers A and B of size N each, where 
each pair (A[i], B[i]) for 0 <= i < N represents a unique 
point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) 
such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form 
a right-angled triangle with the triangle having one side 
parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (10^9 + 7).
```
<p>
    <strong>NOTE:</strong> 
    The answer may be large so return the 
    <strong>answer modulo (10<sup>9</sup> + 7)</strong>.
</p>

#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>0 &lt;= A[i], B[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 10^5

0 <= A[i], B[i] <= 10^9
```
#### Input Format
```text
The first argument given is an integer array A.
The second argument given is the integer array B.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>Return the number of unordered triplets that form a 
    right-angled triangle modulo (10<sup>9</sup> + 7).</p>
</div>

```text
Return the number of unordered triplets that form a right angled 
triangle modulo (10^9 + 7).
```
#### Example Input
```text
Input 1:
 A = [1, 1, 2]
 B = [1, 2, 1]

Input 2:
 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]
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
    All three points make a right angled triangle. So return 1.

Explanation 2:
    6 triplets which make a right angled triangle are:    
    (1, 1), (1, 2), (2, 1)
    (1, 1), (3, 1), (1, 2)
    (1, 1), (3, 1), (3, 2)
    (2, 1), (3, 1), (3, 2)
    (1, 1), (1, 2), (3, 2)
    (1, 2), (3, 1), (3, 2)
```
### Hints
* Hint 1
```text
Try fixing each point as the intersection of perpendicular and 
base and finding other points.
```
* Solution Approach
```text
Try fixing each point as the intersection of perpendicular and 
base and finding other points.

Once it is fixed, for the other two points, one point will share 
the same x-coordinate, and the other point will share the same 
y-coordinate with the selected point.

We can use a map to store the points for points sharing the 
same x or y coordinate.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] a, int[] b) {
        int n = a.length;
        // stores the frequency of each x coordinate
        HashMap < Integer, Integer > mpx = new HashMap < Integer, Integer > ();
        // stores the frequency of each y coordinate
        HashMap < Integer, Integer > mpy = new HashMap < Integer, Integer > ();
        for (int i = 0; i < n; i++) {
            if (mpx.get(a[i]) == null) {
                mpx.put(a[i], 1);
            } else
                mpx.put(a[i], mpx.get(a[i]) + 1);

            if (mpy.get(b[i]) == null) {
                mpy.put(b[i], 1);
            } else
                mpy.put(b[i], mpy.get(b[i]) + 1);
        }
        long ans = 0, mod = 1000 * 1000 * 1000 + 7;
        for (int i = 0; i < n; i++) {
            // counts the no of triangles that forms a right angle at the i-th point
            ans = (ans + (mpx.get(a[i]) - 1) * (mpy.get(b[i]) - 1)) % mod;
        }
        return (int) ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : array of integers
    //return an integer
    solve: function (A, B) {
        // stores the frequency of each x coordinate
        let m1 = new Map();
        // stores the frequency of each y coordinate
        let m2 = new Map();
        for (let i = 0; i < A.length; i++) {
            m1.set(A[i], (m1.get(A[i]) || 0) + 1);
            m2.set(B[i], (m2.get(B[i]) || 0) + 1);
        }
        let ans = 0,
            mod = 1000000007;
        for (let i = 0; i < A.length; i++) {
            // counts the no of triangles that forms a right angle at the i-th point
            let val = (m1.get(A[i]) - 1) * (m2.get(B[i]) - 1) % mod;
            ans = (ans + val) % mod;
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & a, vector < int > & b) {
    unordered_map < int, int > mp[2];
    int n = a.size();
    mp[0].clear();
    mp[1].clear();
    // stores the frequency of each x and y coordinate
    for (int i = 0; i < n; i++) {
        mp[0][a[i]]++;
        mp[1][b[i]]++;
    }
    long ans = 0, mod = 1e9 + 7;
    for (int i = 0; i < n; i++) {
        // counts the no of triangles that forms a right angle at the i-th point
        ans = (ans + 1L * (mp[0][a[i]] - 1L) * (mp[1][b[i]] - 1L)) % mod;
    }
    return (int) ans;
}
```
