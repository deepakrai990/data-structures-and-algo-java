### Q3. Sum of Xor of all Pairs
#### Problem Description
```text
Given an array A of N integers. Find the sum of 
bitwise XOR all pairs of numbers in the array.

Since the answer can be large, return the remainder 
after the dividing the answer by 10^9+7.
```
<p>Since the answer can be large, return the </p>
<p>remainder after the dividing the answer by <strong>10<sup>9</sup>+7</strong>.</p>

#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
* <p>1 &lt;= A[i] &lt; 10<sup>9</sup></p>
```text
1 <= N <= 10^5

1 <= A[i] < 10^9
```
#### Input Format
```text
Only argument A is an array of integers
```
#### Output Format
```text
Return an integer denoting the sum of xor of 
all pairs of number in the array.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3]

Input 2:
 A = [3, 4, 2]
```
#### Example Output
```text
Output 1:
 6

Output 2:
 14
```
#### Example Explanation
```text
For Input 1:
    Pair    Xor
    {1, 2}  3
    {1, 3}  2
    {2, 3}  1
    Sum of xor of all pairs = 3 + 2 + 1 = 6.

For Input 2:
    Pair    Xor
    {3, 4}  7
    {3, 2}  1
    {4, 2}  6
    Sum of xor of all pairs = 7 + 1 + 6 = 14.
```
### Hints
* Hint 1
```text
If there are X elements with the i-th bit set and
Y elements with i-th bit unset, then the number of xor
pair where the i-th bit will be set is X*Y
```
* Solution Approach
```text
For every bit, we can find the number of elements in the array 
with that bit set and the number of elements with that bit unset.

Let the number of elements with i-th bit set and unset be 
X and Y respectively.

Now the number of xor pairs with the i-th bit set is X*Y. 
So the total contribution by the i-th bit to the sum of xor
of all pairs will be (X * Y) * (1 << i).


Time Complexity : O(N*logX)
Space Complexity : O(1)

where X is maximum value from A
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        final int mod = (int)(1e9 + 7);    
        int n = A.length;
        long ans = 0;
        for(int j = 0; j < 32; j++){
            long zero = 0, one = 0, temp;
    
            //  Count of zeros and ones for each bit
            for(int i = 0; i < n; i++){
                if (A[i] % 2 == 0)
                    zero++;
                else
                    one++;
                A[i] /= 2;
            }
             
            // calculating individual bit sum
            temp = zero * one * (1 << j);
            ans = (ans + temp) % mod;
        }
        return (int)(ans);
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
    const int mod = 1e9 + 7;    
    int n = A.size();
    assert(1 <= n and n <= 1e5);
    for(auto x : A)assert(1 <= x and x <= 1e9);
    long long ans = 0;
    for(int j = 0; j < 32; j++){
        long long zero = 0, one = 0, temp;
    
        //  Count of zeros and ones for each bit
        for(int i = 0; i < n; i++){
            if (A[i] % 2 == 0)
                zero++;
            else
                one++;
            A[i] /= 2;
        }
         
        // calculating individual bit sum
        temp = zero * one * (1 << j);
        ans = (ans + temp) % mod;
    }
    return ans;
}
```

