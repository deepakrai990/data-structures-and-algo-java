### Q3. Valid Path
#### Problem Description
```text
There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move 
from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjacent neighbours and we cannot move 
outside the boundary of the rectangle at any point of time.
```
#### Problem Constraints
```text
0 <= x , y, R <= 100

1 <= N <= 1000

Center of each circle would lie within the grid
```
#### Input Format
```text
1st argument given is an Integer x , denoted by A in input.

2nd argument given is an Integer y, denoted by B in input.

3rd argument given is an Integer N, number of circles, denoted by C in input.

4th argument given is an Integer R, radius of each circle, denoted by D in input.

5th argument given is an Array A of size N, denoted by E in input, 
where A[i] = x coordinate of ith circle

6th argument given is an Array B of size N, denoted by F in input, 
where B[i] = y coordinate of ith circle
```
#### Output Format
```text
Return YES or NO depending on weather it is possible to reach cell (x,y) or not 
starting from (0,0).
```
#### Example Input
```text
Input 1:
 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]

Input 2:
 x = 1
 y = 1
 N = 1
 R = 1
 A = [1]
 B = [1]
```
#### Example Output
```text
Output 1:
 NO

Output 2:
 NO
```
#### Example Explanation
```text
Explanation 1:
    There is NO valid path in this case
Explanation 2:
    There is NO valid path in this case
```
### Hints
* Hint 1
```text
Focus on every single points inside the rectangle.
You can’t go to some points which lie inside any of the circle. So basically you know all the points where you can stand at.
Can you use this info to figure out a path between origin and destination.
Check if (i,j) is a valid point for all 0<=i<=x, 0<=j<=y. By valid point we mean that none of the circle should contain it.
```
* Solution Approach
```text
Check if (i,j) is a valid point for all 0<=i<=x, 0<=j<=y. By valid point we mean that none of the circle should contain it.

To do this you can simply check for all points (i,j) where 0<=i<=x, 0<=j<=y if there is a circle on which this point.
If a point lies on a circle it should satisfy that circle’s equation.((i-a)^2+(j-b)^2==r^2 where (a,b) is the centre of the circle and r is its radius)

Now you know all the valid point in rectangle. You need to figure out if you can go from (0,0) to (x,y) through valid points. This can be done with any graph traversal algorithms like BFS/DFS.

DFS ( i , j )
mark (i,j) as visited
for all (i’,j’) positions to where we can travel to from (i,j)
DFS(i’,j’)

Now we just have to check if (x,y) is visited or not. If it is visited then output YES otherwise NO.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int[] x = {1,1,1,-1,-1,-1,0,0};
    static int[] y = {-1,1,0,-1,1,0,1,-1};
    public String solve(int A, int B, int C, int D, ArrayList < Integer > E, ArrayList < Integer > F) {
        int[][] valid = new int[A + 1][B + 1];
        int n = C;
        int r = D;
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int z = 0; z < n; z++) {
                    if (Math.sqrt(Math.pow(E.get(z) - i, 2) + Math.pow(F.get(z) - j, 2)) <= r)
                        valid[i][j] = -1;
                }
            }
        }
        if (valid[0][0] == -1 || valid[A][B] == -1)
            return "NO";
        boolean[][] v = new boolean[A + 1][B + 1];
        v[0][0] = true;
        Queue < Integer > q = new LinkedList < Integer > ();
        q.add(0);
        q.add(0);
        while (!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();
            for (int z = 0; z < 8; z++) {
                int ix = i + x[z];
                int iy = j + y[z];
                if (!(ix < 0 || iy < 0 || ix >= A + 1 || iy >= B + 1) && !v[ix][iy] && valid[ix][iy] != -1) {
                    if (ix == A && iy == B) {
                        return "YES";
                    }
                    q.add(ix);
                    q.add(iy);
                    v[ix][iy] = true;
                }
            }
        }
        return "NO";
    }
}
```
* * Solution in Javascript
```javascript
function Queue() {
	var a = [],
		b = 0;
	this.getLength = function() {
		return a.length - b;
	};
	this.isEmpty = function() {
		return 0 == a.length;
	};
	this.enqueue = function(b) {
		a.push(b);
	};
	this.dequeue = function() {
		if (0 != a.length) {
			var c = a[b];
			2 * ++b >= a.length && ((a = a.slice(b)), (b = 0));
			return c;
		}
	};
	this.peek = function() {
		return 0 < a.length ? a[b] : void 0;
	};
}

const MAX = 105;
let mat;
let visited;
let max_x, max_y;

function dist(x, y, x1, y1, r) {
	if ((x - x1) * (x - x1) + (y - y1) * (y - y1) <= r * r) {
		return true;
	}
	return false;
}

function valid(x, y) {
	if (
		x >= 0 &&
		x <= max_x &&
		y >= 0 &&
		y <= max_y &&
		mat[x][y] == 0 &&
		visited[x][y] == 0
	) {
		return true;
	}
	return false;
}

module.exports = {
	solve: function(x, y, N, R, X_cord, Y_cord) {
		mat = new Array(MAX).fill(0).map(() => new Array(MAX).fill(0));
		visited = new Array(MAX).fill(0).map(() => new Array(MAX).fill(0));
		max_x = x;
		max_y = y;
		let v = [];
		for (let i = 0; i < N; i++) {
			v.push([X_cord[i], Y_cord[i]]);
		}
		for (let i = 0; i <= x + 1; i++) {
			for (let j = 0; j <= y + 1; j++) {
				let flag = true;
				for (let k = 0; k < N; k++) {
					if (dist(i, j, v[k][0], v[k][1], R)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					mat[i][j] = 0;
				} else {
					mat[i][j] = 1;
				}
			}
		}
		if (mat[0][0] == 1 || mat[x][y] == 1) {
			let ret = "NO";
			return ret;
		} else {
			visited[0][0] = 1;

			let q = new Queue();
			q.enqueue([0, 0]);
			let dest1 = x;
			let dest2 = y;
			while (!q.isEmpty()) {
				let p1 = q.dequeue();
				let x = p1[0];
				let y = p1[1];

				if (x == dest1 && y == dest2) {
					let ret = "YES";
					return ret;
				}
				if (valid(x - 1, y)) {
					visited[x - 1][y] = 1;
					q.enqueue([x - 1, y]);
				}
				if (valid(x, y - 1)) {
					visited[x][y - 1] = 1;
					q.enqueue([x, y - 1]);
				}
				if (valid(x + 1, y)) {
					visited[x + 1][y] = 1;
					q.enqueue([x + 1, y]);
				}
				if (valid(x, y + 1)) {
					visited[x][y + 1] = 1;
					q.enqueue([x, y + 1]);
				}
				if (valid(x + 1, y + 1)) {
					visited[x + 1][y + 1] = 1;
					q.enqueue([x + 1, y + 1]);
				}
				if (valid(x + 1, y - 1)) {
					visited[x + 1][y - 1] = 1;
					q.enqueue([x + 1, y - 1]);
				}
				if (valid(x - 1, y + 1)) {
					visited[x - 1][y + 1] = 1;
					q.enqueue([x - 1, y + 1]);
				}
				if (valid(x - 1, y - 1)) {
					visited[x - 1][y - 1] = 1;
					q.enqueue([x - 1, y - 1]);
				}
			}
			let ret = "NO";
			return ret;
		}
	},
};
```
* * Solution in C++
```cpp
#include <bits/stdc++.h>

#define MAX 105
int mat[MAX][MAX];
int visited[MAX][MAX];
int max_x, max_y;
bool dist(int x, int y, int x1, int y1, int r) {
    if ((x - x1) * (x - x1) + (y - y1) * (y - y1) <= r * r) {
        return true;
    }
    return false;
}
bool valid(int x, int y) {
    if (x >= 0 && x <= max_x && y >= 0 && y <= max_y && mat[x][y] == 0 && visited[x][y] == 0) {
        return true;
    }
    return false;
}

string Solution::solve(int x, int y, int N, int R, vector < int > & X_cord, vector < int > & Y_cord) {
    memset(mat, 0, sizeof(mat));
    memset(visited, 0, sizeof(visited));
    max_x = x;
    max_y = y;
    vector < pair < int, int > > v;
    for (int i = 0; i < N; i++) {
        v.push_back(make_pair(X_cord[i], Y_cord[i]));
    }
    for (int i = 0; i <= x + 1; i++) {
        for (int j = 0; j <= y + 1; j++) {
            bool flag = true;
            for (int k = 0; k < N; k++) {
                if (dist(i, j, v[k].first, v[k].second, R)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                mat[i][j] = 0;
            } else {
                mat[i][j] = 1;
            }
        }
    }
    if (mat[0][0] == 1 || mat[x][y] == 1) {
        string ret = "NO";
        return ret;
    } else {
        visited[0][0] = 1;
        queue < pair < int, int > > q;
        q.push(make_pair(0, 0));
        int dest1 = x;
        int dest2 = y;
        while (!q.empty()) {
            pair < int, int > p1 = q.front();
            q.pop();
            int x = p1.first;
            int y = p1.second;
            if (x == dest1 && y == dest2) {
                string ret = "YES";
                return ret;
            }
            if (valid(x - 1, y)) {
                visited[x - 1][y] = 1;
                q.push(make_pair(x - 1, y));
            }
            if (valid(x, y - 1)) {
                visited[x][y - 1] = 1;
                q.push(make_pair(x, y - 1));
            }
            if (valid(x + 1, y)) {
                visited[x + 1][y] = 1;
                q.push(make_pair(x + 1, y));
            }
            if (valid(x, y + 1)) {
                visited[x][y + 1] = 1;
                q.push(make_pair(x, y + 1));
            }
            if (valid(x + 1, y + 1)) {
                visited[x + 1][y + 1] = 1;
                q.push(make_pair(x + 1, y + 1));
            }
            if (valid(x + 1, y - 1)) {
                visited[x + 1][y - 1] = 1;
                q.push(make_pair(x + 1, y - 1));
            }
            if (valid(x - 1, y + 1)) {
                visited[x - 1][y + 1] = 1;
                q.push(make_pair(x - 1, y + 1));
            }
            if (valid(x - 1, y - 1)) {
                visited[x - 1][y - 1] = 1;
                q.push(make_pair(x - 1, y - 1));
            }
        }
        string ret = "NO";
        return ret;
    }
}
```

