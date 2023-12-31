### Q3. Pubg
#### Problem Description
```text
There are N players, each with strength A[i]. when player i attack 
player j, player j strength reduces to max(0, A[j]-A[i]). 
When a player's strength reaches zero, it loses the game, and 
the game continues in the same manner among other players 
until only 1 survivor remains.

Can you tell the minimum health last surviving person can have?
```
#### Problem Constraints
```text
    . 1 <= N <= 100000

    . 1 <= A[i] <= 1000000
```
#### Input Format
```text
First and only argument of input contains a single integer array A.
```
#### Output Format
```text
Return a single integer denoting minimum health of last person.
```
#### Example Input
```text
Input 1:
 A = [6, 4]

Input 2:
 A = [2, 3, 4]
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

 Given strength array A = [6, 4]
 Second player attack first player, A =  [2, 4]
 First player attack second player twice. [2, 0]


Explanation 2:

 Given strength array A = [2, 3, 4]
 First player attack third player twice. [2, 3, 0]
 First player attack second player. [2, 1, 0]
 Second player attack first player twice. [0, 1, 0]
```
### Hints
* Hint 1
```text
You can see it is always wise for a weaker player to attack a 
stronger player until only 1 player remains.

Can you use this fact to solve the question?
```
* Solution Approach
```text
Let’s consider if there were only 2 people with strength A and B (A<=B). 
then A would attack B, leading to A, B-A.
It would continue until it gets smaller than A or A, B%A. 
Then the process would repeat as A%(B%A), B%A, and so on…

You can see this is exactly what is done in Euclid GCD algorithm. 
So, the answer is always gcd of numbers.
```
* Complete Solution
```java
public class Solution {
    public int gcd(int x, int y) {
        if (x == 0)
            return y;
        return gcd(y % x, x);
    }
    public int solve(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++)
            ans = gcd(ans, A[i]);
        return ans;
    }
}
```

```javascript
module.exports = { 
	solve : function(A){
	    function gcd(a, b){
	        if(b == 0)return a;
	        return gcd(b, a % b);
	    }
        let ans = 0;
        A.forEach(ele => ans = gcd(ans, ele));
        return ans;
	}
};
```

```cpp
int Solution::solve(vector < int > & A) {
    int g = A[0];
    for (int i: A)
        g = __gcd(g, i);
    return g;
}
```

