### Q4. Subarray in given range
#### Problem Description
```text
Given an array A of length N, return the subarray from B to C.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
    <p>0 &lt;= B &lt;= C &lt; N</p>
</div>

```text
1 <= N <= 10^5

1 <= A[i] <= 10^9

0 <= B <= C < N
```
#### Input Format
```text
The first argument A is an array of integers

The remaining argument B and C are integers.
```
#### Output Format
```text
Return a subarray
```
#### Example Input
```text
Input 1:
 A = [4, 3, 2, 6]
 B = 1
 C = 3

Input 2:
 A = [4, 2, 2]
 B = 0
 C = 1
```
#### Example Output
```text
Output 1:
 [3, 2, 6]

Output 2:
 [4, 2]
```
#### Example Explanation
```text
Explanation 1:
 The subarray of A from 1 to 3 is [3, 2, 6].

Explanation 2:
 The subarray of A from 0 to 1 is [4, 2].
```
### Hints
* Hint 1
```text
Just return the subarray from B to C.
```
* Solution Approach
```text
We return the subarray of A from B to C.
Time Complexity : O(N)
Space Complexity : O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A, int B, int C) {
        return Arrays.copyOfRange(A, B, C + 1);
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
vector<int> Solution::solve(vector<int> &A, int B, int C) {
    vector<int> ans;
	for(int i = B ; i <= C ; i++){
		ans.push_back(A[i]);
	}
	return ans;
}
```

