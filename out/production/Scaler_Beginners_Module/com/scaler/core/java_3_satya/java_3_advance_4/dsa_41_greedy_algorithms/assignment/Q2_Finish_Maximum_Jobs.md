### Q2. Finish Maximum Jobs
#### Problem Description
```text
There are N jobs to be done, but you can do only one job at a time.

Given an array A denoting the start time of the jobs and an array B denoting the 
finish time of the jobs.

Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

Return the maximum number of jobs you can finish.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt; B[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 10^5

1 <= A[i] < B[i] <= 10^9
```
#### Input Format
```text
The first argument is an integer array A of size N, denoting the start time of the jobs.
The second argument is an integer array B of size N, denoting the finish time of the jobs.
```
#### Output Format
```text
Return an integer denoting the maximum number of jobs you can finish.
```
#### Example Input
```text
Input 1:
 A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]

Input 2:
 A = [3, 2, 6]
 B = [9, 8, 9]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    We can finish the job in the period of time: (1, 7) and (7, 8).

Explanation 2:
    Since all three jobs collide with each other. We can do only 1 job.
```
### Hints
* Hint 1
```text
Can we sort the given jobs in ascending order according to start time?
```
* Solution Approach
```text
We will think of the greedy approach.

Sort the given jobs according to start time.
Initialize the answer variable to one, i.e., ans = 1.
Loop through the jobs.
If the start time of the job is greater than or equal to the finish time of the 
current job, we are working on.

Increment the answer and update the finish time.

Else if the finish time is lesser than the current finish time, update the current 
finish time.

Return the answer.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    class pair {
        int S, E;

        pair(int s, int e) {
            S = s;
            E = e;
        }
    }

    public int solve(int[] A, int[] B) {
        int n = A.length;
        pair a[] = new pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new pair(A[i], B[i]);
            assert (A[i] != B[i]);
        }
        Arrays.sort(a, (pair u, pair v) -> (u.E - v.E));
        int end = 0, ans = 0;
        for (pair job : a) {
            if (job.S >= end) {
                ans++;
                end = job.E;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function(A, B) {
        let n = A.length;
        let v = [];
        for (let i = 0; i < n; i++) {
            v.push([A[i], B[i]]);
        }

        v.sort((a, b) => {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        let ans = 1;
        let st = v[0][0],
            lst = v[0][1];
        for (let i = 1; i < n; i++) {
            if (v[i][0] >= lst) {
                ans++;
                lst = v[i][1];
            } else {
                lst = Math.min(lst, v[i][1]);
            }
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A, vector < int > & B) {
    int n = A.size();
    assert(n == B.size());

    // store the start and finish time of a job
    vector < pair < int, int >> v;
    for (int i = 0; i < n; i++) {
        v.push_back({
            A[i],
            B[i]
        });
    }

    // Sort the job in ascending order respective of start time
    sort(v.begin(), v.end());

    // Since we can do atleast one job, Initialize the answer to 1
    int ans = 1;

    // start time and finish time of the first job
    int st = v[0].first, lst = v[0].second;

    for (int i = 1; i < n; i++) {
        // If the start time of the next job is greater than or equal to finish time of last job we are working on then update finish time and increment ans
        if (v[i].first >= lst) {
            ans++;
            lst = v[i].second;
        } else {
            lst = min(lst, v[i].second);
        }
    }
    return ans;
}
```

