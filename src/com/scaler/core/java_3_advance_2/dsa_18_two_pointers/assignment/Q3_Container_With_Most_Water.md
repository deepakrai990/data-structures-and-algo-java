### Q3. Container With Most Water
#### Problem Description
```text
Given n non-negative integers A[0], A[1], ..., A[n-1] , where 
each represents a point at coordinate (i, A[i]).

N vertical lines are drawn such that the two endpoints of 
line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a 
container, such that the container contains the most water.

Note: You may not slant the container.
```
#### Problem Constraints
* <p>0 &lt;= N &lt;= 10<sup>5</sup></p>
* <p> 1 &lt;= A[i] &lt;= 10<sup>5</sup></p>
```text
0 <= N <= 10^5

1 <= A[i] <= 10^5
```
#### Input Format
```text
Single Argument representing a 1-D array A.
```
#### Output Format
```text
Return single Integer denoting the maximum area you can obtain.
```
#### Example Input
```text
Input 1:
 A = [1, 5, 4, 3]

Input 2:
 A = [1]
```
#### Example Output
```text
Output 1:
 6

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    5 and 3 are distance 2 apart. So size of the base = 2. Height 
    of container = min(5, 3) = 3. 
    So total area = 3 * 2 = 6

Explanation 2:
    No container is formed.
```
### Hints
* Hint 1
```text
Area will be basically min(ai,aj)*(j-i) where j>i.

Approach 1 (in direction of O(n)) :
Will the area be maximum if you take j-i to be maximum. If not, then 
can you reduce the problem to simpler set?

Approach 2 (in direction of O(n log n)) :
Sort the elements with their indexes in descending order. Start iterating 
from first position of sorted array while maintaining 
the maximum of answer. How?
```
* Solution Approach
```text
Description of approach 1:

Note 1: When you consider a1 and aN, then the area is (N-1) * min(a1, aN).
Note 2: The base (N-1) is the maximum possible.
This implies that if there was a better solution possible, it will 
definitely have height greater than min(a1, aN).

B * H > (N-1) * min(a1, aN)
We know that, B < (N-1)
So, H > min(a1, aN)

This means that we can discard min(a1, aN) from our set and look to 
solve this problem again from the start.

If a1 < aN, then the problem reduces to solving the same thing for a2, aN.
Else, it reduces to solving the same thing for a1, aN-1
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int maxArea(ArrayList < Integer > A) {
        if (A == null)
            return 0;
        int n = A.size();
        int first = 0;
        int last = n - 1;
        int area = 0;
        while (first < last) {
            int width = last - first;
            // finds the area for the current window
            area = Math.max(area, Math.min(A.get(first), A.get(last)) * width);
            if (A.get(first).intValue() >= A.get(last).intValue())
                last--;
            else
                first++;
        }
        return area;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    maxArea: function (A) {
        let end = A.length - 1, start = 0;
        let maxVol = 0;
        while (start < end) {
            // finds the area for the current window
            maxVol = Math.max(maxVol, (end - start) * Math.min(A[start], A[end]));
            if (A[start] < A[end]) start++;
            else end--;
        }
        return maxVol;
    },
};
```
* * Solution in C++
```cpp
int Solution::maxArea(vector < int > & A) {
    
    vector < int > height;
    height = A;
    int end = height.size() - 1, start = 0;
    int max_area = 0;
    
    while (start < end) {
        // finds the area for the current window
        max_area = max(max_area, (end - start) * min(height[start], height[end]));
        if (height[start] < height[end]) {
            start++;
        } else {
            end--;
        }
    }
    return max_area;
}

```

