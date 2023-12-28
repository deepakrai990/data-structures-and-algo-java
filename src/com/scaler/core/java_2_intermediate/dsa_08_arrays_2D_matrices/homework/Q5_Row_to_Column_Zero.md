### Q5. Row to Column Zero
#### Problem Description
```text
You are given a 2D integer matrix A, make all the elements in a row or 
column zero if the A[i][j] = 0. Specifically, make entire i th row 
and jth column zero.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A.size() &lt;= 10<sup>3</sup></p>
    <p>1 &lt;= A[i].size() &lt;= 10<sup>3</sup></p>
    <p>0 &lt;= A[i][j] &lt;= 10<sup>3</sup></p>
</div>

```text
1 <= A.size() <= 10^3

1 <= A[i].size() <= 10^3

0 <= A[i][j] <= 10^3
```
#### Input Format
```text
First argument is a vector of vector of integers.(2D matrix).
```
#### Output Format
```text
Return a vector of vector after doing required operations.
```
#### Example Input
```text
Input 1:
    [1,2,3,4]
    [5,6,7,0]
    [9,2,0,4]
```
#### Example Output
```text
Output 1:
    [1,2,0,0]
    [0,0,0,0]
    [0,0,0,0]
```
#### Example Explanation
```text
Explanation 1:
    A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column 
    and 4th column zero.
```
### Hints
* Hint 1
```text
If you start row wise and make one row completely zero if it has 0 then 
you will loose information for making columns zero. 

None element is negative so see if you may use this for not loosing infos. 
```
* Solution Approach
```text
Let's start row wise first. Select rows one by one and make all the 
elements of that row -1 except which are 0, if any element in 
that row is 0. Similarly you have to do the same thing for columns.

Now, before returning traverse the matrix and make all the -1 elements 0.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[][] solve(int[][] A) {
        int n = A.length, m = A[0].length;
        for (int i = 0; i < n; i++) {
            int flag = 0;
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) flag = 1;
            }
            if (flag == 1) {
                for (int j = 0; j < m; j++) {
                    if (A[i][j] != 0) A[i][j] = -1;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            int flag = 0;
            for (int i = 0; i < n; i++) {
                if (A[i][j] == 0) flag = 1;
            }
            if (flag == 1) {
                for (int i = 0; i < n; i++) {
                    if (A[i][j] != 0) A[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == -1) A[i][j] = 0;
            }
        }
        return A;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of array of integers
    //return a array of array of integers
    solve: function (A) {
        let n = A.length, m = A[0].length;
        for (let i = 0; i < n; i++) {
            let flag = 0;
            for (let j = 0; j < m; j++) {
                if (A[i][j] == 0) flag = 1;
            }
            if (flag == 1) {
                for (let j = 0; j < m; j++) {
                    if (A[i][j] != 0) A[i][j] = -1;
                }
            }
        }
        for (let j = 0; j < m; j++) {
            let flag = 0;
            for (let i = 0; i < n; i++) {
                if (A[i][j] == 0) flag = 1;
            }
            if (flag == 1) {
                for (let i = 0; i < n; i++) {
                    if (A[i][j] != 0) A[i][j] = -1;
                }
            }
        }
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < m; j++) {
                if (A[i][j] == -1) A[i][j] = 0;
            }
        }
        return A;
    }
};
```
* * Solution in C++
```cpp
vector<vector<int> > Solution::solve(vector<vector<int> > &A) {
    int n = A.size(), m = A[0].size();
	for(int i = 0; i < n; i++) {
		int flag = 0;
		for(int j = 0; j < m; j++) {
			if(A[i][j]==0)flag = 1;
		}
		if(flag == 1) {
			for(int j = 0; j < m; j++) {
				if(A[i][j] != 0) A[i][j] = -1;
			}
		}
	}
	for(int j = 0; j < m; j++) {
		int flag = 0;
		for(int i = 0; i < n; i++) {
			if(A[i][j]==0)flag = 1;
		}
		if(flag == 1) {
			for(int i = 0; i < n; i++) {
				if(A[i][j] != 0) A[i][j] = -1;
			}
		}
	}
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < m; j++) {
			if(A[i][j] == -1)A[i][j] = 0;
		}
	}
	return A;
}
```

