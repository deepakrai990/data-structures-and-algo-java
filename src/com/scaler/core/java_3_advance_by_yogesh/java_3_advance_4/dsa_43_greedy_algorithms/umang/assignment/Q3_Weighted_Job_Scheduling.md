### Q3. Weighted Job Scheduling
#### Problem Description
```text
Given N jobs where every job is represented by following three elements of it.

    * Start Time
    * Finish Time
    * Profit Associated

Find and return the maximum profit subset of jobs such that no two jobs in the 
subset overlap.
```
#### Problem Constraints
```text
1 <= N <= 1e5
1 <= A[i][0], A[i][1], A[i][2] <= 1e5
```
#### Input Format
```text
The first and the only line of input contains a 2d array, A, of N x 3 integers:
    A[i][0] : Start Time
    A[i][1] : Finish Time
    A[i][2] : Profit
```
#### Output Format
```text
Return the maximum possible profit under the given conditions.
```
#### Example Input
```text
Input 1:

    A = [   [1, 2, 50]
            [3, 5, 20]
            [6, 19, 100]
            [2, 100, 200]  ]
```
#### Example Output
```text
Output 1:
    250
```
#### Example Explanation
```text
Explanation 1:
     We can perform jobs 1 and 4.
     Profit = 50 + 200 = 250
```
### Hints
* Hint 1
```text
/** Not available **/
```
* Solution Approach
```text
/** Not available **/
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    class Job {
        int start, finish, profit;

        Job(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }

    class JobComparator implements Comparator<Job> {
        public int compare(Job a, Job b) {
            return a.finish < b.finish ? -1 : a.finish == b.finish ? 0 : 1;
        }
    }

    public int solve(int[][] A) {
        Job[] jobArr = new Job[A.length];
        for (int i = 0; i < A.length; i++) {
            int start = A[i][0], finish = A[i][1], profit = A[i][2];
            Job job = new Job(start, finish, profit);
            jobArr[i] = job;
        }
        return schedule(jobArr);
    }
    
    private int schedule(Job jobs[]) {
        Arrays.sort(jobs, new JobComparator());

        int n = jobs.length;
        int table[] = new int[n];
        table[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int inclProf = jobs[i].profit;
            int l = binarySearch(jobs, i);
            if (l != -1)
                inclProf += table[l];

            table[i] = Math.max(inclProf, table[i - 1]);
        }

        return table[n - 1];
    }

    private static int binarySearch(Job jobs[], int index) {
        int lo = 0, hi = index - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (jobs[mid].finish <= jobs[index].start) {
                if (jobs[mid + 1].finish <= jobs[index].start)
                    lo = mid + 1;
                else
                    return mid;
            } else
                hi = mid - 1;
        }

        return -1;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
/** Not available **/
```

