### Q3. Elements Removal
#### Problem Description
```text
Given an integer array A of size N. You can remove any element 
from the array in one operation.

The cost of this operation is the sum of all elements in the 
array present before this operation.

Find the minimum cost to remove all elements from the array.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>0 &lt;= N &lt;= 1000<br> 
    1 &lt;= A[i] &lt;= 10<sup>3</sup></p>
</div>

```text
0 <= N <= 1000
1 <= A[i] <= 10^3
```
#### Input Format
```text
First and only argument is an integer array A.
```
#### Output Format
```text
Return an integer denoting the total cost of removing all elements 
from the array.
```
#### Example Input
```text
Input 1:
 A = [2, 1]

Input 2:
 A = [5]
```
#### Example Output
```text
Output 1:
 4

Output 2:
 5
```
#### Example Explanation
```text
Explanation 1:
    Given array A = [2, 1]
    Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
    Remove 1 from the array => []. Cost of this operation is (1) = 1.
    So, total cost is = 3 + 1 = 4.

Explanation 2:
    There is only one element in the array. So, cost of removing is 5.
```
### Hints
* Hint 1
```text
Think about the order in which we should remove elements from the array.
```
* Solution Approach
```text
Let’s find the count of how many times an element will 
contribute to the answer.

Remove any element from the array. The cost of this operation is 
equal to the sum of array elements irrespective of which 
element gets removed.

If we remove another element from the array, the cost of this 
operation will be ( cost of the previous operation - the element 
which gets removed in the last operation.)

So, we can easily observe that it is wise to remove the highest 
element first to make the total cost minimum, and elements 
also follow a pattern.

Element removed first will be added 1 time to the answer.
Element removed second will be added 2 times to the answer.
Element removed third will be added 3 times to the answer.
.
.
.
So on.

We can easily find the total cost in one single loop.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList<Integer> A) {

        Collections.sort(A);
        int sum = 0, ans = 0;

        for (int i = 0; i < A.size(); i++) {
            sum += (A.size() - i) * A.get(i);
        }

        return sum;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    solve: function (A) {

        let n = A.length;
        A.sort((a, b) => {
            return a - b
        });

        let count = 1, ans = 0;
        for (let i = n - 1; i >= 0; i--) {
            ans += (count * A[i]);
            count++;
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
    
    int n = A.size();
    // sort the given array
    sort(A.begin(), A.end());

    int count = 1; // how many times a number will contribute to ans.

    int ans = 0;
    for(int i = n-1 ; i >= 0; i--)
    {
        // add the ith element count times to the ans. 
        ans += count * A[i];
        count++;    
    }

    return ans;
}
```

