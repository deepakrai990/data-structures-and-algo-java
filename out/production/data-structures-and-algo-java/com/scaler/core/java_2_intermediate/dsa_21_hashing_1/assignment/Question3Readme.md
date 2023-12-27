### Q3. First Repeating element
#### Problem Description
```text
Given an integer array A of size N, find the first 
repeating element in it.

We need to find the element that occurs more than once and 
whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 10^5

1 <= A[i] <= 10^9
```
#### Input Format
```text
The first and only argument is an integer array A of size N.
```
#### Output Format
```text
Return an integer denoting the first repeating element.
```
#### Example Input
```text
Input 1:
 A = [10, 5, 3, 4, 3, 5, 6]

Input 2:
 A = [6, 10, 5, 4, 9, 120]
```
#### Example Output
```text
Output 1:
 5

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:
    5 is the first element that repeats

Explanation 2:
    There is no repeating element, output -1
```
### Hints
* Hint 1
```text
Think of Hashing. Traverse the array from right to left and 
update the minimum index if the element occurs more than once.
```
* Solution Approach
```text
A Simple Solution is to use two nested loops. The outer loop 
picks an element one by one, the inner loop checks whether 
the element is repeated or not. Once we find an element that 
repeats, we break the loops and print the element.

Time Complexity of this solution is O(n^2)

We can Use Sorting to solve the problem in O(n Log n) time. 
Following are detailed steps.
    1) Copy the given array to an auxiliary array temp[].
    
    2) Sort the temp array using an O(nLogn) time sorting algorithm.
    
    3) Scan the input array from left to right. For every 
       element, count its occurrences in temp[] using binary 
       search. As soon as we find an element that occurs more 
       than once, we return the element.

This step can be done in O(n Log n) time.

We can optimize the solution using Hashing.

We can Use Hashing to solve this in average O(n) time.

The idea is to traverse the given array from right to left 
and update the minimum index whenever we find an element 
visited on the right side.

At last, return the element at the minimum index stored.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> vis = new HashMap<Integer, Integer>();
        int ans = -1;
        for (int i = A.size() - 1; i >= 0; --i) {
            if (vis.containsKey(A.get(i))) {
                ans = A.get(i);
            } else {
                vis.put(A.get(i), 1);
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    solve: function (A) {
        let ans = -1, diff = 1000000;
        let mp = new Map();
        let n = A.length;
        for (let i = 0; i < n; i++) {
            if (mp.has(A[i])) {

                if (mp.get(A[i]) < diff) {
                    diff = mp.get(A[i]);
                    ans = A[i];
                }
            }
            mp.set(A[i], i);
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
    int n = A.size();
    // Initialize index of first repeating element
    int mini = -1;

    // Creates an empty hashset named ump
    unordered_map<int,int> ump;

    // Traverse the input array from right to left
    for (int i = n - 1; i >= 0; i--)
    {
        // If element is already in hash set, update min
        if (ump.find(A[i]) != ump.end())
            mini = i;
        else   // Else add element to hash set
            ump[A[i]] = 1;
    }
    if(mini == -1){
        return mini;
    }
    return A[mini];
}
```

