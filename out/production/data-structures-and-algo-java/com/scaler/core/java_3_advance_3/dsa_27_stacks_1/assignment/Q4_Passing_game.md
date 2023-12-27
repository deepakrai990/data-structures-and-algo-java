### Q4. Passing game
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>There is a football event going on in your city. In this 
    event, you are given <strong>A</strong> passes and players 
    having ids between <strong>1</strong> and 
    <strong>10<sup>6</sup></strong>.</p>
    <p>Initially, some player with a given id had the ball in 
    his possession. You have to make a program to display the 
    id of the player who possessed the ball after exactly A passes.</p>
    <p>There are two kinds of passes:</p>
    <p>1) ID</p>
    <p>2) 0</p>
    <p>For the first kind of pass, the player in possession of the 
    ball passes the ball "forward" to the player with id = ID.</p>
    <p>For the second kind of pass, the player in possession of 
    the ball passes the ball back to the player who had forwarded 
    the ball to him.</p>
    <p>In the second kind of pass "0" just means Back Pass.</p>
    <p>Return the ID of the player who currently possesses the ball.</p>
</div>

```text
There is a football event going on in your city. In this event, 
you are given A passes and players having ids between 1 and 10^6.

Initially, some player with a given id had the ball in his 
possession. You have to make a program to display the id of the 
player who possessed the ball after exactly A passes.

There are two kinds of passes:

1) ID

2) 0

For the first kind of pass, the player in possession of the ball 
passes the ball "forward" to the player with id = ID.

For the second kind of pass, the player in possession of the 
ball passes the ball back to the player who had forwarded the ball to him.

In the second kind of pass "0" just means Back Pass.

Return the ID of the player who currently possesses the ball.
```
#### Problem Constraints
```text
1 <= A <= 100000

1 <= B <= 100000

|C| = A
```
#### Input Format
```text
The first argument of the input contains the number A.

The second argument of the input contains the 
number B ( id of the player possessing the ball in the very beginning).

The third argument is an array C of size A having (ID/0).
```
#### Output Format
```text
Return the "ID" of the player who possesses the ball after A passes.
```
#### Example Input
```text
Input 1:
 A = 10
 B = 23
 C = [86, 63, 60, 0, 47, 0, 99, 9, 0, 0]

Input 2:
 A = 1
 B = 1
 C = [2]
```
#### Example Output
```text
Output 1:
 63

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    Initially, Player having  id = 23  posses ball. 
    After pass  1,  Player having  id = 86  posses ball. 
    After pass  2,  Player having  id = 63  posses ball. 
    After pass  3,  Player having  id = 60  posses ball. 
    After pass  4,  Player having  id = 63  posses ball. 
    After pass  5,  Player having  id = 47  posses ball. 
    After pass  6,  Player having  id = 63  posses ball. 
    After pass  7,  Player having  id = 99  posses ball. 
    After pass  8,  Player having  id = 9   posses ball. 
    After pass  9,  Player having  id = 99  posses ball. 
    After pass  10, Player having  id = 63   posses ball.

Explanation 2:
    Ball is passed to 2.
```
### Hints
* Hint 1
```text
We need to remove and add the player ids who currently hold the ball.
We have a data structure that supports this operation.
Can we use that for this problem?
```
* Solution Approach
```text
This question depends on your data structure knowledge as you 
can quickly solve this question using a suitable data structure 
which is the stack in our question.

You have two types of instructions in this question:

    1. So you can easily push the new id in the stack to keep 
       track of the latest player who has the ball.
    2. Now, you should pass the ball to the previous player 
       who forwarded you the ball, so you can easily pop the 
       last player from the stack.

Time Complexity:- O(A)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B, int[] C) {
        Stack < Integer > st = new Stack < Integer > ();
        st.push(B);
        for (int x: C) {
            // pop from stack
            if (x == 0) st.pop();
            // push the given ID to stack
            else st.push(x);
        }
        return st.peek();
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A, B, C) {
        let stk = [];
        stk.push(B);
        C.forEach((i) => {
            // pop from stack
            if (i == 0) stk.pop();
            // push the given ID to stack
            else stk.push(i);
        });
        return stk[stk.length - 1];
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(int A, int B, vector < int > & C) {
    stack < int > stk;
    stk.push(B);
    for (int i: C) {
        // pop from stack
        if (i == 0)
            stk.pop();
        // push the given ID to stack
        else
            stk.push(i);
    }
    return stk.top();
}
```

