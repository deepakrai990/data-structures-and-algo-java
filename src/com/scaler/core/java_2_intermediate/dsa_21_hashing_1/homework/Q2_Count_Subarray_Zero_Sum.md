### Q2. Count Subarray Zero Sum
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    Given an array <strong>A </strong>of <strong>N</strong> 
    integers.<br><br>Find the count of the subarrays in the 
    array which sums to zero. Since the answer can be very 
    large, return the remainder on dividing the result with
    10<sup>9</sup>+7
</div>

```text
Given an array A of N integers.

Find the count of the subarrays in the array which sums 
to zero. Since the answer can be very large, return the 
remainder on dividing the result with 10^9+7
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
 A = [1, -1, -2, 2]

Input 2:
 A = [-1, 2, -1]
```
#### Example Output
```text
Output 1:
 3

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].

Explanation 2:
    The subarray with zero sum is [-1, 2, -1].
```
### Hints
* Hint 1
```text
Lets try to reduce the problem to a much simpler problem. 
Lets say we have another array `sum` where 

  sum[i] = Sum of all elements from A[0] to A[i]

Note that in this array, sum of elements from A[i] to A[j] = Sum[j] - Sum[i-1]

We need to find j and i such that sum of elements from A[i] to A[j] = 0
 
 Or Sum[j] - Sum[i-1] = 0
 Or Sum[j] = Sum[i-1]

Now, the problem reduces to counting 2 indices i and j such that `sum[i] = sum[j]` 
How can you solve the above problem ? 
```
* Solution Approach
```text
Approach:

There are two steps:
1. Create cumulative sum array where ith index in this array 
   represents total sum from 1 to ith index element.

2. Iterate all elements of cumulative sum array and use hashing 
   to count two elements where value at i th index == value at 
   j th index but i != j.

3. IF element is not present in hash in fill hash table with 
   current element.


Time Complexity : O(N)
Space Complexity : O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        final int mod = (int)(1e9 + 7);
        HashMap<Long, Integer> pref = new HashMap<Long, Integer>();
        Long curr = 0L , ans = 0L;
        pref.put(0L, 1);
        for(int i = 0 ; i < A.length ; i++){
            curr += A[i];
            if(pref.containsKey(curr)){
                ans += pref.get(curr);
            }
            pref.put(curr, pref.getOrDefault(curr, 0) + 1);
        }
        return (int)(ans % mod);
    }
}
```
* * Solution in Javascript
```javascript
/** not available **/
```
* * Solution in C++
```cpp
const int mod = 1e9 + 7;
int Solution::solve(vector<int> &A) {
	long long curr = 0, ans = 0;
	unordered_map<long long,int> pref;
	pref[0] = 1;
	for(int i = 0 ; i < A.size() ; i++){
		curr += A[i];
		ans = (ans + pref[curr]) % mod;
		pref[curr] += 1;
	}
	return int(ans % mod);
}
```

