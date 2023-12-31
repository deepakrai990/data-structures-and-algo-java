### Q5. Odd Even Subsequences
#### Problem Description
```text
Given an array of integers A of size, N. Find the longest 
subsequence of A, which is odd-even.

A subsequence is said to be odd-even in the following cases:

    1. The first element of the subsequence is odd; the second 
       element is even, the third element is odd, and so on. 
       For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]

    2. The first element of the subsequence is even, the second 
       element is odd, the third element is even, and so on. 
       For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]

Return the maximum possible length of odd-even subsequence.

Note: An array B is a subsequence of an array A if B can be 
obtained from A by deleting several (possibly, zero, or all) elements.
```
#### Problem Constraints
```text
1 <= N <= 100000
1 <= A[i] <= 10^9 
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return the maximum possible length of odd-even subsequence.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 2, 5, 6]

Input 2:
 A = [2, 2, 2, 2, 2, 2]
```
#### Example Output
```text
Output 1:
 4

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Maximum length odd even subsequence is [1, 2, 5, 6]

Explanation 2:
    Maximum length odd even subsequence is [2]
```
### Hints
* Hint 1
```text
If the current number of the subsequence is even, then for 
maximum length, it is best to choose the closest odd number 
as the next number.

The same can be done if the current number is odd; take the 
next closest even number.

Can we use the above fact to find the maximum length?
```
* Solution Approach
```text
Find two odd-even subsequences, first whose first element is odd 
and the other whose first element is odd, return the maximum of 
these two subsequences.

Refer to Complete solution for implementation.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int ans1 = 0, ans2 = 0;
        int x = 1, y = 0;
        for (int i = 0; i < n; i++) {
            int it = A[i];
            it = (it & 1);
            if (it == x) {
                ++ans1;
                x ^= 1;
            }
            if (it == y) {
                y ^= 1;
                ++ans2;
            }
        }
        return Math.max(ans1, ans2);
    }
}
```
* * Solution in Javascript
```javascript
/** not available **/
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
     int n=A.size();
    int ans1=0,ans2=0;
    int x=1,y=0;
    for(auto &it:A){
        it=(it&1);
        if(it==x){
            ++ans1;
            x^=1;
        }
        if(it==y){
            y^=1;
            ++ans2;
        }
    }
    return max(ans1,ans2);
}
```

