### Q1. Russian Doll Envelopes
#### Problem Description
```text
Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, 
where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width 
of the ith envelope.

One envelope can fit into another if and only if both the width and height of one 
envelope is greater than the width and height of the other envelope.

Find the maximum number of envelopes you can put one inside other.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 1000<br>
    1 &lt;= A[i][0], A[i][1] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 1000
1 <= A[i][0], A[i][1] <= 10^9
```
#### Input Format
```text
The only argument given is the integer matrix A.
```
#### Output Format
```text
Return an integer denoting the maximum number of envelopes you can put one inside other.
```
#### Example Input
```text
Input 1:
 A = [ 
         [5, 4]
         [6, 4]
         [6, 7]
         [2, 3]  
     ]

Input 2:
 A = [     '
         [8, 9]
         [8, 18]    
     ]
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
    Step 1: put [2, 3] inside [5, 4]
    Step 2: put [5, 4] inside [6, 7]
    3 envelopes can be put one inside other.

Explanation 2:
    No envelopes can be put inside any other so answer is 1.
```
### Hints
* Hint 1
```text
Think of finding longest longest increasing subsequence in 2-dimensional.
```
* Solution Approach
```text
This is the same question as longest increase sub sequance.
The only problem is how to trasnform this problem to it.
We just sort the envelopes by width, but when there are even case( two envelope with 
the same width) we should put the height in reverse order.

like (5,6), (5,8), we should put (5,8) before (5,6).

Now the problem reduces to finding the longest increasing subsequence.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[][] A) {
        ArrayList < Pair > v = new ArrayList < Pair > ();
        int n = A.length;
        for (int i = 0; i < n; i++)
            v.add(new Pair(A[i][0], -A[i][1]));
        Collections.sort(v);
        int[] dp = new int[n];
        dp[0] = 1;
        int maxe = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (v.get(j).ff < v.get(i).ff && v.get(j).ss > v.get(i).ss)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxe = Math.max(maxe, dp[i]);
        }
        return maxe;
    }
}
class Pair implements Comparable < Pair > {
    int ff;
    int ss;
    public Pair(int c, int d) {
        this.ff = c;
        this.ss = d;
    }
    @Override
    public int compareTo(Pair a) {
        return this.ff - a.ff;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of array of integers
    //return an integer
    solve: function (envelopes) {
        if (envelopes.length < 2) {
            return envelopes.length;
        }
        if (!envelopes || !envelopes[0]) {
            return 0;
        }
        envelopes.sort((env1, env2) => {
            if (env1[0] == env2[0]) {
                return env2[1] - env1[1];
            } else {
                return env1[0] - env2[0];
            }
        });
        let dp = new Array(envelopes.length).fill(1);
        let i, j, max = 1;
        for (i = 1; i < envelopes.length; i++) {
            //console.log(`doing ${i}, val: ${arr[i]}, dp: ${dp[i]}`);
            for (j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < vector < int > > & A) {
    vector < pair < int, int > > v;
    int n = A.size();
    for (int i = 0; i < n; i++)
        v.push_back({A[i][0], -A[i][1]});

    // sort the vector envelope in increasing order of heights
    sort(v.begin(), v.end());
    int dp[n];
    dp[0] = 1;

    //Find the longest increasing subsequence based on second element of v[i]
    for (int i = 1; i < n; i++) {
        dp[i] = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (v[j].first < v[i].first and v[j].second > v[i].second)
                dp[i] = max(dp[i], dp[j] + 1);
        }
    }
    return *max_element(dp, dp + n);
}
```

