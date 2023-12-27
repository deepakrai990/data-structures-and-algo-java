### Q1. Points on same line
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given two arrays of integers <strong>A</strong> and 
    <strong>B</strong> describing a pair of 
    <strong>(A[i], B[i])</strong> coordinates in a 2D plane. 
    <strong>A[i]</strong> describe x coordinates of 
    the i<sup>th</sup> point in the 2D plane, whereas 
    <strong>B[i]</strong> describes the y-coordinate of 
    the i<sup>th</sup> point in the 2D plane.</p>
    <p>Find and return the <strong>maximum</strong> number of 
    points that lie on the same line.</p>
</div>

```text
Given two arrays of integers A and B describing a pair 
of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates 
of the i^th point in the 2D plane, whereas B[i] describes 
the y-coordinate of the i^th point in the 2D plane.

Find and return the maximum number of points that 
lie on the same line.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= (length of the array A = length of array B) &lt;= 1000</p>
    <p>-10<sup>5</sup> &lt;= A[i], B[i] &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= (length of the array A = length of array B) <= 1000

-10^5 <= A[i], B[i] <= 10^5
```
#### Input Format
```text
The first argument is an integer array A.
The second argument is an integer array B.
```
#### Output Format
```text
Return the maximum number of points which lie on the same line.
```
#### Example Input
```text
Input 1:
 A = [-1, 0, 1, 2, 3, 3]
 B = [1, 0, 1, 2, 3, 4]

Input 2:
 A = [3, 1, 4, 5, 7, -9, -8, 6]
 B = [4, -8, -3, -2, -1, 5, 7, -4]
```
#### Example Output
```text
Output 1:
 4

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    The maximum number of point which lie on same line 
    are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.

Explanation 2:
    Any 2 points lie on a same line.
```
### Hints
* Hint 1
```text
If two or more points lie on the same line, their pairwise 
slope is the same.

Since slope can have double values, which can cause precision problems.

Think of a solution to tackle the precision problem.
```
* Solution Approach
```text
If the two points are (x1, y1) and (x2, y2), then their 
slope will be (y2 – y1) / (x2 – x1), which can be a double 
value and can cause precision problems.

To get rid of the precision problems, we treat slope 
as pair ((y2 – y1), (x2 – x1)) instead of ratio and reduce 
pair by their gcd before inserting into the map.

Points that are vertical or repeated are treated separately.

Note: If we use a map in C++ or HashMap in Java for storing 
the slope pair, then the total time complexity of the 
solution will be O(n^2 log n)


```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int __gcd(int x, int y) {
        if (x == 0)
            return y;
        return __gcd(y % x, x);
    }
    public int solve(int[] A, int[] B) {
        return maxPointsOnSameLine(A, B);
    }
    public int maxPointsOnSameLine(int[] x, int[] y) {
        int n = x.length;
        if (n < 3)
            return n;
        int ans = 0;
        int curMax = 0, overlap = 0, vertical = 0;
        for (int i = 0; i < n; ++i) {
            curMax = 0;
            overlap = 0;
            vertical = 0;
            HashMap<ArrayList<Integer>, Integer> mp = new HashMap<ArrayList<Integer>, Integer>();
            for (int j = i + 1; j < n; ++j) {
                if (x[i] == x[j] && y[i] == y[j])
                    ++overlap;
                else if (x[i] == x[j])
                    ++vertical;
                else {
                    int xdiff = x[j] - x[i];
                    int ydiff = y[j] - y[i];
                    int z = __gcd(xdiff, ydiff);
                    xdiff /= z;
                    ydiff /= z;
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(xdiff);
                    tmp.add(ydiff);
                    // mp stores the slope of the line between i-th and j-th point
                    if (mp.get(tmp) == null) {
                        mp.put(tmp, 1);
                    } else {
                        mp.put(tmp, mp.get(tmp) + 1);
                    }
                    curMax = Math.max(curMax, mp.get(tmp));
                }
                curMax = Math.max(curMax, vertical);
            }
            ans = Math.max(ans, curMax + overlap + 1);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
function __gcd(x, y) {
    if (x == 0) {
        return y;
    }
    return __gcd(y % x, x);
}

module.exports = {
    //param A : array of integers
    //param B : array of integers
    //return an integer
    solve: function (x, y) {
        let n = x.length;
        if (n < 3) {
            return n;
        }
        let ans = 0;
        let curmax = 0,
            overlap = 0,
            vertical = 0;

        for (let i = 0; i < n; ++i) {
            curmax = 0;
            overlap = 0;
            vertical = 0;
            let mp = new Map();
            for (let j = i + 1; j < n; ++j) {
                if (x[i] == x[j] && y[i] == y[j]) {
                    overlap += 1;
                } else if (x[i] == x[j]) {
                    vertical += 1;
                } else {
                    let xdiff = x[j] - x[i];
                    let ydiff = y[j] - y[i];
                    let z = __gcd(xdiff, ydiff);
                    xdiff = Math.floor(xdiff / z);
                    ydiff = Math.floor(ydiff / z);
                    // mp stores the slope of the line between i-th and j-th point
                    mp[[xdiff, ydiff]] = (mp[[xdiff, ydiff]] || 0) + 1;
                    curmax = Math.max(curmax, (mp[[xdiff, ydiff]] || 0));
                }
                curmax = Math.max(curmax, vertical);
            }
            ans = Math.max(ans, curmax + overlap + 1);
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
int maxpointsonsameline(vector < int > & x, vector < int > & y) {
    int n = x.size();
    if (n < 3)
        return n;
    int ans = 0;

    int curmax = 0, overlap = 0, vertical = 0;
    map < pair < int, int > , int > mp;
    for (int i = 0; i < n; ++i) {
        curmax = 0, overlap = 0, vertical = 0;
        for (int j = i + 1; j < n; ++j) {
            if (x[i] == x[j] && y[i] == y[j])
                ++overlap;
            else if (x[i] == x[j])
                ++vertical;
            else {
                int xdiff = x[j] - x[i];
                int ydiff = y[j] - y[i];
                int z = __gcd(xdiff, ydiff);
                xdiff /= z;
                ydiff /= z;
                // mp stores the slope of the line between i-th and j-th point
                mp[{xdiff, ydiff}]++;
                curmax = max(curmax, mp[{xdiff, ydiff}]);
            }
            curmax = max(curmax, vertical);
        }
        mp.clear();
        ans = max(ans, curmax + overlap + 1);
    }
    return ans;
}

int Solution::solve(vector < int > & A, vector < int > & B) {
    return maxpointsonsameline(A, B);
}
```

