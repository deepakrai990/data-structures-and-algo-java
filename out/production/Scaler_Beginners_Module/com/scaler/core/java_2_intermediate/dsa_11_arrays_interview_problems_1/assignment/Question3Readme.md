### Q3. Count Increasing Triplets
#### Problem Description
```text
You are given an array A of N elements. Find the number 
of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 10<sup>3</sup><br>
    1 &lt;= A[i] &lt;= 10<sup>9</sup>
</div>

```text
1 <= N <= 10^3
1 <= A[i] <= 10^9
```
#### Input Format
```text
First argument A is an array of integers.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 4, 3]

Input 2:
 A = [2, 1, 2, 3]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
For Input 1:
    The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].

For Input 2: 
    The triplet that satisfy the conditions is [1, 2, 3].
```
### Hints
* Hint 1
```text
We can consider every element to be the centre
of the triplet and try to find the number of 
triplets possible.
```
* Solution Approach
```text
For every A[i], we calculate no of elements A[j] 
such that A[j] < A[i] and j < i. 

Similarly, we also calculate the no of elements A[j] 
such that A[j] > A[i] and  j > i.

Now, the number of triplets with A[i] as the centre is the
product of the above two calculated values. 

We can get this count for all the elements and add their total.

Time Complexity : O(N^2)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int n = A.length , ans = 0;
        for(int i = 0 ; i < n ; i++){
            int l = 0 , r = 0;
            for(int j = 0 ; j < i ; j++){
                if(A[j] < A[i]){
                    l += 1;
                }
            }
            for(int j = i + 1 ; j < n ; j++){
                if(A[i] < A[j]){
                    r += 1;
                }
            }
            ans += (l * r);
        }
        return ans;
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
	int n = A.size() , ans = 0;
	for(int i = 0 ; i < n ; i++){
		int l = 0 , r = 0;
		for(int j = 0 ; j < i ; j++){
			if(A[j] < A[i]){
				l += 1;
			}
		}
		for(int j = i + 1 ; j < n ; j++){
			if(A[i] < A[j]){
				r += 1;
			}
		}
		ans += l * r;
	}
	return ans;
}
```

