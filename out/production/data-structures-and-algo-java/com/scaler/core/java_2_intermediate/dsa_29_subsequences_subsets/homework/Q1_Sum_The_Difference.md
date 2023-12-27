### Q1. Sum the Difference
#### Problem Description
```text
Given an integer array, A of size N.
You have to find all possible non-empty subsequences of 
the array of numbers and then, for each subsequence, find 
the difference between the largest and smallest numbers in 
that subsequence. Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

NOTE: Subsequence can be non-contiguous.
```
#### Problem Constraints
```text
1 <= N <= 10000

1<= A[i] <=1000
```
#### Input Format
```text
First argument is an integer array A.
```
#### Output Format
```text
Return an integer denoting the output.
```
#### Example Input
```text
Input 1:
 A = [1, 2] 

Input 2:
 A = [3, 5, 10]
```
#### Example Output
```text
Output 1:
 1 

Output 2:
 21
```
#### Example Explanation
```text
Explanation 1:
    All possible non-empty subsets are:
    [1]     largest-smallest = 1 - 1 = 0
    [2]     largest-smallest = 2 - 2 = 0
    [1, 2]  largest-smallest = 2 - 1 = 1
    Sum of the differences = 0 + 0 + 1 = 1
    So, the resultant number is 1 

Explanation 2:
    All possible non-empty subsets are:
    [3]         largest-smallest = 3 - 3 = 0
    [5]         largest-smallest = 5 - 5 = 0
    [10]        largest-smallest = 10 - 10 = 0
    [3, 5]      largest-smallest = 5 - 3 = 2
    [3, 10]     largest-smallest = 10 - 3 = 7
    [5, 10]     largest-smallest = 10 - 5 = 5
    [3, 5, 10]  largest-smallest = 10 - 3 = 7
    Sum of the differences = 0 + 0 + 0 + 2 + 7 + 5 + 7 = 21
    So, the resultant number is 21 
```
### Hints
* Hint 1
```text
The naive approach of finding all subset complexity will be exponential.
Can sorting work?
```
* Solution Approach
```text
It can be seen that if elements are sorted, then taking any two indexes,
there will be a fixed number of K elements in between then.

So you can take any number of K elements that are in between those 
two elements.

So the difference of the values of those two indexes will 
contribute 2 to the power of K (subsets) to the answer.

So we will take all possible pairs of elements.

Example:
1 2 3 4

If we take indexes 0 and 3, i.e., elements 1 and 4. There are two 
elements between them (2, 3).

So 1 and 4 are in 4 subsets which are
a) 1 4
b) 1 2 4
c) 1 3 4
d) 1 2 3 4

Which is 2 to the power of 2.

The complexity if O(N^2)

If we take a close look at the approach above,
we can solve it in O(N) also.
After sorting the array,
Answer is {A[N-1]2^(N-1) +A[N-2]2^(N-2) +…..+A[0]2^0} - {A[0]2^(N-1) + A[1]2^(N-2) +……+ A[0]2^0}
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList<Integer> A) {
        // sort the array
        Collections.sort(A);
        int Mod = 1000 * 1000 * 1000 + 7;
        long minus = 0, plus = 0;
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            // summation of smallest numbers over all subsequences
            minus += (val * pow(2, A.size() - 1 - i, Mod)) % Mod;
            minus %= Mod;
            // summation of largest numbers over all subsequences
            plus += (val * pow(2, i, Mod)) % Mod;
            plus %= Mod;
        }
        return (int) ((plus - minus + Mod) % Mod);
    }

    public long pow(long x, int y, int k) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        // sort the array
        A.sort((a, b) => a - b);
        const MOD = 1e9 + 7;
        let cur = 1;
        let ans = 0;
        // summation of largest numbers over all subsequences
        A.forEach((ele) => {
            ans += (ele * cur) % MOD;
            cur *= 2;
            cur %= MOD;
        });
        A = A.reverse();
        cur = 1;
        // summation of smallest numbers over all subsequences
        A.forEach((ele) => {
            ans = (ans - ((ele * cur) % MOD) + MOD) % MOD;
            cur *= 2;
            cur %= MOD;
        });
        return ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A) {
    int mod = 1e9+7;
    long long _max = 0;
    long long _min = 0;
    int N = A.size();
    // sort the array
    sort(A.begin(), A.end());
    // summation of smallest numbers over all subsequences
    for (int i = 0; i < N; i++) {
        _min = (_min * 2) % mod;
        _min = (_min + A[i]) % mod;
    }
    // summation of largest numbers over all subsequences
    for (int i = N - 1; i >= 0; i--) {
        _max = (_max * 2) % mod;
        _max = (_max + A[i]) % mod;
    }
    long long ans = (_max - _min + mod) % mod;
    return ans;
}
```

