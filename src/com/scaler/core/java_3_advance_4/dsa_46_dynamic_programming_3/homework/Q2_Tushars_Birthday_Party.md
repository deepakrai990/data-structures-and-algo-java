### Q2. Tushar's Birthday Party
#### Problem Description
```text
As it is Tushar's Birthday on March 1st, he decided to throw a party to all his 
friends at TGI Fridays in Pune. Given are the eating capacity of each friend, 
filling capacity of each dish and cost of each dish. A friend is satisfied if the 
sum of the filling capacity of dishes he ate is equal to his capacity. Find the 
minimum cost such that all of Tushar's friends 
are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.

Each friend can take any dish unlimited number of times.

There always exists a dish with filling capacity 1 so that a solution always exists.
```
#### Problem Constraints
```text
|A| <= 1000

|B| <= 1000

|C| <= 1000
```
#### Input Format
```text
First Argument is vector A, denoting eating capacities

Second Argument is vector B, denoting filling capacities

Third Argument is vector C, denoting cost
```
#### Output Format
```text
Return a single integer, the answer to the problem
```
#### Example Input
```text
Input 1:
 A = [2, 4, 6]
 B = [2, 1, 3]
 C = [2, 5, 3]

Input 2:
 A = [2]
 B = [1]
 C = [2]
```
#### Example Output
```text
Output 1:
 12

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    First friend takes dish 1, Second friend takes dish 1 twice and third friend 
    takes dish 3 twice.
    So 2 + 2*2 + 3*2 = 12.

Explanation 2:
    Only way is to take 2 dishes of cost 2, hence 4.
```
### Hints
* Hint 1
```text
As friends cannot share dishes, can we independently calculate the cost for each friend 
and add them up?

If we calculate answer for each person independently, how different is this from the 
standard Knapsack problem?

Time for some Dynamic thinking!
```
* Solution Approach
```text
**Observations: **
As the friends cannot share dishes, we can calculate the cost for each of them 
independently and add all such costs.

Now, the problem instance for every friend is reduced to standard KnapSack problem.

**Dynamic programming recurrence: **

dp[i][j] –> min. cost to satisfy a person with capacity i using first j dishes.

dp[i][j] = min( dp[i][j-1] , dp[ i-fillCap[j] ][j] + cost[j] ) // if ( i-fillCap[j] ) >= 0
dp[i][j] = dp[i][j-1] // otherwise

As one dish can be taken multiple times, we have used dp[ i-fillCap[j] ][ j ] and 
not dp[ i-fillCap[j] ][ j-1 ]. This is different from standard KnapSack where one 
element can be used only once.

Note: Base cases should be handled properly.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    static int INF = 10000000;
    static int[][] dp = new int[1005][1005];

    public int solve(final int[] A, final int[] B, final int[] C) {
        ArrayList<Pair> dish = new ArrayList<Pair>();
        int n = C.length;
        for (int i = 0; i < n; i++)
            dish.add(new Pair(B[i], C[i]));
        int m = -1;
        for (int i = 0; i < A.length; i++)
            m = Math.max(m, A[i]);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                else if (j == 0)
                    dp[i][j] = INF;
                else {
                    if (i >= dish.get(j - 1).ff) {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - dish.get(j - 1).ff][j] + dish.get(j - 1).ss);
                    } else
                        dp[i][j] = dp[i][j - 1];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += dp[A[i]][n];
        }

        return ans;
    }
}

class Pair {
    int ff;
    int ss;

    public Pair(int a, int b) {
        this.ff = a;
        this.ss = b;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : array of integers
    //param C : array of integers
    //return an integer
    solve: function (A, B, C) {
        let dish = [];
        let n = C.length;
        for (let i = 0; i < n; i++)
            dish.push([B[i], C[i]]);
        let m = -1;
        for (let i = 0; i < A.length; i++) {
            m = Math.max(m, A[i]);
        }
        let dp = new Array(m + 1);
        for (let i = 0; i <= m; i++) {
            dp[i] = new Array(n + 1);
        }
        //maximum capacity among friends

        // dp[highest capacity][no. of dishes]
        for (let i = 0; i <= m; i++) {
            for (let j = 0; j <= n; j++) {
                //if capacity of friend is 0
                if (i == 0) dp[i][j] = 0;
                //if no dish is remaining to choose from
                else if (j == 0) dp[i][j] = Infinity;
                else {
                    //if i-th person can eat jth dish
                    if (i >= dish[j - 1][0]) {
                        //As one dish can be taken multiple times, we have used 
                        //dp[ i-dish[j-1].first ][ j ] and not dp[ i-dish[j-1].first ][ j-1 ]. 

                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - dish[j - 1][0]][j] + dish[j - 1][1]);
                    } else dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // Add for each friend independently
        let ans = 0;
        for (let i = 0; i < A.length; i++) {
            ans += dp[A[i]][n];
        }

        return ans;
    }
};
```
* * Solution in C++
```cpp
vector<int> dp;

int helper(const vector<int> &B,const vector<int> &C, int val) {
	if (val == 0) return 0;

	if (dp[val] != -1) return dp[val];

	int ans = 1e9;

	for (int i = 0; i < B.size(); i++) {
		int cost = INT_MAX;
		if (val >= B[i]) {
			cost = C[i] + helper(B, C, val - B[i]);
		}
		ans = min(ans, cost);
	}

	dp[val] = ans;
	return ans;
}

int Solution::solve(const vector<int> &A, const vector<int> &B, const vector<int> &C) {
	int mx = 0;

	for (int i : A) {
		mx = max(mx, i);
	}

	dp = vector<int>(mx + 1, -1); 

	helper(B, C, mx); 
	int ans = 0; 
	for (int i : A) {
		ans += dp[i]; 
	}

	return ans; 
}
```

