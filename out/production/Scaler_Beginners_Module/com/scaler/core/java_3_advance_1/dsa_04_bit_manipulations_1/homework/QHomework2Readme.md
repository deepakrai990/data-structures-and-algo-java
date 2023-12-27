### Q2. Min XOR value
#### Problem Description
```text
Given an integer array A of N integers, find the pair 
of integers in the array which have minimum XOR value. 
Report the minimum XOR value.
```
#### Problem Constraints
* <p> 2 &lt;= length of the array &lt;= 100000 </p>
* <p> 0 &lt;= A[i] &lt;= 10<sup>9</sup></p>
```text
2 <= length of the array <= 100000
0 <= A[i] <= 10^9
```
#### Input Format
```text
First and only argument of input contains an integer array A.
```
#### Output Format
```text
Return a single integer denoting minimum xor value.
```
#### Example Input
```text
Input 1:
 A = [0, 2, 5, 7]

Input 2:
 A = [0, 4, 7, 9]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    0 xor 2 = 2
```
### Hints
* Hint 1
```text
Hint: Sort the array.

Think of how you can use the sorted array to find the minimum XOR.
```
* Hint 2
```text
The brute-force would be to try every pair (x, y).

If the array is sorted, do you need to check for 
every pair? Try to reduce the number of checked pairs.
```
* Solution Approach
```text
The first step is to sort the array. The answer will 
be the minimum value of X[i] XOR X[i+1] for every i.

Proof:
Let’s suppose that the answer is not X[i] XOR X[i+1], 
but A XOR B and there exists C in the array such as A <= C <= B.

Next is the proof that either A XOR C or C XOR B 
is smaller than A XOR B.

Let A[i] = 0/1 be the i-th bit in the binary representation of A
Let B[i] = 0/1 be the i-th bit in the binary representation of B
Let C[i] = 0/1 be the i-th bit in the binary representation of C

This is with the assumption that all of A, B and C are padded 
with 0 on the left until they all have the same length

Example: A = 169, B = 187, C = 185
```

<p>A = 10101001<sub>2</sub>  <br>
B = 10111011<sub>2</sub>  <br>
C = 10111001<sub>2</sub></p>

```text
Let i be the leftmost (biggest) index such that A[i] differs from B[i]. There are 2 cases now:
1) C[i] = A[i] = 0,
then (A XOR C)[i] = 0 and (A XOR B)[i] = 1
This implies (A XOR C) < (A XOR B)
2) C[i] = B[i] = 1,
then (B XOR C)[i] = 0 and (A XOR B)[i] = 1
This implies (B XOR C) < (A XOR B)

Time complexity: O(N * logN) to sort the array and O(N) to find the smallest XOR
Space complexity: O(N)
```

* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int findMinXor(ArrayList < Integer > A) {
        // sort the array A in ascending order
        Collections.sort(A);
        // the answer will be the min of XOR of each adjacent elements
        int ans = A.get(0) ^ A.get(1);
        for (int i = 1; i < A.size(); i++) {
            ans = Math.min(A.get(i) ^ A.get(i - 1), ans);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    findMinXor: function (A) {
        // sort the array A in ascending order
        A.sort((a, b) => a - b);
        // the answer will be the min of XOR of each adjacent elements
        let ret = A[1] ^ A[0];
        for (let i = 2; i < A.length; i++) {
            ret = Math.min(ret, A[i] ^ A[i - 1]);
        }
        return ret;
    },
};
```
* * Solution in C++
```cpp
int Solution::findMinXor(vector < int > & A) {
    // sort the array A in ascending order
    sort(A.begin(), A.end());
    // the answer will be the min of XOR of each adjacent elements
    int smallestXor = A[0] ^ A[1];
    for (int i = 2; i < A.size(); i++) {
        smallestXor = min(smallestXor, A[i - 1] ^ A[i]);
    }
    return smallestXor;
}
```

