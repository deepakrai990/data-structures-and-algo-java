### Q4. Finding Good Days
#### Problem Description
```text
Alex has a cat named Boomer. He decides to put his cat to the 
test for eternity.

He starts on day 1 with one stash of food unit, every 
next day, the stash doubles.

If Boomer is well behaved during a particular day, only then 
she receives food worth equal to the stash produced on that day.

Boomer receives a net worth of A units of food. What is the 
number of days she received the stash?
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 2<sup>31</sup>-1</p>
</div>

```text
1 <= A <= 2^31-1
```
#### Input Format
```text
First and only argument is an integer A.
```
#### Output Format
```text
Return an integer denoting the number of days Boomer was well behaved.
```
#### Example Input
```text
Input 1:
 A = 5

Input 2:
 A = 8
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    To eat a total of 5 units of food, Boomer behaved normally on 
    Day 1 and on the Day 3.

Explanation 2:
    To eat a total of 8 units of food, Boomer behaved normally 
    only on day 4.
```
### Hints
* Hint 1
```text
Can you try thinking of each day as bits of A and
then thinking up a solution?
```
* Solution Approach
<div>
    <p>Since for each day, the food doubles up as the previous 
    day with 1 unit on the first day, starting from i = 0,<br>
    the number of food units Boomer was supposed to get 
    on i<sup>th</sup> day is 2<sup>i</sup>.</p>
    <p>Only on the days he was well behaved did he get food. So 
    adding the power of 2 on each day, he was well behaved,<br>
    gives the total number of food units, i.e., A.</p>
    <p>Hence, the number of 1’s in the binary representation 
    of A is the number of days he was well behaved.</p>
</div>

```text
Since for each day, the food doubles up as the previous day 
with 1 unit on the first day, starting from i = 0, the number 
of food units Boomer was supposed to get on i^th day is 2^i.

Only on the days he was well behaved did he get food. So adding 
the power of 2 on each day, he was well behaved, gives the 
total number of food units, i.e., A.

Hence, the number of 1’s in the binary representation of A is 
the number of days he was well behaved.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        //We need to find the number of set bits in binary representation of A
        int ans = 0;
        while (A > 0) {
            if (A % 2 == 1) ans++;
            A /= 2;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : integer
    //return an integer
    solve: function (A) {

        let ans = 0;
        while (A > 0) {

            if ((A & 1) > 0) ans++;
            A /= 2;
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
int countSetBits(int n){
    // base case
    if (n == 0)
        return 0;
    else
        // if last bit set add 1 else add 0
        return (n & 1) + countSetBits(n >> 1);
}
int Solution::solve(int A) {
    return countSetBits(A);
}
```

