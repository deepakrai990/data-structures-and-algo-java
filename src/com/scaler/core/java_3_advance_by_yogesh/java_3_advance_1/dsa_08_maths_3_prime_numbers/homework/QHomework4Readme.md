### Q4. Find if two rectangles overlap
#### Problem Description
```text
Eight integers A, B, C, D, E, F, G, and H represent two 
rectangles in a 2D plane.

For the first rectangle, its bottom left corner is (A, B), and 
the top right corner is (C, D), and for the second 
rectangle, its bottom left corner is (E, F), and the top 
right corner is (G, H).

Find and return whether the two rectangles overlap or not.
```
#### Problem Constraints
```text
-10000 <= A < C <= 10000

-10000 <= B < D <= 10000

-10000 <= E < G <= 10000

-10000 <= F < H <= 10000
```
#### Input Format
```text
The eight arguments are integers A, B, C, D, E, F, G, and H.
```
#### Output Format
```text
Return 1 if the two rectangles overlap else, return 0.
```
#### Example Input
```text
Input 1:
 A = 0   B = 0
 C = 4   D = 4
 E = 2   F = 2
 G = 6   H = 6

Input 2:
 A = 0   B = 0
 C = 4   D = 4
 E = 2   F = 2
 G = 3   H = 3
```
#### Example Output
```text
Output 1:
 1

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Rectangle with bottom left (2, 2) and top right (4, 4) is overlapping.

Explanation 2:
    Overlapping rectangles can be found.
```
### Hints
* Hint 1
```text
Try drawing a few rectangles.

Can you distinguish some properties that separate 
two non-overlapping rectangles from overlapping ones?
```
* Solution Approach
```text
You can formulate the required conditions.

First, we can see if a foot of one rectangle 
is >= top of another rectangle, then an answer 
is not possible.

You can make a similar argument about the y-axis.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        // check if the rectangles overlap
        int xs = Math.max(A, E), xe = Math.min(C, G);
        int ys = Math.max(B, F), ye = Math.min(D, H);
        if (xs < xe && ys < ye)
            return 1;
        else
            return 0;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
	solve : function(A, B, C, D, E, F, G, H){
	    // check if the rectangles overlap
        return +(!(A >= G || E >= C || B >= H || F >= D));
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(int A, int B, int C, int D, int E, int F, int G, int H) {
    // check if the rectangles overlap
    if (A >= G || E >= C)
        return 0;
    if (D <= F || H <= B)
        return 0;
    return 1;
}
```

