### Q4. Assign Mice to Holes
#### Problem Description
```text
N Mice and N holes are placed in a straight line. Each hole can accommodate only one mouse.

The positions of Mice are denoted by array A, and the position of holes is denoted 
by array B.

A mouse can stay at his position, move one step right from x to x + 1, or move 
one step left from x to x − 1. Any of these moves consume 1 minute.

Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>-10<sup>9</sup> &lt;= A[i], B[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 10^5

-10^9 <= A[i], B[i] <= 10^9
```
#### Input Format
```text
The first argument is an integer array A.

The second argument is an integer array B.
```
#### Output Format
```text
Return an integer denoting the minimum time when the last nouse gets inside the holes.
```
#### Example Input
```text
Input 1:
 A = [-4, 2, 3]
 B = [0, -2, 4]

Input 2:
 A = [-2]
 B = [-6]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
     Assign the mouse at position (-4 to -2), (2 to 0) and (3 to 4).
     The number of moves required will be 2, 2 and 1 respectively.
     So, the time taken will be 2.

Explanation 2:
     Assign the mouse at position -2 to -6.
     The number of moves required will be 4.
     So, the time taken will be 4.
```
### Hints
* Hint 1
```text
Hint: Sorting

Can some greedy approach work here?
```
* Solution Approach
```text
Approach:

sort mice positions (in any order)
sort hole positions 

Loop i = 1 to N:
    update ans according to the value of |mice(i) - hole(i)|

Proof of correctness:

Let i1 < i2 be the positions of two mice and let j1 < j2 be the positions of two holes.
It suffices to show via case analysis that.

max(|i1 - j1|, |i2 - j2|) <= max(|i1 - j2|, |i2 - j1|) , 
    where '|a - b|' represent absolute value of (a - b)

since it follows by induction that every assignment can be transformed by a series of 
swaps into the sorted assignment, where none of these swaps increases the make span.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null || B == null)
            return 0;

        Collections.sort(A);
        Collections.sort(B);

        int max = 0;
        int n = A.size();

        for (int i = 0; i < n; i++) {
            max = Math.max(max, Math.abs(A.get(i) - B.get(i)));
        }

        return max;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    mice: function (A, B) {
        let N = A.length;
        A.sort((a, b) => a - b);
        B.sort((a, b) => a - b);
        let ans = 0;

        for (let i = 0; i < N; ++i) {
            ans = Math.max(ans, Math.abs(A[i] - B[i]));
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::mice(vector < int > & A, vector < int > & B) {
    int N = A.size();
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    int ans = 0;

    for (int i = 0; i < N; ++i) {
        ans = max(ans, abs(A[i] - B[i]));
    }
    return ans;
}
```

