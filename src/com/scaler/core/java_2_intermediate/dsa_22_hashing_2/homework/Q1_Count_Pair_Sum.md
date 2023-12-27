### Q1. Count Pair Sum
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    You are given an array <strong>A</strong> of 
    <strong>N</strong> integers and an integer 
    <strong>B</strong>. Count the number of pairs (i,j) 
    such that A[i] + A[j] = B and i ≠ j. Since the answer 
    can be very large, return the remainder after dividing 
    the count with 10<sup>9</sup>+7.<br><br>Note - The 
    pair (i,j) is same as the pair (j,i) and we need to 
    count it only once.
</div>

```text
You are given an array A of N integers and an integer B. Count 
the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j. 
Since the answer can be very large, return the remainder 
after dividing the count with 10^9+7.

Note - The pair (i,j) is same as the pair (j,i) and we need 
to count it only once.
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
 B = 8

Input 2:
 A = [1, 2, 1, 2]
 B = 3
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
    The only pair is (1, 2) which gives sum 8

Explanation 2:
    The pair which gives sum as 3 are (1, 2), (1, 4), (2, 3) and (3, 4). 
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
B - A[i] to its left side and increment that to our answer.

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
            if(freq.containsKey(B - A[i])){
                ans = (ans + freq.get(B - A[i])) % mod;
            }
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }
        return (int)(ans);
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
	long ans = 0;
	unordered_map<int,int> freq ;
	for(int i = 0 ; i < A.size() ; i++){
		ans = (ans + freq[B - A[i]]) % mod;
		freq[A[i]]++;
	}
	return ans;
}
```

