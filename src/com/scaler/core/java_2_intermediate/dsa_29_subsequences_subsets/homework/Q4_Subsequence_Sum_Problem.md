### Q4. Subsequence-Sum Problem
#### Problem Description
```text
You are given an array of integers of N size.

You have to find that there is any subsequence exists or not 
whose sum is equal to B.
```
#### Problem Constraints
```text
1 <= N <= 20
1 <= A[i] <= 100000
0 <= B <= 1e9
```
#### Input Format
```text
First Argument is array of integers A
Second Argument is B
```
#### Output Format
```text
Return 1 if any subsequence sum is equal to B otherwise return 0.
```
#### Example Input
```text
Input 1:
 A = [1,20,13,4,5]
 B = 18

Input 2:         
 A = [2,2,2,2]
 B = 5
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    There is as subsequence present at indexes 1,3,4 whose sum is 18

Explanation 2:
    There is no possible subsequence whose sum is 5
    NOTE: Array is considered 1 based indexing for the above explanation.
```
### Hints
* Hint 1
```text
Think about how you can generate all possible subsequence sum.
Use recursion to generate all possible sums
```
* Solution Approach
```text
Think using recursion, and make all possible sums as N<=20.
So total possible different sums are only 2^20.
TIME Complexity: 2^n where n is the size of array.
We can also use an iterative approach to generate all 
subsets using bit manipulation.
Approach: For the recursive approach, we will consider two cases. 
let right now we are at index i of the given array A.
Now there are two possible cases
Case 1 - We will take the value of A[i] in our sum.
Case 2 - We will ignore the value of A[i].
And we will move on to index i-1.
Base case will be when i == -1.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int subsequenceSum(int[] A, int B, int i) {
        if (i == -1) {
            if (B == 0) return 1;
            else return 0;
        }
        int ans = 0;
        ans |= subsequenceSum(A, B, i - 1);
        ans |= subsequenceSum(A, B - A[i], i - 1);
        return ans;
    }

    public int solve(int[] A, int B) {
        if (B == 0) return 0;
        int n = A.length;
        return subsequenceSum(A, B, n - 1);
    }
}
```
* * Solution in Javascript
```javascript
/** not available **/
```
* * Solution in C++
```cpp
int subsequenceSum(vector<int>&A, int B, int i){
    if(i==-1){
        return (B==0) ? 1 : 0;
    }
    int ans = 0;
    ans |= subsequenceSum(A, B, i-1);
    ans |= subsequenceSum(A, B - A[i], i-1);
    return ans;
}

int Solution::solve(vector<int> &A, int B){
    if(!B)return 0;
    int n = A.size();
    return subsequenceSum(A, B, n-1);
}
```

