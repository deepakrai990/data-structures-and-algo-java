### Q2. Longest Increasing Subsequence
#### Problem Description
```text
Find the longest increasing subsequence of a given array of integers, A.

In other words, find a subsequence of array in which the subsequence's elements are 
in strictly increasing order, and in which the subsequence is as long as possible.

In this case, return the length of the longest increasing subsequence.
```
#### Problem Constraints
```text
1 <= length(A) <= 2500
0 <= A[i] <= 2500
```
#### Input Format
```text
The first and the only argument is an integer array A.
```
#### Output Format
```text
Return an integer representing the length of the longest increasing subsequence.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 1, 5]

Input 2:
 A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
```
#### Example Output
```text
Output 1:
 3

Output 2:
 6
```
#### Example Explanation
```text
Explanation 1:
    The longest increasing subsequence: [1, 2, 5]

Explanation 2:
    The possible longest increasing 
    subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
```
### Hints
* Hint 1
<div>
    <p>Try to compute longest increasing subsequence ending at ith position for all i.</p>
    <p>Think how can you use answers ending on 1st, 2nd, 3rd, ….(i-1)th positions 
    for computing answers ending on ith position.</p>
    <p>Hint: Expected Complexity - O(N<sup>2</sup>)</p>
</div>

```text
Try to compute longest increasing subsequence ending at ith position for all i.

Think how can you use answers ending on 1st, 2nd, 3rd, ….(i-1)th positions for computing 
answers ending on ith position.

Hint: Expected Complexity - O(N^2)
```
* Solution Approach
<div>
    <p>Let dp[i] denotes 
    the length of longest increasing subsequence ending at index i with first i elements.</p>
    <p>How can we calculate dp[i], if we know dp[j] for all j &lt; i ?</p>
    <p>Just run a loop for 0&lt;=j&lt;=i-1, if A[j] &lt; A[i] Update dp[i] = max(dp[i], 1 + dp[j]).</p>
    <p>Fill all the dp states. Time complexity will be O(N<sup>2</sup>) as we are 
    running two loops one for i and one for j.</p>
    <p>Final answer = max(dp[i] for all i from 1 to N).</p>
    <p>Bonus: Try to solve in NlogN time complexity.</p>
</div>

```text
Let dp[i] denotes the length of longest increasing subsequence ending at 
index i with first i elements.

How can we calculate dp[i], if we know dp[j] for all j < i ?

Just run a loop for 0<=j<=i-1, if A[j] < A[i] Update dp[i] = max(dp[i], 1 + dp[j]).

Fill all the dp states. Time complexity will be O(N^2) as we are running two loops 
one for i and one for j.

Final answer = max(dp[i] for all i from 1 to N).

Bonus: Try to solve in NlogN time complexity.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int lis(final List < Integer > A) {
        if (A == null)
            return 0;
        int n = A.size();
        if (n == 0)
            return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j) && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, dp[i]);
        return res;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    lis: function (nums) {
        if (nums.length == 0) return 0;
        let dp = new Array(nums.length).fill(1);
        for (let i = 1; i < nums.length; i++) {
            for (let j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Math.max(...dp);
    }
};
```
* * Solution in C++
```cpp
class Solution {
    public:
        int lis(const vector < int > & V) {
            if (V.size() == 0) return 0;
            int longest[V.size() + 1];
            int maxLen = 1;
            memset(longest, 0, sizeof(longest));
            // longest[i] denotes the maximum length of increasing subsequence that ends 
            // with V[i].
            longest[0] = 1;
            for (int i = 1; i < V.size(); i++) {
                longest[i] = 1;
                // V[i] can only come after any V[j] such that V[j] < V[i].
                // We try appending V[i] after every such subsequence and update our 
                // longest[i]. 
                for (int j = 0; j < i; j++) {
                    if (V[j] < V[i]) longest[i] = max(longest[i], longest[j] + 1);
                }
                maxLen = max(maxLen, longest[i]);
            }
            return maxLen;
        }
};
```

