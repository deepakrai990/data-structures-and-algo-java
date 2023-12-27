### Q2. Pairs with Given Difference
#### Problem Description
```text
Given an one-dimensional integer array A of size N and 
an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), 
where x and y are both numbers in the array and their 
absolute difference is B.
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>4</sup></p>
* <p>0 &lt;= A[i], B &lt;= 10<sup>5</sup></p>
```text
1 <= N <= 10^4

0 <= A[i], B <= 10^5
```
#### Input Format
```text
First argument is an one-dimensional integer array A of size N.

Second argument is an integer B.
```
#### Output Format
```text
Return an integer denoting the count of all distinct pairs 
with difference equal to B.
```
#### Example Input
```text
Input 1:
 A = [1, 5, 3, 4, 2]
 B = 3

Input 2:
 A = [8, 12, 16, 4, 0, 20]
 B = 4

Input 3:
 A = [1, 1, 1, 2, 2]
 B = 0
```
#### Example Output
```text
Output 1:
 2

Output 2:
 5

Output 3:
 2
```
#### Example Explanation
```text
Explanation 1:
 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2} 

Explanation 2:
 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20} 

Explanation 3:
 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
```
### Hints
* Hint 1
```text
What is the brute force solution? 
You can iterate over all pairs and count.
Due to large constraint, this will exceed time limit.
Can you think of a two pointer approach?
```
* Solution Approach
```text
Let us formulate a two pointer approach to the this problem.

We will first sort the given array and use 
two pointers i and j with i = 0, j = 1.

We will have three conditions:

1. A[j] - A[i] < B --> We will increase the pointer j.
2. A[j] - A[i] > B --> We will increase the pointer i.
3. A[j] - A[-] = B --> We will increase both the pointers and add 1 
to the answer.

Refer to the complete solution for more details.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int i = 0, j = 1;
        long ans = 0;
        while(j < A.size()) {
            if(j == i) {
                j++;
                continue;
            }
            int x = A.get(i), y = A.get(j);
            if(y - x == B) {
                // count the pair A[i], A[j] only once
                ans++;
                while(i < A.size() && A.get(i) == x) i++;
                while(j < A.size() && A.get(j) == y) j++;
            }
            else if(y - x > B){
                i++;
            }
            else j++;
        }
        return (int)ans;
    }
}
```
* * Solution in Javascript
```javascript
const MOD = 1e9 + 7;
module.exports = {
    solve: function (A, B) {
        let n = A.length;
        A.sort(function(a, b){return parseInt(a) - parseInt(b)});
        let i = 0, j = 1;
        let ans = 0;
        while (j < n) {
            if (j == i) {
                j++;
                continue;
            }
            let x = A[i], y = A[j];
            if (y - x == B) {
                // count the pair A[i], A[j] only once
                ans++;
                while (i < n && A[i] == x) {
                    i++;
                }
                while (j < n && A[j] == y) {
                    j++;
                }
            } else if (y - x > B) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A, int B) {
    int n = A.size();
    sort(A.begin(), A.end());
    int i = 0, j = 1;
    long ans = 0;
    while (j < n) {
        if (j == i) {
            j++;
            continue;
        }
        int x = A[i], y = A[j];
        if (y - x == B) {
            // count the pair A[i], A[j] only once
            ans++;
            while (i < n && A[i] == x) i++;
            while (j < n && A[j] == y) j++;
        } else if (y - x > B) {
            i++;
        } else j++;
    }
    return (int) ans;
}
```

