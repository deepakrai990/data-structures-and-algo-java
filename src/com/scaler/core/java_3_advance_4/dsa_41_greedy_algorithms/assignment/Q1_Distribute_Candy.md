### Q1. Distribute Candy
#### Problem Description
```text
N children are standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    1. Each child must have at least one candy.
    2. Children with a higher rating get more candies than their neighbors.

What is the minimum number of candies you must give?
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup><br>
    -10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 10^5
-10^9 <= A[i] <= 10^9
```
#### Input Format
```text
The first and only argument is an integer array A representing the rating of children.
```
#### Output Format
```text
Return an integer representing the minimum candies to be given.
```
#### Example Input
```text
Input 1:
 A = [1, 2]

Input 2:
 A = [1, 5, 2, 1]
```
#### Example Output
```text
Output 1:
 3

Output 2:
 7
```
#### Example Explanation
```text
Explanation 1:
    The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot 
    get 1 candy as 1 is its neighbor. 
    
    So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.

Explanation 2:
    Candies given = [1, 3, 2, 1]
```
### Hints
* Hint 1
```text
Would greedily assigning the candy work here?
Where should you start from?

Should you start assigning the candies from the least rating guy to the guy with the 
most rating or vice versa?
```
* Solution Approach
```text
Greedy will work here ( Think of a supportive proof as an assignment ).

Start with the guy with the least rating. Obviously, he will receive one candy.

If he did receive more than one candy, we could lower it to 1 as none of the 
neighbors have a higher rating.

Now, let us move to the one which is the second least. If the least element is 
its neighbor, then it receives two candies, else we can get away with assigning it 
just one candy.

We keep repeating the same process to arrive at the optimal solution.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int candy(int[] A) {
        int n = A.length;
        int[] candies = new int[n + 1];
        Arrays.fill(candies, 1);
        for (int i = 2; i <= n; i++) {
            if (A[i - 1] > A[i - 2])
                candies[i] = candies[i - 1] + 1;
        }
        for (int i = n - 1; i >= 1; i--) {
            if (A[i - 1] > A[i]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int s = 0;
        for (int i = 1; i <= n; i++) s += candies[i];
        return s;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    candy: function (A) {
        let n = A.length;
        let candies = new Array(n + 1).fill(1);
        for (let i = 2; i <= n; i++) {
            if (A[i - 1] > A[i - 2]) candies[i] = candies[i - 1] + 1;
        }
        for (let i = n - 1; i >= 1; i--) {
            if (A[i - 1] > A[i]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        let s = 0;
        for (let i = 1; i <= n; i++) s += candies[i];
        return s;
    },
};
```
* * Solution in C++
```cpp
int Solution::candy(vector<int> &A) {
    int n = A.size();
    int candies[n + 1];
    for(int i = 0; i <= n; i++) 
        candies[i] = 1;
    for (int i = 2; i <= n; i++) {
        if (A[i - 1] > A[i - 2])
            candies[i] = candies[i - 1] + 1;
    }
    for (int i = n - 1; i >= 1; i--) {
        if (A[i - 1] > A[i]) {
            candies[i] = max(candies[i], candies[i + 1] + 1);
        }
    }
    int s = 0;
    for (int i = 1; i <= n; i++) s += candies[i];
    return s;
}
```

