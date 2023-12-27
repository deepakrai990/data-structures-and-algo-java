### Q4. Max Sum Without Adjacent Elements
#### Problem Description
```text
Given a 2 x N grid of integer, A, choose numbers such that the sum of the 
numbers is maximum and no two chosen numbers are adjacent horizontally, vertically 
or diagonally, and return it.

Note: You can choose more than 2 numbers.
```
#### Problem Constraints
```text
1 <= N <= 20000
1 <= A[i] <= 2000
```
#### Input Format
```text
The first and the only argument of input contains a 2d matrix, A.
```
#### Output Format
```text
Return an integer, representing the maximum possible sum.
```
#### Example Input
```text
Input 1:
 A = [   
        [1]
        [2]    
     ]

Input 2:
 A = [   
        [1, 2, 3, 4]
        [2, 3, 4, 5]    
     ]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 8
```
#### Example Explanation
```text
Explanation 1:
    We will choose 2.

Explanation 2:
    We will choose 3 and 5.
```
### Hints
* Hint 1
```text
No two adjacent elements should be taken ( Adjacent is defined by horizontally, 
vertically, diagonally ).

so suppose we have 2 * N list :

1 |  2  |  3  | 4
2 |  3  |  4  | 5

Now suppose we choose 2, then we can't choose the element just above it 1, 
    the element next it 3, or the element diagonally opposite. 
In other words, if we are on (x, y), then if we choose (x, y), we can't choose
(x + 1, y), (x, y + 1) and (x + 1, y + 1). 

Can you implement a brute force for this using recursion using the above fact ? 
Can you memoize the bruteforce recursive solution ? 
```
* Solution Approach
```text
Continued from Hint1:

V : 
1 |  2  |  3  | 4
2 |  3  |  4  | 5

Lets first try to reduce it into a simpler problem. 
We know that within a column, we can choose at max 1 element. 
And choosing either of those elements is going to rule out choosing anything from the previous or next column. 
This means that choosing V[0][i] or V[1][i] has identical bearing on the elements which are ruled out. 
So, instead we replace each column with a single element which is the max of V[0][i], V[1][i].

Now we have the list as : 
2 3 4 5

Here we can see that we have reduced our problem into another simpler problem.
Now we want to find maximum sum of values where no 2 values are adjacent. 
Now our recurrence relation will depend only on position i and,
 a "include_current_element" which will denote whether we picked last element or not.

MAX_SUM(pos, include_current_element) = 
IF include_current_element = FALSE THEN   
    max ( MAX_SUM(pos - 1, FALSE) , MAX_SUM(pos - 1, TRUE) )

ELSE
    MAX_SUM(pos - 1, FALSE) + val(pos) 
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {

        int n;
        int dp[];
        ArrayList<Integer> first, second;
        first = A.get(0);
        second = A.get(1);

        n = A.get(0).size();

        if (n == 0)
            return 0;

        dp = new int[n];
        dp[0] = Math.max(first.get(0), second.get(0));

        if (n < 2)
            return dp[0];

        dp[1] = Math.max(first.get(1), second.get(1));
        dp[1] = Math.max(dp[0], dp[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(first.get(i), second.get(i));
            dp[i] += dp[i - 2];
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    adjacent: function (A) {
        let n = A[0].length;
        let choice = new Array(n);
        for (let i = 0; i < n; i++) {
            choice[i] = Math.max(A[0][i], A[1][i]);
        }
        if (n == 1) return choice[0];
        let dp = new Array(n);
        dp[0] = choice[0];
        dp[1] = Math.max(choice[0], choice[1]);

        for (let i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + choice[i], dp[i - 1]);
        }
        return dp[n - 1];
    },
};
```
* * Solution in C++
```cpp
int Solution::adjacent(vector < vector < int > > & V) {

  assert(V.size() == 2 && V.size() <= 20000);
  int N = V[0].size();

  int MAXSUM[N + 1][2];
  memset(MAXSUM, 0, sizeof(MAXSUM));

  int ele = max(V[0][0], V[1][0]);
  MAXSUM[0][1] = ele;
  for (int i = 1; i < N; i++) {

    // take the maximum of both the element in the current column.
    int cur_element = max(V[0][i], V[1][i]);

    // Case 1: Do not include current element.
    MAXSUM[i][0] = max(MAXSUM[i - 1][0], MAXSUM[i - 1][1]);

    // Case 2: Include current element
    MAXSUM[i][1] = cur_element + MAXSUM[i - 1][0];
  }
  return max(MAXSUM[N - 1][0], MAXSUM[N - 1][1]);
}
```

