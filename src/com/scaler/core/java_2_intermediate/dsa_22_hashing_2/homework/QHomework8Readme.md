### Q8. Pairs With Given Xor
#### Problem Description
```text
Given an integer array A containing N distinct integers.

Find the number of unique pairs of integers in the array 
whose XOR is equal to B.

NOTE:

    * Pair (a, b) and (b, a) is considered to be the same 
    and should be counted once.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i], B &lt;= 10<sup>7</sup></p>
</div>

```text
1 <= N <= 10^5

1 <= A[i], B <= 10^7
```
#### Input Format
```text
The first argument is an integer array A.

The second argument is an integer B.
```
#### Output Format
```text
Return a single integer denoting the number of unique 
pairs of integers in the array A whose XOR is equal to B.
```
#### Example Input
```text
Input 1:
 A = [5, 4, 10, 15, 7, 6]
 B = 5

Input 2:
 A = [3, 6, 8, 10, 15, 50]
 B = 5
```
#### Example Output
```text
Output 1:
 1

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
 (10 ^ 15) = 5

Explanation 2:
 (3 ^ 6) = 5 and (10 ^ 15) = 5 
```
### Hints
* Hint 1
```text
The idea is based on the fact that A[i] ^ A[j] is 
equal to B if and only if A[i] ^ B is equal to A[j].

Think of a solution that works in linear time 
complexity using this fact.
```
* Solution Approach
```text
A Simple solution is to traverse each element and check 
if there’s another number whose XOR with it is equal to B.

This solution takes O(N^2) time.

The efficient solution to this problem 
takes O(N) time.

The idea is based on the fact that A[i] ^ A[j] is equal 
to B if and only if A[i] ^ B is equal to A[j].

    1. Initialize the result as 0.
    2. Create an empty hash set “s”.
    3. Do the following for each element A[i] in A[]
        1. If B ^ A[i] is in “s”, then increment the result by 1.
        2. Insert A[i] into the hash set “s”.
    4. Return result.
```
* Complete Solution
* * Solution in Java
```java
// Returns count of pairs in arr[0..n-1]  
// with XOR value equals to x. 
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int ans = 0;
        for(int x: A){
            if(mp.containsKey(x^B)){
                ++ans;
            }
            mp.put(x, 1);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
// Returns count of pairs in arr[0..n-1] with XOR 
// value equals to x. 
int xorPairCount(vector<int>&arr,int x) 
{ 
    int n=arr.size();
    int result = 0; // Initialize result 
  
    // create empty set that stores the visiting  
    // element of array.  
    // Refer below post for details of unordered_set 
    // https://www.geeksforgeeks.org/unorderd_set-stl-uses/ 
    unordered_set<int> s; 
  
    for (int i=0; i<n ; i++) 
    { 
        // If there exist an element in set s 
        // with XOR equals to x^arr[i], that means 
        // there exist an element such that the 
        // XOR of element with arr[i] is equal to 
        // x, then increment count. 
        if (s.find(x^arr[i]) != s.end()) 
            result++; 
  
        // Make element visited 
        s.insert(arr[i]); 
    } 
  
    // return total count of pairs with XOR equal to x 
    return result; 
} 
int Solution::solve(vector<int> &A, int B) {
    return xorPairCount(A,B);
}
```

