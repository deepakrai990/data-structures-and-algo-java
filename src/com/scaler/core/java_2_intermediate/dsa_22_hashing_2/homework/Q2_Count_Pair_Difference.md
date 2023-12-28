### Q2. Count Pair Difference
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    You are given an array <strong>A</strong> of 
    <strong>N</strong> integers and an integer 
    <strong>B</strong>. Count the number of pairs (i,j) 
    such that A[i] - A[j] = B and i ≠ j. Since the answer 
    can be very large, return the remainder after dividing 
    the count with 10<sup>9</sup>+7.
</div>

```text
You are given an array A of N integers and an integer B. Count 
the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j. 
Since the answer can be very large, return the remainder after 
dividing the count with 10^9+7.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    1 &lt;= A[i] &lt;= 10<sup>9</sup><br>
    1 &lt;= B &lt;= 10<sup>9</sup>
</div>

```text
1 <= N <= 105
1 <= A[i] <= 109
1 <= B <= 109
```
#### Input Format
```text
First argument A is an array of integers and second 
argument B is an integer.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = [3, 5, 1, 2]
 B = 4

Input 2:
 A = [1, 2, 1, 2]
 B = 1
```
#### Example Output
```text
Output 1:
 1

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    The only pair is (2, 3) which gives difference as 4

Explanation 2:
    The pair which gives difference as 3 
    are (2, 1), (4, 1), (2, 3) and (4, 3). 
```
### Hints
* Hint 1
```text
Can we use hashing to store the elements of the array?
Think of an appropriate data structure to perform this operation
```
* Solution Approach
```text
We can use a hash-map and store the elements of the array
as the key and its frequency as the value. 

We traverse the array from left to right.

Now, for every element we count the number of occurrences of 
A[i] + B and A[i] - B to its left side and increment that to our answer.

Time Complexity : O(N)
Space Complexity : O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        final int mod = (int)(1e9 + 7);
        long ans = 0;
        for(int i = 0 ; i < A.length ; i++){
            ans += freq.getOrDefault(A[i] - B, 0) + freq.getOrDefault(A[i] + B, 0);
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }
        return (int)(ans % mod);
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
const int mod = 1e9 + 7;
int Solution::solve(vector<int> &A, int B) {
    unordered_map<int,int> freq;
    long long ans = 0;
    for(int i = 0 ; i < A.size() ; i++){
        ans = (ans + freq[A[i] - B] + freq[A[i] + B]) % mod;
        freq[A[i]] += 1;
    }
    return ans;
}
```

