### Q4. Dungeon Princess
#### Problem Description
```text
The demons had captured the princess and imprisoned her in the bottom-right corner 
of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant 
knight was initially positioned in the top-left room and must fight his way through 
the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any 
point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses 
health (negative integers) upon entering these rooms; other rooms are either 
empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move 
only rightward or downward in each step.

Given a 2D array of integers A of size M x N. Find and return the knight's minimum 
initial health so that he is able to rescue the princess.
```
#### Problem Constraints
```text
1 <= M, N <= 500

-100 <= A[i] <= 100
```
#### Input Format
```text
First and only argument is a 2D integer array A denoting the grid of size M x N.
```
#### Output Format
```text
Return an integer denoting the knight's minimum initial health so that he is able to 
rescue the princess.
```
#### Example Input
```text
Input 1:
 A = [ 
       [-2, -3, 3],
       [-5, -10, 1],
       [10, 30, -5]
     ]

Input 2:
 A = [ 
       [1, -1, 0],
       [-1, 1, -1],
       [1, 0, -1]
     ]
```
#### Example Output
```text
Output 1:
 7

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
     Initially knight is at A[0][0].
     If he takes the path RIGHT -> RIGHT -> DOWN -> DOWN, the minimum health required 
     will be 7.
     At (0,0) he looses 2 health, so health becomes 5.
     At (0,1) he looses 3 health, so health becomes 2.
     At (0,2) he gains 3 health, so health becomes 5.
     At (1,2) he gains 1 health, so health becomes 6.
     At (2,2) he looses 5 health, so health becomes 1.
     At any point, the health point doesn't drop to 0 or below. So he can rescue the 
     princess with minimum health 7.
 
Explanation 2:
    Take the path DOWN -> DOWN ->RIGHT -> RIGHT, the minimum health required will be 1.
```
### Hints
* Hint 1
```text
Start from bottom right (not from top left).
Think of Dynamic programming.

Or think of the bruteforce solution and see if you can memoize.
```
* Solution Approach
```text
There are only 2 positions you can directly go to from i, j. (i+1, j) and (i, j + 1).

So if you knew the optimal path requirements for (i + 1, j) and (i, j + 1), you could 
choose the minimum of the two and be done with it.

Build the dp array, start from the bottom right cornor , let’s say hp[i][j] represents 
the min health point needed at position (i, j).

So, hp[i][j] = max(1, min(hp[i][j+1], hp[i+1][j]) - dungeaon[i][j])

The final answer value is stored at hp[0][0].
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    int dp[][];
    ArrayList<ArrayList<Integer>> A;
    int m, n;

    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        if (A == null)
            return 0;
        m = A.size();
        n = A.get(0).size();
        dp = new int[m][n];
        this.A = A;
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        rec(0, 0);
        if (dp[0][0] <= 0)
            return 1;
        return dp[0][0];
    }

    public int rec(int row, int col) {
        if (row == m - 1 && col == n - 1) {
            int num = A.get(row).get(col);
            if (num < 0)
                return 1 - num;
            else
                return 1;
        }
        if (dp[row][col] != -1)
            return dp[row][col];
        int max = Integer.MAX_VALUE;
        int num = A.get(row).get(col);
        if (isValid(row + 1, col)) {
            max = rec(row + 1, col);
            max -= num;
            max = Math.max(1, max);
        }
        if (isValid(row, col + 1)) {
            int temp = rec(row, col + 1);
            temp -= num;
            temp = Math.max(1, temp);
            max = Math.min(temp, max);
        }
        return dp[row][col] = max;
    }

    public boolean isValid(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n)
            return false;
        return true;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of array of integers
    //return an integer
    calculateMinimumHP: function (dungeon) {
        var scores = [],
            rows = dungeon.length,
            cols = dungeon[0].length;
        const getBestPathSoFar = function (acc, el) {
            if (acc.lowest >= 0)
                return (el.lowest >= 0 && el.score > acc.score) ? el : acc;
            if (el.lowest === acc.lowest)
                return (el.score > acc.score) ? el : acc;
            return el.lowest > acc.lowest ? el : acc;
        };

        /* Set up the top row. */
        scores[0] = [];
        let score = 0,
            lowest = Number.MAX_VALUE;
        for (let i = 0; i < cols; i++) {
            let d = dungeon[0][i];
            lowest = Math.min(lowest, d + score);
            scores[0][i] = [{
                score: d + score,
                lowest
            }];
            score += d;
        }

        /* Set up the left column. */
        score = scores[0][0][0].score, lowest = scores[0][0][0].lowest;
        for (let i = 1; i < rows; i++) {
            let d = dungeon[i][0];
            scores[i] = [];
            lowest = Math.min(lowest, d + score);
            scores[i][0] = [{
                score: d + score,
                lowest
            }];
            score += d;
        }

        /* Now everything in between. */
        for (let i = 1; i < rows; i++) {
            for (let j = 1; j < cols; j++) {
                /* 
                        The previous low point could be the final low point, OR high negative values closer 
                        to the goal could bring a new low.
                        With that in mind, retain the following paths:
                        - Highest negative (or any non-negative) value of lowest with highest score.
                        - Any paths with a higher score than that.
                */

                /* Find the best paths. */
                let d = dungeon[i][j];
                let paths = [...scores[i - 1][j], ...scores[i][j - 1]];
                paths = paths.map(el => ({
                    score: el.score + d,
                    lowest: Math.min(el.lowest, el.score + d)
                }));
                let bestPath = paths.reduce(getBestPathSoFar, paths[0]);
                paths = paths.filter(el => el.score > bestPath.score);
                let map = new Map();
                for (let i = 0; i < paths.length; i++) {
                    let item = map.get(paths[i].lowest);
                    if (item === undefined || item < paths[i].score)
                        item = paths[i].score;
                    map.set(paths[i].lowest, item);
                }
                paths = [bestPath];
                map.forEach((score, lowest) => {
                    paths.push({
                        score,
                        lowest
                    })
                });
                scores[i][j] = paths;
                // scores[i-1][j] = scores[i][j-1] = null;
            }
            scores[i - 1] = null;
        }

        /* Use the largest low score value to calculate HP needed. */
        let result = scores[rows - 1][cols - 1].reduce((acc, el) => acc < el.lowest ? el.lowest : acc, scores[rows - 1][cols - 1][0].lowest);
        return Math.max(1, 1 - result);
    }
};
```
* * Solution in C++
```cpp
int Solution::calculateMinimumHP(vector < vector < int > > & A) {
    int m = A.size();
    int n = A[0].size();
 
    int dp[m + 1][n + 1];
    dp[m - 1][n - 1] = max(1 - A[m - 1][n - 1], 1);
    int i, j;
    for (i = m - 2; i >= 0; i--) {
        dp[i][n - 1] = max(dp[i + 1][n - 1] - A[i][n - 1], 1);
    }
    for (j = n - 2; j >= 0; j--) {
        dp[m - 1][j] = max(dp[m - 1][j + 1] - A[m - 1][j], 1);
    }
    for (i = m - 2; i >= 0; i--) {
        for (j = n - 2; j >= 0; j--) {
            int dow, ri;
            dow = max(dp[i + 1][j] - A[i][j], 1);
            ri = max(dp[i][j + 1] - A[i][j], 1);
            dp[i][j] = min(dow, ri);
        }
    }
    return dp[0][0];
 
}
```

