### Q2. Gray Code
#### Problem Description
```text
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer A representing the total number of bits in the code, 
print the sequence of gray code.

A gray code sequence must begin with 0.
```
#### Problem Constraints
```text
1 <= A <= 16
```
#### Input Format
```text
The first argument is an integer A.
```
#### Output Format
```text
Return an array of integers representing the gray code sequence.
```
#### Example Input
```text
Input 1:

A = 2
Input 1:

A = 1
```
#### Example Output
```text
output 1:

[0, 1, 3, 2]
output 2:

[0, 1]
```
#### Example Explanation
```text
Explanation 1:

for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].
Explanation 1:

for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].
```
### Hints
* Hint 1
```text
The brute-force method would start with 0, change any of the bits, and keep track of 
the numbers already constructed.

When you run into a number where there is no possible way forward, you backtrack and 
try to change another bit instead.

This might be inefficient.

You need to come up with something smart this time.

You can notice that if a sequence is a gray code, then its reverse is also a gray code.

How can you use this to construct the solution?
```
* Solution Approach
```text
Note the following :

Let G(n) represent a gray code of n bits.
Let R(n) denote the reverse of G(n).

Note that we can construct.
G(n+1) as the following :
0G(n)
1R(n)

Where 0G(n) means all elements of G(n) prefixed with 0 bit and 1R(n) means all 
elements of R(n) prefixed with 1.

Note that the last element of G(n) and the first element of R(n) are the same. So the 
above sequence is valid.

Example G(2) to G(3) :
0 00
0 01
0 11
0 10
1 10
1 11
1 01
1 00
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Integer> grayCode(int A) {
        int n = 1 << A;
        ArrayList<Integer> result = new ArrayList<>();
        // G[n] = n ^ (n >> 1)
        for (int i = 0; i < n; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    grayCode: function (A) {
        let n = 1 << A;
        let result = [];
        // G[n] = n ^ (n >> 1)
        for (let i = 0; i < n; i++) {
            result.push(i ^ (i >> 1));
        }
        return result;
    },
};
```
* * Solution in C++
```cpp
vector < int > Solution::grayCode(int A) {
    int n = 1 << A;
    vector < int > result;
    // G[n] = n ^ (n >> 1)
    for (int i = 0; i < n; i++) {
        result.push_back(i ^ (i >> 1));
    }
    return result;
}
```

