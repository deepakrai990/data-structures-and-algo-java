### Q3. Palindrome Partitioning II
#### Problem Description
```text
Given a string A, partition A such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of A.
```
#### Problem Constraints
```text
1 <= length(A) <= 501
```
#### Input Format
```text
The first and the only argument contains the string A.
```
#### Output Format
```text
Return an integer, representing the minimum cuts needed.
```
#### Example Input
```text
Input 1:
 A = "aba"

Input 2:
 A = "aab"
```
#### Example Output
```text
Output 1:
 0

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    "aba" is already a palindrome, so no cuts are needed.

Explanation 2:
    Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
```
### Hints
* Hint 1
```text
You can try to see, the problem has overlapping subproblems and optimal substructure,
so you can try to think in terms of DP.
If we know the optimal number of partitions till the index i,
how can we use it to compute the result for the upcoming indexes?
```
* Solution Approach
```text
Our first task is to find for each (i,j) if the substring from i to j is a palindrome or not.

How can we do this?

If substring from i to j is a palindrome then the following two conditions should satisfy

–> then the substring from i+1 to j-1 should be a palindrome
–> A(i)==A(j) i.e. i’th and j’th character of string A should be equal.

If you observe closely the substring (i,j) might be executed multiple times. Therefore 
we can use a dp to ensure that we dont compute the same thing again and again.

Lets take an array palin[n][n] where

palin[i][j]=1 if the substring from i to j is 1
palin[i][j]=0 otherwise

What would be our dp state?

palin[i][j]=(palin[i+1][j-1]&(A[i]==A[j]));

initial conditions

palin[i][j]=1

But this only gives tells us whether substring from i to j is a palindrome or not. How 
do we find the minimum number of partitions?

We use dp.

Lets say dp[i] is the minimum number of partitions for string from 0 to i.

Initial conditions

dp[i]=0 ,if palin[0][i] is 1
dp[i]=INT_MAX ,otherwise

Dp states

dp[j]=min(dp[j],dp[i-1]+1) (where i<=j0 and palin[i][j]=1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private int isPalin[][];
    private int dp[];
    private int N;
    private String A;
    
    public int minCut(String A) {
        N = A.length();
        isPalin = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(isPalin[i], -1);
        this.A = A;
        palindromeDP(0, N - 1);
        dp = new int[N];
        Arrays.fill(dp, -1);
        return minCuts(N - 1) - 1;
    }

    public int minCuts(int index) {
        if (index < 0)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int minSteps = 99999999;
        for (int i = index; i >= 0; i--) {
            if (isPalin[i][index] == 1) {
                minSteps = Math.min(minSteps, minCuts(i - 1) + 1);
            }
        }
        return dp[index] = minSteps;
    }

    public void palindromeDP(int begin, int end) {
        for (int l = 0; l < N; l++) {
            for (int i = 0; i < N - l; i++) {
                int j = i + l;
                if (i == j) {
                    isPalin[i][j] = 1;
                    continue;
                }
                if (A.charAt(i) == A.charAt(j)) {
                    if (i + 1 <= j - 1)
                        isPalin[i][j] = isPalin[i + 1][j - 1];
                    else
                        isPalin[i][j] = 1;
                } else {
                    isPalin[i][j] = 0;
                }
            }
        }
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //return an integer
    minCut: function (s) {
        var rootOdd = {
            len: -1,
            succeed: {}
        }
        var rootEven = {
            len: 0,
            succeed: {},
            fail: rootOdd
        }
        var minLens = new Array(s.length + 1);
        var node = rootEven;

        function getLastSucceed(node, i) {
            while (node != rootOdd) {
                if (s[i] == s[i - node.len - 1]) {
                    break;
                }
                node = node.fail;
            }
            return node;
        }

        function getLastFail(parent, i) {
            if (parent == rootOdd) {
                return rootEven;
            }
            while (true) {
                parent = parent.fail;
                if (s[i] == s[i - parent.len - 1]) {
                    return parent.succeed[s[i]];
                }
            }
        }

        function findMinPre(node, i) {
            let min = Infinity;
            let minPre;
            while (node.len > 0) {
                let tmp = minLens[i - node.len];
                if (tmp < min) {
                    minPre = i - node.len;
                    min = tmp;
                }
                node = node.fail;
            }
            return minPre;
        }
        minLens[0] = 0;
        for (let i = 0; i < s.length; i++) {
            node = getLastSucceed(node, i);
            node = node.succeed[s[i]] = {
                len: node.len + 2,
                succeed: {},
                fail: getLastFail(node, i)
            };
            minLens[i + 1] = minLens[findMinPre(node, i + 1)] + 1;
        }
        return minLens[s.length] - 1;
    }
};
```
* * Solution in C++
```cpp
int Solution::minCut(string A) {
    int n=A.size();
    int dp[n],palin[n][n];
    // palin[i][j] represents if the substring [i,j] of s is a palindrome or not.
    // dp[i] represents the minimum number of partitions required for substring [0,i].
    memset(palin,0,sizeof palin);
    for(int i=1;i<=n;i++)
    {
        for(int j=0;j<n;j++)
        {
            int l=j,r=j+i-1;
            if(i==1) palin[l][l]=1;
            else if(i==2 && j+1<n) palin[l][r]=(A[l]==A[r]);
            else if(r<n)
            {
                if(palin[l+1][r-1] && A[l]==A[r])
                {
                    palin[l][r]=1;
                }
            }
        }
    }
    for(int i=0;i<n;i++) dp[i]=INT_MAX;
    for(int i=0;i<n;i++)
    {
        for(int j=i;j<n;j++)
        {
            if(i==0)
            {
                if(palin[i][j]) dp[j]=0;
            }
            else
            {
                if(palin[i][j])
                {
                    dp[j]=min(dp[j],dp[i-1]+1);
                }
            }
        }
    }
    return dp[n-1];
}
```

