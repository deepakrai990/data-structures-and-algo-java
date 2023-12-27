### Q1. Interesting Array
#### Problem Description
```text
You have an array A with N elements. We have two 
types of operation available on this array :
    1. We can split an element B into two elements, C and D, 
        such that B = C + D.
    2. We can merge two elements, P and Q, to one element, R, 
        such that R = P ^ Q i.e., XOR of P and Q.

You have to determine whether it is possible to convert 
array A to size 1, containing a single element equal 
to 0 after several splits and/or merge?
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 100000</p>
* <p>1 &lt;= A[i] &lt;= 10<sup>6</sup></p>
```text
1 <= N <= 100000

1 <= A[i] <= 10^6
```
#### Input Format
```text
The first argument is an integer array A of size N.
```
#### Output Format
```text
Return "Yes" if it is possible otherwise return "No".
```
#### Example Input
```text
Input 1:
 A = [9, 17]

Input 2:
 A = [1]
```
#### Example Output
```text
Output 1:
 Yes

Output 2:
 No
```
#### Example Explanation
```text
Explanation 1:
    Following is one possible sequence of operations -  
    1) Merge i.e 9 XOR 17 = 24  
    2) Split 24 into two parts each of size 12  
    3) Merge i.e 12 XOR 12 = 0  
    As there is only 1 element i.e 0. So it is possible.

Explanation 2:
    There is no possible way to make it 0.
```
### Hints
* Hint 1
```text
Xor has a property that A XOR A = 0.

Can we use this property to check if the answer 
is possible or not?
```
* Solution Approach
```text
If any element in the array is even then, it can be 
made 0. Split that element into two equal parts 
of A[i]/2 and A[i]/2. XOR of two identical numbers 
is zero. Therefore this strategy makes an element 0.

If any element is odd. Split it in two-part: 1, A[i]-1. 
Since A[i]-1 is even, it can be made 0 by the above 
strategy. Therefore an odd element can reduce 
its size to 1.

Therefore, two odd elements can be made 0 by following the 
above strategy and finally XOR them (i.e., 1) as 1 XOR 1 = 0.

Therefore if the number of odd elements in the array 
is even, the answer is possible. Otherwise, an element 
of value 1 will be left, and it is impossible 
to satisfy the condition.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(ArrayList < Integer > A) {
        int cnt = 0;
        for (int x: A) {
            if (x % 2 == 1)
                cnt++;
        }
        // checks the parity of the number of odd elements
        if (cnt % 2 == 1)
            return "No";
        else
            return "Yes";
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        let i, ctr = 0;
        for (i = 0; i < A.length; i++) {
            if (A[i] % 2) {
                ctr++;
            }
        }
        // checks the parity of the number of odd elements
        if (ctr % 2) {
            return "No";
        } else {
            return "Yes";
        }
    },
};
```
* * Solution in C++
```cpp
string Solution::solve(vector < int > & A) {
    int i, ctr = 0;
    for (i = 0; i < A.size(); i++) {
        if (A[i] % 2)
            ctr++;
    }
    // checks the parity of the number of odd elements
    if (ctr % 2)
        return "No";
    else
        return "Yes";
}
```

