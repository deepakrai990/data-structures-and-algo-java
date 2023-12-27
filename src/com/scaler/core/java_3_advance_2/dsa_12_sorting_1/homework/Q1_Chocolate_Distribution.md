### Q1. Chocolate Distribution
#### Problem Description
```text
Given an array A of N integers where the i-th element represent the number of 
chocolates in the i-th packet.

There are B number of students, the task is to distribute chocolate packets 
following below conditions:

    1. Each student gets one packets.
    2. The difference between the number of chocolates given to any two students is minimum.

Return the minimum difference (that can be achieved) between the student who gets 
minimum number of chocolates and the student who gets maximum number of chocolates.

Note: If you can't give each student 1 packet, return 0.
```
#### Problem Constraints
```text
0 <= N <= 10^5
1 <= A[i] <= 10^7
0 <= B <= 10^5
```
#### Input Format
```text
The first argument contains an integer array A.

The second argument contains an integer B.
```
#### Output Format
```text
Return the minimum difference (that can be achieved) between maximum and minimum 
number of chocolates distributed.
```
#### Example Input
```text
Input:

  A : [3, 4, 1, 9, 56, 7, 9, 12]
  B : 5
```
#### Example Output
```text
Output:

  6
```
#### Example Explanation
```text
Explanation:

  We can choose the packets with chocolates = [3, 4, 9, 7, 9]
  The difference between maximum and minimum is 9-3 = 6
```
### Hints
* Hint 1
```text
Sort the array and observe the pattern.
```
* Solution Approach
```text
Sort the array.

Find the minimum difference between all subarrays of size B.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        if (A.length == 0 || B == 0) {
            return 0;
        }
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + B - 1 < A.length; i++) {
            int d = A[i + B - 1] - A[i];
            if (d < min) {
                min = d;
            }
        }
        return min;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A, int B) {
    if(A.size()==0 or B==0)
        return 0;
    sort(A.begin(),A.end());
    int ans=1e9;
    for(int i=0;i<=A.size()-B;i++)
        ans=min(ans,A[i+B-1]-A[i]);
    return ans;
}
```

