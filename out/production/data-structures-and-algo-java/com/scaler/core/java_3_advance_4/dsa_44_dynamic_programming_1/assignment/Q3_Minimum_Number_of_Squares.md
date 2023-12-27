### Q3. Minimum Number of Squares
#### Problem Description
```text
Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= A <= 10^5
```
#### Input Format
```text
First and only argument is an integer A.
```
#### Output Format
```text
Return an integer denoting the minimum count.
```
#### Example Input
```text
Input 1:
 A = 6

Input 2:
 A = 5
```
#### Example Output
```text
Output 1:
 3

Output 2:
 2
```
#### Example Explanation
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Explanation 1:</p>
    <pre> Possible combinations are : (1<sup>2</sup> + 1<sup>2</sup> + 1<sup>2</sup> + 1<sup>2</sup> + 1<sup>2</sup> + 1<sup>2</sup>) and (1<sup>2</sup> + 1<sup>2</sup> + 2<sup>2</sup>).
    Minimum count of numbers, sum of whose squares is 6 is 3. 
    </pre>
    <p>Explanation 2:</p>
    <pre> We can represent 5 using only 2 numbers i.e. 1<sup>2</sup> + 2<sup>2</sup> = 5</pre>
</div>

### Hints
* Hint 1
```text
Don’t be greedy. Think of optimality with every possibility.

Take an example with N=12.
```
* Solution Approach
```text
It is always possible to represent a number N as sum of squares i.e.(1^1+1^1+1^1+…..+1^1, N times).
For optimality idea is simple take list of all perfect square numbers ≤ N(i.e. 1,4,9,16….). Now identify from which number we have to make a direct jump to N so that the required answer is minimised.

Take an example of 12 :
List of perfect square numbers ≤12 is 1,4,9.
11+1 = 12, 8+4 = 12, 3+9 = 12.
So to reach 12 we have 3 choices i.e. 11,8,3.

Similarly we will solve for these subproblems with base case as for N=0, ans=0 and for N=1, ans=1.

Hence we can write required recursion as follows :

If n <= 1, 
then return n 
Else
   countMinSquares(n) = min {1 + countMinSquares(n - i*i)} 
                       where i >= 1 and i*i <= n

We can easily transform this exponential solution to DP as below :

dp[0]=0,dp[1]=1; // base cases.
i : [2...N]
{
    dp[i]=i;
    for every x : x>=1 & x*x<=i
    {
        dp[i]=min(dp[i],1+dp[i-x*x]);
    }
}
Time Complexity : O(N*sqrt(N))
Space Complexity : O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int countMinSquares(int n) {
        int[] dp = new int[n + 1];

        // simple base case assignment
        dp[0] = 0;
        dp[1] = 1;

        //finding optimal answer for every 2<=i<=N in bottom-up manner
        for (int i = 2; i <= n; i++) {

            //for i answer will be always less than equal to i.
            //maximum possible number of squares : i = (1^1+1^1+1^1+.....+1^1, i times)
            dp[i] = i;

            //Now identify from which number we have to make a direct jump to N so that the required answer is minimised.
            //do this by considering every possible direct jump
            //number of iterations will be <= sqrt(i)
            for (int x = 1; x * x <= i; x++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - x * x]);
            }
        }

        //here we get our optimal answer
        return dp[n];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : integer
    //return an integer
    countMinSquares: function (n) {
        let dp = new Array(n + 1);
        // simple base case assignment
        dp[0] = 0;
        dp[1] = 1;

        //finding optimal answer for every 2<=i<=N in bottom-up manner
        for (let i = 2; i <= n; i++) {
            //for i answer will be always less than equal to i.
            //maximum possible number of squares : i = (1^1+1^1+1^1+.....+1^1, i times)
            dp[i] = i;

            //Now identify from which number we have to make a direct jump to N so that the required answer is minimised.
            //do this by considering every possible direct jump
            //number of iterations will be <= sqrt(i)
            for (let x = 1; x * x <= i; x++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - x * x]);
            }
        }
        //here we get our optimal answer
        return dp[n];
    },
};
```
* * Solution in C++
```cpp
int Solution::countMinSquares(int n) {
  int dp[n + 1];

  // simple base case assignment
  dp[0] = 0;
  dp[1] = 1;

  //finding optimal answer for every 2<=i<=N in bottom-up manner
  for (int i = 2; i <= n; i++) {

    //for i answer will be always less than equal to i.
    //maximum possible number of squares : i = (1^1+1^1+1^1+.....+1^1, i times)
    dp[i] = i;

    //Now identify from which number we have to make a direct jump to N so that the required answer is minimised.
    //do this by considering every possible direct jump
    //number of iterations will be <= sqrt(i)
    for (int x = 1; x * x <= i; x++) {
      dp[i] = min(dp[i], 1 + dp[i - x * x]);
    }
  }

  //here we get our optimal answer
  return dp[n];
}
 /*
Time Complexity : O(N*sqrt(N))
Space Complexity : O(N)
*/
```

