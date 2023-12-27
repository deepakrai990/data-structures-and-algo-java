### Q3. Another Coin Problem
#### Problem Description
```text
The monetary system in DarkLand is really simple and systematic. The locals-only 
use coins. The coins come in different values. The values used are:

 1, 5, 25, 125, 625, 3125, 15625, ...
Formally, for each K >= 0 there are coins worth 5^K.

Given an integer A denoting the cost of an item, find and return the smallest 
number of coins necessary to pay exactly the cost of the item (assuming you have a 
sufficient supply of coins of each of the types you will need).
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 2×10<sup>9</sup></p>
</div>

```text
1 <= A <= 2×10^9
```
#### Input Format
```text
The only argument given is integer A.
```
#### Output Format
```text
Return the smallest number of coins necessary to pay exactly the cost of the item.
```
#### Example Input
```text
Input 1:
 A = 47

Input 2:
 A = 9
```
#### Example Output
```text
Output 1:
 7

Output 2:
 5
```
#### Example Explanation
```text
Explanation 1:
    Representation of 7 coins will be : (1 + 1 + 5 + 5 + 5 + 5 + 25).

Explanation 2:
    Representation of 5 coins will be : (1 + 1 + 1 + 1 + 5).
```
### Hints
* Hint 1
```text
Think of a Greedy solution, i.e., pick the largest coin possible for the current amount.
```
* Solution Approach
```text
We will use the Greedy solution.

Start from the largest possible denomination and keep adding denominations while 
the remaining value is greater than 0.

The number of the chosen coin is determined by the A/(coin value).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        ArrayList<Integer> v = new ArrayList<Integer>();

        int val = 1;

        // Storing all denominations of coins
        while (val <= 2000000000) {
            v.add(val);
            val = val * 5;
        }
        // Sort in decreasing order
        Collections.reverse(v);

        int ans = 0;
        // Loop from the largest denomination
        for (int i = 0; i < v.size(); i++) {
            ans += A / v.get(i);
            A = A % v.get(i);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        let ans = 0;
        while (A > 0) {
            ans += A % 5;
            A = Math.floor(A / 5);
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
/** Approach 1: **/

int Solution::solve(int A) {
    // Store all the denominations of coins less than equal to 2 * 10^9
    vector < int > v;

    long long val = 1;

    // Storing all denominations of coins
    while (val <= 2e9) {
        v.push_back(val);
        val = val * 5;
    }
    // Sort in decreasing order
    reverse(v.begin(), v.end());

    int ans = 0;
    // Loop from the largest denomination
    for (int i = 0; i < v.size(); i++) {
        ans += A / v[i];
        A = A % v[i];
    }
    return ans;
}

/** Approach 2: **/

int Solution::solve(int A) {
    int ans = 0;
    while (A > 0) {
        ans += (A % 5);
        A /= 5;
    }
    return ans;
}
```

