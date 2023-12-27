### Q4. In-place Prefix Sum
#### Problem Description
```text
Given an array A of N integers. Construct prefix sum of the 
array in the given array itself.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    1 &lt;= A[i] &lt;= 10<sup>3</sup>
</div>

```text
1 <= N <= 10^5
1 <= A[i] <= 10^3
```
#### Input Format
```text
Only argument A is an array of integers.
```
#### Output Format
```text
Return an array of integers denoting the prefix sum of the given array.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]

Input 2:
 A = [4, 3, 2]
```
#### Example Output
```text
Output 1:
 [1, 3, 6, 10, 15]

Output 2:
 [4, 7, 9]
```
#### Example Explanation
```text
Explanation 1:
    The prefix sum array of [1, 2, 3, 4, 5] is [1, 3, 6, 10, 15].

Explanation 2:
    The prefix sum array of [4, 3, 2] is [4, 7, 9].
```
### Hints
* Hint 1
```text
This is an implementation problem that requires knowledge of 
loops and arrays.
```
* Solution Approach
```text
We will traverse from left to right of the array.

For the leftmost element, we leave it as it as, and  for the 
other elements we add to the element on the left to it. This will 
form the prefix sum array

Time Complexity : O(N)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A) {
        for(int i = 1 ; i < A.length ; i++){
            A[i] += A[i - 1];
        }
        return A;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
vector<int> Solution::solve(vector<int> &A) {
	for(int i = 1 ; i < A.size() ; i++){
		A[i] = A[i - 1] + A[i];
	}
	return A;
}

```

