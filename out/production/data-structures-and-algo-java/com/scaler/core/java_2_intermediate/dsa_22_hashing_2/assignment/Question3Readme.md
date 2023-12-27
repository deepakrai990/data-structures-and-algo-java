### Q3. Longest Subarray Zero Sum
#### Problem Description
```text
Given an array A of N integers.

Find the length of the longest subarray in the array which sums to zero.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    -10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup>
</div>

```text
1 <= N <= 10^5
-10^9 <= A[i] <= 10^9
```
#### Input Format
```text
Single argument which is an integer array A.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = [1, -2, 1, 2]

Input 2:
 A = [3, 2, -1]
```
#### Example Output
```text
Output 1:
 3

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    [1, -2, 1] is the largest subarray which sums up to 0.

Explanation 2:
    No subarray sums up to 0.
```
### Hints
* Hint 1
```text
Lets try to reduce the problem to a much simpler problem. 
Lets say we have another array `sum` where 


  sum[i] = Sum of all elements from A[0] to A[i]


Note that in this array, sum of elements from A[i] 
to A[j] = Sum[j] - Sum[i-1]


We need to find j and i such that sum of elements 
from A[i] to A[j] = 0
 Or Sum[j] - Sum[i-1] = 0
 Or Sum[j] = Sum[i-1]


Now, the problem reduces to finding 2 indices i and j such 
that `sum[i] = sum[j]` 

How can you solve the above problem ? 
```
* Solution Approach
```text
Approach:

There are two steps:

    1. Create cumulative sum array where ith index in this 
       array represents total sum from 1 to ith index element.
    
    2. Iterate all elements of cumulative sum array and use 
        hashing to find two elements where value at i th 
        index == value at jth index but i != j.
    
    3. IF element is not present in hash in fill hash table 
       with current element.


Time Complexity : O(N)
Space Complexity : O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        HashMap<Long, Integer> pref = new HashMap<Long, Integer>();
        Long curr = 0L;
        int ans = 0;
        pref.put(0L, 0);
        for(int i = 1 ; i <= A.length ; i++){
            curr += A[i - 1];
            if(pref.containsKey(curr)){
                ans = Math.max(ans, i - pref.get(curr));
            }
            else{
                pref.put(curr, i);
            }
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
    long long curr = 0;
	unordered_map<long long,int> pref;
	int ans = 0;
	pref[0] = 0;
	for(int i = 1 ; i <= A.size() ; i++){
		curr += A[i - 1];
		if(pref.find(curr) == pref.end()){
			pref[curr] = i;
		}
		else{
			ans = max(ans , i - pref[curr]);
		}
	}
	return ans;
}
```

