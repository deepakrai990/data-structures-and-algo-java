### Q1. Single Number III
#### Problem Description
```text
Given an array of positive integers A, two integers appear 
only once, and all the other integers appear twice.
Find the two integers that appear only once.

Note: Return the two numbers in ascending order.
```
#### Problem Constraints
* <p>2 &lt;= |A| &lt;= 100000</p>
* <p> 1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
```text
2 <= |A| <= 100000
1 <= A[i] <= 10^9
```
#### Input Format
```text
The first argument is an array of integers of size N.
```
#### Output Format
```text
Return an array of two integers that appear only once.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 1, 2, 4]

Input 2:
 A = [1, 2]
```
#### Example Output
```text
Output 1:
 [3, 4]

Output 2:
 [1, 2]
```
#### Example Explanation
```text
Explanation 1:
    3 and 4 appear only once.

Explanation 2:
    1 and 2 appear only once.
```
### Hints
* Hint 1
```text
Think about the operations which give 0 on applying between 
the same elements.
Think about the solution with and without extra memory.
```
* Solution Approach

<p>If we use additional memory, we can directly store the count 
and find the integers which occur only once.<br>
To solve without additional memory, We can use the xor operation, as 
the Xor of two integers gives 0.<br>
Take the Xor of all the integers of the array. Integers that occur 
twice will not contribute anything to the xor value.<br>
Suppose that the i<sup>th</sup> bit is set in the xor value, 
which means that exactly one of the two required numbers 
has that bit set.<br>
If we then divide the array integers into two groups: one group 
contains all integers with the ith bit set, and the other group 
contains integers with 0 at the i<sup>th</sup> bit. <br>
Each group includes one of the two required numbers, and for 
the rest of the numbers, both of their occurrences will be in 
the same group.<br>
Now, Xor of integers in the first group gives a number that 
occurs exactly once. Xor of integers in the second group 
provides another number that appears exactly once.</p>

```text
If we use additional memory, we can directly store the count 
and find the integers which occur only once.

To solve without additional memory, We can use the xor operation, 
as the Xor of two integers gives 0.

Take the Xor of all the integers of the array. Integers that 
occur twice will not contribute anything to the xor value.

Suppose that the i th bit is set in the xor value, which 
means that exactly one of the two required numbers has that bit set.

If we then divide the array integers into two groups: one group 
contains all integers with the ith bit set, and the other group 
contains integers with 0 at the i th bit.

Each group includes one of the two required numbers, and for 
the rest of the numbers, both of their occurrences will be 
in the same group.

Now, Xor of integers in the first group gives a number that 
occurs exactly once. Xor of integers in the second group 
provides another number that appears exactly once.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A) {
        int aXorb = 0; // the result of a xor b
        for (int item: A)
            aXorb ^= item;
        int lastBit = (aXorb & (aXorb - 1)) ^ aXorb; // the last bit that a differs from b
        int intA = 0, intB = 0;
        for (int item: A) {
            // based on the last bit, group the items into groupA (include a) and groupB
            if ((item & lastBit) != 0)
                intA = intA ^ item;
            else
                intB = intB ^ item;
        }
        int x = Math.min(intA, intB), y = Math.max(intA, intB);
        int[] ans = new int[2];
        ans[0] = x;
        ans[1] = y;
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        let xor = 0;    // the result of a xor b
        A.forEach((ele) => (xor ^= ele));
        let lastBit = (xor & (xor - 1)) ^ xor;  // the last bit that a differs from b
        let grA = 0, grB = 0;
        A.forEach((ele) => {
            // based on the last bit, group the items into groupA (include a) and groupB
            if (ele & lastBit) 
                grA ^= ele;
            else 
                grB ^= ele;
        });
        if (grA > grB) 
            [grA, grB] = [grB, grA];
        return [grA, grB];
    },
};
```
* * Solution in C++
```cpp
vector < int > Solution::solve(vector < int > & A) {
    int val = 0; // the result of a xor b
    for (auto x: A)
        val ^= x;
    int mask = (val & (val - 1)) ^ val; // the last bit that a differs from b
    int intA = 0, intB = 0;
    for (auto x: A) {
        // based on the last bit, group the items into groupA (include a) and groupB
        if (x & mask)
            intA = intA ^ x;
        else
            intB = intB ^ x;
    }
    int x = min(intA, intB), y = max(intA, intB);
    return vector < int > {x, y};
}
```
