### Q5. Find nth Magic Number
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given an integer <strong>A</strong>, find and return 
    the <strong>A<sup>th</sup></strong> magic number.</p>
    <p>A magic number is defined as a number that can be 
    expressed as a power of 5 or a sum 
    of <strong>unique</strong> powers of 5.</p>
    <p>First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….</p>
</div>

```text
Given an integer A, find and return the A^th magic number.

A magic number is defined as a number that can be expressed 
as a power of 5 or a sum of unique powers of 5.

First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
```
#### Problem Constraints
```text
1 <= A <= 5000
```
#### Input Format
```text
The only argument given is integer A.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return the A<sup>th</sup> magic number.</p>
</div>

```text
Return the A^th magic number.
```
#### Example Input
```text
Example Input 1:
 A = 3

Example Input 2:
 A = 10
```
#### Example Output
```text
Example Output 1:
 30

Example Output 2:
 650
```
#### Example Explanation
```text
Explanation 1:
    Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
    3rd element in this is 30

Explanation 2:
    In the sequence shown in explanation 1, 10th element will be 650.
```
### Hints
* Hint 1
```text
Can you create this full array somehow?
What will be the time required to create it?
```
* Solution Approach
<div><pre>As we know **5<sup>n</sup> &gt; 5<sup>1</sup> + 5<sup>2</sup> + ... + 5<sup>n-1</sup>**
So, we can find the sum of all subsets of the first 13 power of 5.
since no element will overlap, we will have 2^13 - 1 elements or 8000 elements.
Simply sort them and answer the query in O(1).
Time Complexity: O(A*logA).

Else we can use a much faster approach.
We can represent A in its binary representation.
If the i<sup>th</sup> bit(1 based indexing) is set we will add 5<sup>i</sup> to our answer.
Time Complexity:- O(log(A))
</pre></div>

```text
As we know **5^n > 5^1 + 5^2 + ... + 5^(n-1)**

So, we can find the sum of all subsets of the first 13 power of 5.
since no element will overlap, we will have 2^13 - 1 elements or 8000 elements.

Simply sort them and answer the query in O(1).

Time Complexity: O(A*logA).

Else we can use a much faster approach.

We can represent A in its binary representation.

If the ith bit(1 based indexing) is set we will add 5i to our answer.

Time Complexity:- O(log(A))
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        int ans = 0, x = 1;
        // converting to binary representation
        while(A > 0) {
            x *= 5;
            if(A % 2 == 1)    
                ans += x;
            A /= 2;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
	solve : function(A){
        let ans = 0, x = 1;
        // converting to binary representation
        while(A > 0) {
            x *= 5;
            if(A % 2 == 1)
                ans += x;
            A = Math.floor(A / 2);
        }
        return ans;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    int ans = 0, x = 1;
    // converting to binary representation
    while(A > 0) {
        x *= 5;
        if(A % 2 == 1)    
            ans += x;
        A /= 2;
    }
    return ans;
}
```

