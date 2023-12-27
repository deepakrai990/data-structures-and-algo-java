### Q3. Reverse in a range
#### Problem Description
```text
Given an array A of N integers. Also given are two 
integers B and C. Reverse the array A in the 
given range [B, C]
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
    <p>0 &lt;= B &lt;= C &lt;= N - 1</p>
</div>

```text
1 <= N <= 10^5
1 <= A[i] <= 10^9
0 <= B <= C <= N - 1
```
#### Input Format
```text
The first argument A is an array of integer.
The second and third arguments are integers B and C
```
#### Output Format
```text
Return the array A after reversing in the given range.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4]
 B = 2
 C = 3

Input 2: 
 A = [2, 5, 6]
 B = 0
 C = 2
```
#### Example Output
```text
Output 1:
 [1, 2, 4, 3]

Output 2:
 [6, 5, 2]
```
#### Example Explanation
```text
Explanation 1:
    We reverse the subarray [3, 4].

Explanation 2:
    We reverse the entire array [2, 5, 6].
```
### Hints
* Hint 1
```text
We need to reverse the subarray [A[B], A[B + 1] ... , A[C]].
```
* Solution Approach
```text
We can initialise two variable i and j with B and C.
We will iterate till i < j, swapping A[i] and A[j]
in every step and then incrementing i and decrementing j.

Time Complexity : O(N)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A, int B, int C) {
        int i = B , j = C;
        while(i < j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i += 1;
            j -= 1;
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
vector<int> Solution::solve(vector<int> &A, int B, int C) {
    int i = B , j = C;
	while(i < j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		i += 1;
		j -= 1;
	}
	return A;
}
```

