### Q6. Pick from both sides!
#### Problem Description
```text
You are given an integer array A of size N.

You have to perform B operations. In one operation, you can remove 
either the leftmost or the rightmost element of the array A.

Find and return the maximum possible sum of the elements that were 
removed after B operations.

NOTE: Suppose B = 4, and array A contains 10 elements, then

    * You can remove the first four elements or can remove the last four 
      elements, or can remove 1 from front and 3 from the back, etc. You 
      need to return the maximum possible sum of elements you can remove.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= B &lt;= N</p>
    <p>-10<sup>3</sup> &lt;= A[i] &lt;= 10<sup>3</sup></p>
</div>

```text
1 <= N <= 10^5

1 <= B <= N

-10^3 <= A[i] <= 10^3
```
#### Input Format
```text
First argument is an integer array A.

Second argument is an integer B.
```
#### Output Format
```text
Return an integer denoting the maximum possible sum of elements you removed.
```
#### Example Input
```text
Input 1:
 A = [5, -2, 3 , 1, 2]
 B = 3

Input 2:
 A = [ 2, 3, -1, 4, 2, 1 ]
 B = 4
```
#### Example Output
```text
Output 1:
 8

Output 2:
 9
```
#### Example Explanation
```text
Explanation 1:
    Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8

Explanation 2:
    Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9
```
### Hints
* Hint 1
```text
Try to use prefix and suffix sum arrays to solve the problem. You 
can try to pick one by one from the left and then use the suffix 
array to pick from the right.
```
* Solution Approach
```text
Approach using Prefix and Suffix Sums:

Maintain two arrays prefix[i] and suffix[i] where prefix[i] denotes 
sum of elements from index [0,i] and suffix[i] denotes sum of 
elements from index [i,N-1].

Now iterate from left and one by one pick elements from left for 
example: if you pick ‘a’ elements from left and 
remaining ‘k-a’ elements from right.

So the sum in this case will be prefix[a-1] + suffix[n-(k-a)]

Maintain the maximum among all and return it.

Time Complexity: O(N)
Space Complexity: O(N)

where N is number of elements in array A

Bonus: Try solving it in O(1) space.
```
* Complete Solution
* * Solution in Java
```java
/** Method 1: **/

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int[] suff = new int[n + 1];
        suff[n] = 0;
        suff[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = A[i] + suff[i + 1];
        }
        int pref_sum = 0;
        int ans = suff[n - B];
        for (int i = 0; i < B; i++) {
            pref_sum = pref_sum + A[i];
            int suff_sum = suff[n - B + (i + 1)];
            ans = Math.max(ans, pref_sum + suff_sum);
        }
        return ans;
    }
}

/** Method 2: **/

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int cur = 0;
        for (int i = 0; i < B; i++) {
            cur += A[i];
        }
        int back = B - 1;
        int ans = cur;
        for (int j = n - 1; j >= n - B; j--) {
            cur += A[j];
            cur -= A[back];
            back--;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
	//param A : array of integers
	//param B : integer
	//return an integer
	solve: function(A, B) {
		let sum = 0, ans = 0;
		for (let i = 0; i < B; i++)
			sum += A[i];
		ans = sum;
		let ri = A.length - 1,
			le = B - 1;
		while (le >= 0) {
			sum -= A[le];
			sum += A[ri];
			ans = Math.max(ans, sum);
			le--;
			ri--;
		}
		return ans;
	}
};
```
* * Solution in C++
```cpp
/** Method 1: **/

int Solution::solve(vector < int > & A, int B) {
    int n = A.size();
    int suff[n + 1];
    suff[n] = 0;
    suff[n - 1] = A[n - 1];
    for (int i = n - 2; i >= 0; i--)
        suff[i] = A[i] + suff[i + 1];
    int prefSum = 0;
    int ans = suff[n - B]; // All of the B elements are picked from the right end of the array
    for (int i = 0; i < B; i++) {
        prefSum = prefSum + A[i]; //Elements picked from the left end of the array
        int suffSum = suff[n - B + (i + 1)]; //Elements picked from the right end of the array
        ans = max(ans, prefSum + suffSum);
    }
    return ans;
}

/** Method 2: **/

int Solution::solve(vector<int> &A, int B) {
    int n = A.size();
    int cur = 0;
    int ans = -1e9;
    for(int i = 0; i < B; i++){
        cur += A[i];
    }
    int back = B - 1; 
    ans = max(ans, cur);      
    for(int j = n-1; j >= n-B; j--){
        cur += A[j];
        cur -= A[back];
        back--;
        ans = max(ans, cur);
    }
    return ans;
}
```

