### Q4. Unique Paths III
#### Problem Description
```text
Given a matrix of integers A of size N x M . There are 4 types of squares in it:

    1. 1 represents the starting square.  There is exactly one starting square.
    2. 2 represents the ending square.  There is exactly one ending square.
    3. 0 represents empty squares we can walk over.
    4. -1 represents obstacles that we cannot walk over.

Find and return the number of 4-directional walks from the starting square to the ending 
square, that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.
```
#### Problem Constraints
```text
2 <= N * M <= 20
-1 <= A[i] <= 2
```
#### Input Format
```text
The first argument given is the integer matrix A.
```
#### Output Format
```text
Return the number of 4-directional walks from the starting square to the ending 
square, that walk over every non-obstacle square exactly once.
```
#### Example Input
```text
Input 1:
 A = [   [1, 0, 0, 0]
         [0, 0, 0, 0]
         [0, 0, 2, -1]   ]

Input 2:
 A = [   [0, 1]
         [2, 0]    ]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    We have the following two paths: 
    1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
    2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Explanation 1:
    Answer is evident here.
```
### Hints
* Hint 1
<div>
    <p>Think about the the brute force solution.</p>
    <p>At every square we have at most 4 directions to move So, the time complexity of 
    the brute force solution is O(4 <sup>N*M</sup>).</p>
</div>

```text
Think about the the brute force solution.

At every square we have at most 4 directions to move So, the time complexity of 
the brute force solution is O(4^(N*M)).
```
* Solution Approach
<div>
    <p>We can perform the dfs from the starting square and maintain a visited matrix 
    to walk every non-empty square exactly once.</p>
    <p>When we reach the ending square by visiting all the non-empty squares, increment 
    the answer.</p>
    <p>We can use backtracking technique to find all possible walks.</p>
    <p>Time complexity of the solution:    O(4 <sup>N*M</sup>) because at every 
    possible square we can move in 4 directions.</p>
    <p>This time complexity will give TLE but bad walks (walks which will not contribute 
    to the answer) tend to stuck quickly and run out of free squares which make this 
    solution to pass in the given input limits.</p></div>

```text
We can perform the dfs from the starting square and maintain a visited matrix to walk 
every non-empty square exactly once.

When we reach the ending square by visiting all the non-empty squares, increment the answer.

We can use backtracking technique to find all possible walks.

Time complexity of the solution: O(4^(N*M)) because at every possible square we 
can move in 4 directions.

This time complexity will give TLE but bad walks (walks which will not contribute to 
the answer) tend to stuck quickly and run out of free squares which make this solution 
to pass in the given input limits.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    int n, m, ans;
    int xx[] = new int[]{1, 0, 0, -1};
    int yy[] = new int[]{0, 1, -1, 0};

    boolean isV(int u, int v, int a[][]) {
        // checks if it is possible to walk over the square (u, v)
        return 0 <= u && u < n && 0 <= v && v < m && a[u][v] != -1;
    }

    void recur(int x, int y, int cnt, int a[][]) {
        if(a[x][y] == 2) {
            // checks if every non-obstacle square has been covered
            if(cnt == 0)    ans++;
            return;
        }
        a[x][y] = -1;
        // traverse all the directions
        for(int i = 0; i < 4; i++) {
            int u = x + xx[i];
            int v = y + yy[i];
            if(isV(u, v, a)) {
                recur(u, v, cnt - 1, a);
            }
        }
        a[x][y] = 0;
    }
    public int solve(int[][] a) {
        n = a.length;   m = a[0].length;
        ans = 0;
        int u = -1, v = -1, cnt = 0;
        // find starting point and count number of non-obstacle squares
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 1) {
                    u = i;    
                    v = j;
                } else if(a[i][j] == 0)
                    cnt++;
            }
        }
        // Ending square is also counted in cnt so pass cnt + 1
        recur(u, v, cnt + 1, a);
        return ans;
    }        
}
```
* * Solution in Javascript
```javascript
let n, m, ans;
let xx = [1, 0, 0, -1];
let yy = [0, 1, -1, 0];

function isV(u, v, A) {
    // checks if it is possible to walk over the square (u, v)
    return 0 <= u && u < n && 0 <= v && v < m && A[u][v] != -1;
}

function recur(x, y, cnt, A) {
    if (A[x][y] == 2) {
        // checks if every non-obstacle square has been covered
        if (cnt == 0) ans++;
        return;
    }
    A[x][y] = -1;
    // traverse all the directions
    for (let i = 0; i < 4; i++) {
        let u = x + xx[i];
        let v = y + yy[i];
        if (isV(u, v, A)) {
            recur(u, v, cnt - 1, A);
        }
    }
    A[x][y] = 0;
}

module.exports = {
    solve: function (A) {
        n = A.length;
        m = A[0].length;
        ans = 0;
        let u = -1, v = -1, cnt = 0;
        // find starting point and count number of non-obstacle squares
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    u = i;
                    v = j;
                } else if (A[i][j] == 0) cnt++;
            }
        }
        // Ending square is also counted in cnt so pass cnt + 1
        recur(u, v, cnt + 1, A);
        return ans;
    },
};
```
* * Solution in C++
```cpp
int n, m, ans;
int xx[4] = {1, 0, 0, -1};
int yy[4] = {0, 1, -1, 0};

bool isV(int u, int v, vector < vector < int > > A) {
    // checks if it is possible to walk over the square (u, v)
    return 0 <= u && u < n && 0 <= v && v < m && A[u][v] != -1;
}

void recursion(int x, int y, int cnt, vector < vector < int > > & A) {
    if (A[x][y] == 2) {
        // checks if every non-obstacle square has been covered
        if (cnt == 0) ans++;
        return;
    }
    A[x][y] = -1;
    // traverse all the directions
    for (int i = 0; i < 4; i++) {
        int u = x + xx[i];
        int v = y + yy[i];
        if (isV(u, v, A)) {
            recursion(u, v, cnt - 1, A);
        }
    }
    A[x][y] = 0;
}

int Solution::solve(vector < vector < int > > & A) {
    n = A.size();
    m = A[0].size();
    ans = 0;
    int u = -1, v = -1, cnt = 0;
    // find starting point and count number of non-obstacle squares
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (A[i][j] == 1) {
                u = i;
                v = j;
            } else if (A[i][j] == 0) 
                cnt++;
        }
    }
    // Ending square is also counted in cnt so pass cnt + 1
    recursion(u, v, cnt + 1, A);
    return ans;
}
```

