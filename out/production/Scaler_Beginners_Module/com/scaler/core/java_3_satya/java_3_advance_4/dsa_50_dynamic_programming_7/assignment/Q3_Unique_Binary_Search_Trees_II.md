### Q3. Unique Binary Search Trees II
#### Problem Description
```text
Given an integer A, how many structurally unique BST's (binary search trees) exist that 
can store values 1...A?
```
#### Problem Constraints
```text
1 <= A <=18
```
#### Input Format
```text
First and only argument is the integer A
```
#### Output Format
```text
Return a single integer, the answer to the problem
```
#### Example Input
```text
Input 1:
 1

Input 2:
 2
```
#### Example Output
```text
Output 1:
 1

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    Only single node tree is possible.

Explanation 2:
    2 trees are possible, one rooted at 1 and other rooted at 2.
```
### Hints
* Hint 1
```text
Can you compute the answer for A = n if you know the answer for A = 1, A = 2, … A = n-1 ?

What values can you place at root first and how will it affect the answer? 
Try to think of DP.
```
* Solution Approach
```text
Lets say you know the answer for values i which ranges from 0 <= i <= n - 1.
How do you calculate the answer for n.

Lets consider the number [1, n]
We have n options of choosing the root.

If we choose the number j as the root, j - 1 numbers fall in the 
left subtree, n - j numbers fall in the right subtree. We already know how many ways 
there are to forming j - 1 trees using j - 1 numbers and n -j numbers.

So we add number(j - 1) * number(n - j) to our solution.

Can you use the above fact to construct a DP relation ?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private long[][] dp;
    private int A;

    public int numTrees(int A) {
        dp = new long[A][A];
        for (int i = 0; i < A; i++)
            Arrays.fill(dp[i], -1);
        this.A = A;
        return (int) rec(0, A - 1);
    }

    public long rec(int i, int j) {
        if (i < 0 || j < 0 || i >= A || j >= A)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i >= j)
            return dp[i][j] = 1;
        dp[i][j] = 0;
        for (int k = i; k <= j; k++) {
            dp[i][j] += (rec(i, k - 1) * rec(k + 1, j));
        }
        return dp[i][j];
    }

}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : integer
    //return an integer
    numTrees: function (a) {
        let res = 1,
            f = 1;
        let n = 2 * a,
            i;
        for (let i = 0; i < a; i++) {
            res *= (n - i);
            res = Math.floor(res / (i + 1));
        }
        //if(f)
        res = Math.floor((res) / (a + 1));
        return res;
    }
};
```
* * Solution in C++
```cpp
class Solution {
    public:
        int numTrees(int n) {
            if (n == 0)
                return 1;
            if (n == 1)
                return 1;
            int result[n + 1];
            memset(result, 0, sizeof(result));
            result[0] = 1;
            result[1] = 1;
            if (n < 2) {
                return result[n];
            }
            for (int i = 2; i <= n; i++) {
                for (int k = 1; k <= i; k++) {
                    result[i] = result[i] + result[k - 1] * result[i - k];
                }
            }
            return result[n];
        }
};
```

