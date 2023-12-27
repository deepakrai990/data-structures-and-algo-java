### Q2. Shaggy and distances
#### Problem Description
```text
Shaggy has an array A consisting of N elements. We call a pair of 
distinct indices in that array a special if elements at those 
indices in the array are equal.

Shaggy wants you to find a special pair such that the distance 
between that pair is minimum. Distance between two indices 
is defined as |i-j|. If there is no special pair in 
the array, then return -1.
```
#### Problem Constraints
* <p>1 &lt;= |A| &lt;= 10<sup>5</sup></p>
```text
1 <= |A| <= 10^5
```
#### Input Format
```text
The first and only argument is an integer array A.
```
#### Output Format
```text
Return one integer corresponding to the minimum possible distance 
between a special pair.
```
#### Example Input
```text
Input 1:
 A = [7, 1, 3, 4, 1, 7]

Input 2:
 A = [1, 1]
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
    Here we have 2 options:
    1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
    2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
    Therefore the minimum possible distance is 3. 

Explanation 2:
    Only possibility is choosing A[1] and A[2].
```
### Hints
* Hint 1
```text
The constraints are not small enough for even a brute forces solution to work.
Can you do it by hashing?
```
* Solution Approach
```text
Idea behind this problem is to use hashing. 
Iterate over the the array and for each element if you found that 
element earlier also (i.e. stored in hash) then take the distance 
between them and update the hash with the current index.

Answer will be minimum of all distances

We are storing the most recent found index of each element because 
that will be the closest to the left of the next found index.

Time Complexity : O(N)

Space Complexity : O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        if (A.length == 1) {
            return -1;
        }
        // stores <Value, Index> pair
        HashMap < Integer, Integer > map = new HashMap < Integer, Integer > ();
        int result = A.length;
        for (int i = 0; i < A.length; i++) {
            // checks if A[i] has occurred previously
            if (map.containsKey(A[i])) {
                result = Math.min(result, i - map.get(A[i]));
            }
            map.put(A[i], i);
        }
        return (result == A.length) ? -1 : result;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    solve: function (A) {
        if (A.length == 1) {
            return -1;
        }
        let m = new Map();
        let result = A.length;
        for (let i = 0; i < A.length; i++) {
            // checks if A[i] has occurred previously
            if (m.has(A[i])) {
                result = Math.min(result, i - m.get(A[i]));
            }
            m.set(A[i], i);
        }
        return (result == A.length) ? -1 : result;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
	unordered_map<int, int> last;
	int mn = INT_MAX;
	for (int i = 0; i < A.size(); i++) {
	   // checks if A[i] has occurred previously
		if (last.find(A[i]) != last.end()) {
			mn = min(mn, abs(i - last[A[i]]));
		}
		last[A[i]] = i;
	}

	if (mn == INT_MAX) return -1;

	return mn;
}
```

