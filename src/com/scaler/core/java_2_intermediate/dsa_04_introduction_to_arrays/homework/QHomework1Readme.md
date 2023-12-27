### Q1. Max Min of an Array
#### Problem Description
```text
Given an array A of size N. You need to find the sum of Maximum 
and Minimum element in the given array.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    -10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup>
</div>

```text
1 <= N <= 10^5
-10^9 <= A[i] <= 10^9
```
#### Input Format
```text
First argument A is an integer array.
```
#### Output Format
```text
Return the sum of maximum and minimum element of the array
```
#### Example Input
```text
Input 1:
 A = [-2, 1, -4, 5, 3]

Input 2:
 A = [1, 3, 4, 1]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 5
```
#### Example Explanation
```text
Explanation 1:
    Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1. 

Explanation 2:
    Maximum Element is 4 and Minimum element is 1. (4 + 1) = 5.
```
### Hints
* Hint 1
```text
How can we find the maximum and minimum element of
the array ?
```
* Solution Approach
```text
We can loop through the array and find the maximum and minimum
element of the array. 

Finally, we return the sum of the above two elements

Time Complexity : O(N)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        final int inf = (int)(1e9);
        int mn = inf , mx = -inf;
        for(int i = 0 ; i < A.length ; i++){
            mn = Math.min(mn , A[i]);
            mx = Math.max(mx , A[i]);
        }
        return mn + mx;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
    int mn = *min_element(A.begin(), A.end());
	int mx = *max_element(A.begin(), A.end());
	return mn + mx;
}
```

