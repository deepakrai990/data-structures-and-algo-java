### Q1. Minimum number of jumps
#### Problem Description
```text
Given an array of non-negative integers A where each element represents your maximum 
jump length at that position.

The initial position is the first index of the array, and the goal is to reach the 
last index of the array with the minimum number of jumps.

Note: If it is not possible to reach the last index, return -1 instead.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= length of the array &lt;= 100000<br>
    0 &lt;= A[i] &lt;= 10<sup>9</sup> </p>
</div>

```text
1 <= length of the array <= 100000
0 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return the minimum number of jumps to reach the last index or -1 if it is not possible.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [5, 17, 100, 11]
```
#### Example Output
```text
Output 1:
 3

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Initial position is the first index.
    From index 0 we can only jump to index 1 as first element is 0.
    From index 1 we can jump to index 2 or index 3.
    From index 2 we can reach the last index i.e. 4 in 1 jump.
    so, the minimum number of jumps required is 3.
```
### Hints
* Hint 1
```text
A naive approach is to traverse every reachable index from the current index.

Think about using BFS like technique to find the minimum number of jumps required.
```
* Solution Approach
```text
Maintain a variable maxReachablePos which indicates the farthest reachable position, 
and the variable curMax indicates the current farthest reachable position.

currentSteps denotes the jumps required to reach maxPos.

At the ith position if i + A[i] > curMax:
update curMax = i + A[i]

If we reach at the maxReachablePos i.e. maxReachablePos == current index update:
maxReachablePos = curMax
currentSteps += 1

If at any step maxReachablePos >= last index return the currentStep.

If it is impossible to reach the current index means maxPos < current index, then return -1.

Note: Try solving it by taking examples.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int curStep = 0, maxPos = 0, curMax = 0;
        // maxPos indicates the farthest reachable position using curStep steps
        // curMax indicates the current farthest reachable position.
        for(int i = 0 ;  i < A.length ; i++){
            if(i > maxPos) 
                return -1;
            if(curMax < i + A[i]){
                curMax = i + A[i];
            }
            if(maxPos >= A.length - 1) 
                return curStep;
            if(i == maxPos) {
                curStep += 1;
                maxPos = curMax;
            }
        }
        return curStep;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        let curStep = 0, maxPos = 0, curMax = 0;
        // maxPos indicates the farthest reachable position using curStep steps
        // curMax indicates the current farthest reachable position.
        for (let i = 0; i < A.length; i++) {
            if (i > maxPos) 
                return -1;
            if (curMax < i + A[i])
                curMax = i + A[i];
            if (maxPos >= A.length - 1) 
                return curStep;
            if (i == maxPos) {
                curStep += 1;
                maxPos = curMax;
            }
        }
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
    int curStep = 0, maxPos = 0, curMax = 0;
    // maxPos indicates the farthest reachable position using curStep steps
    // curMax indicates the current farthest reachable position.
    for(int i = 0 ;  i < A.size() ; i++){
        if(i > maxPos) 
            return -1;
        if(curMax < i + A[i]){
            curMax = i + A[i];
        }
        if(maxPos >= A.size() - 1) 
            return curStep;
        if(i == maxPos) {
            curStep += 1;
            maxPos = curMax;
        }
    }
}
```

