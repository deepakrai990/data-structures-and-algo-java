### Q1. Count Rectangles
#### Problem Description
```text
Given two arrays of integers A and B of size N each, where each 
pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) 
in a 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) 
such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) 
form a rectangle with the rectangle having all the sides parallel 
to either x-axis or y-axis.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 2000<br>
    0 &lt;= A[i], B[i] &lt;= 10<sup>9</sup> </p>
</div>

```text
1 <= N <= 2000
0 <= A[i], B[i] <= 10^9
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is the integer array B.
```
#### Output Format
```text
Return the number of unordered quadruplets that form a rectangle.
```
#### Example Input
```text
Input 1:
 A = [1, 1, 2, 2]
 B = [1, 2, 1, 2]

Input 1:
 A = [1, 1, 2, 2, 3, 3]
 B = [1, 2, 1, 2, 1, 2]
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
    All four given points make a rectangle. So, the answer is 1.

Explanation 2:
    3 quadruplets which make a rectangle are: 
    (1, 1), (2, 1), (2, 2), (1, 2)
    (1, 1), (3, 1), (3, 2), (1, 2)
    (2, 1), (3, 1), (3, 2), (2, 2)
```
### Hints
* Hint 1
```text
Try running two loops by fixing the two diagonally opposite 
ends of the rectangle.
```
* Solution Approach
```text
As mentioned in the hint, run two loops by fixing the two diagonally 
opposite rectangle ends.

We have fixed the one diagonal of the rectangle and two corner 
points. From this, we can easily find the other 
two rectangle points.

Suppose we have two diagonally opposite points: (x1, y1) 
and (x2, y2). Then the other two points of the rectangle 
must be (x1, y2) and (x2, y1).

We have to check if these two points (x1, y2) and (x2, y1) 
are given or not. If present, increment the answer.

We have incremented the answer twice for every rectangle because 
every rectangle has two diagonals. So, our final answer will 
be half of the answer obtained after running two loops.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] a, int[] b) {
        int n = a.length;
        HashMap<Integer, HashSet<Integer>> mpx = new HashMap<>();
        HashSet<Integer> h;
        // stores all the points
        for (int i = 0; i < n; i++) {
            if (mpx.containsKey(a[i]))
                h = mpx.get(a[i]);
            else
                h = new HashSet<>();
            h.add(b[i]);
            mpx.put(a[i], h);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // checks if there exists a rectange such that the i-th and 
                // j-th points are the ends of a diagonal
                if (a[i] == a[j] || b[i] == b[j])
                    continue;
                if (mpx.get(a[i]).contains(b[j]) && mpx.get(a[j]).contains(b[i]))
                    ans++;
            }
        }
        return ans >> 1;
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
        let m = new Map();
        // stores all the points
        for (let i = 0; i < A.length; i++) {
            m[[A[i], B[i]]] = (m[[A[i], B[i]]] || 0) + 1;
        }
        let ans = 0;
        for (let i = 0; i < A.length; i++) {
            for (let j = i + 1; j < A.length; j++) {
                // checks if there exists a rectange such that the i-th and 
                // j-th points are the ends of a diagonal
                if (A[i] === A[j] || B[i] === B[j]) {
                    continue;
                }
                if ((m[[A[i], B[j]]] || 0) != 0 && (m[[A[j], B[i]]] || 0) != 0) {
                    ans = ans + 1;
                }
            }
        }
        let ret = Math.floor(ans / 2);
        return ret;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A, vector < int > & B) {
    map < pair < int, int > , int > mp;
    int ans = 0;
    // stores all the points
    for (int i = 0; i < A.size(); i++) {
        mp[{A[i], B[i]}]++;
    }

    for (int i = 0; i < A.size(); i++) {
        for (int j = i + 1; j < A.size(); j++) {
            // checks if there exists a rectange such that the i-th and 
            // j-th points are the ends of a diagonal
            if (A[i] != A[j] && B[i] != B[j])
                if (mp[{A[i], B[j]}] != 0 && mp[{A[j], B[i]}] != 0)
                    ans++;
        }
    }
    return ans / 2;
}
```

