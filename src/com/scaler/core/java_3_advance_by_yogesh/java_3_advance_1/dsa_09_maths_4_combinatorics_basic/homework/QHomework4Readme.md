### Q4. Rectangle Area
#### Problem Description
```text
Given eight integers A, B, C, D, E, F, G, and H, which 
represent two rectangles in a 2D plane.

For the first rectangle, its bottom left corner is (A, B), 
and the top right corner is (C, D), and for the second 
rectangle, its bottom left corner is (E, F), and the top 
right corner is (G, H).

Find and return the overlapping area of the two rectangles.
```
#### Problem Constraints

<ul>
<li>-10<sup>4</sup> &lt;= A &lt;= C &lt;= 10<sup>4</sup></li>
<li>-10<sup>4</sup> &lt;= B &lt;= D &lt;= 10<sup>4</sup></li>
<li>-10<sup>4</sup> &lt;= E &lt;= G &lt;= 10<sup>4</sup></li>
<li>-10<sup>4</sup> &lt;= F &lt;= H &lt;= 10<sup>4</sup></li>
</ul>

```text
-10^4 <= A <= C <= 10^4
-10^4 <= B <= D <= 10^4
-10^4 <= E <= G <= 10^4
-10^4 <= F <= H <= 10^4
```
#### Input Format
```text
The eight arguments given are the integers A, B, C, D, E, F, G and H.
```
#### Output Format
```text
Return the overlapping area of the two rectangles.
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
 4

Output 2:
 1
```
#### Example Explanation
```text
Not available 
```
### Hints
* Hint 1
```text
It is easy to observe that the intersection part will be a rectangle.
```
* Solution Approach
```text
For area of intersecting part,
x_distance for intersecting rectangle = min(c,g) – max(a,e)
y_distance for 1st rectangle = min(d,h) – max(b,f)

Area = x_distance * y_distance
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        // x-distance for intersecting rectangle
        int x = Math.min(G, C) - Math.max(A, E);
        // y-distance for intersecting rectangle
        int y = Math.min(D, H) - Math.max(B, F);
        int area = x * y;
        if(x < 0 || y < 0)
            area = 0;
        return area;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A, B, C, D, E, F, G, H) {
        // x-distance for intersecting rectangle
        let x = Math.min(G, C) - Math.max(A, E);
        // y-distance for intersecting rectangle
        let y = Math.min(D, H) - Math.max(B, F);
        let area = x * y;
        if (x < 0 || y < 0) 
            area = 0;
        return area;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(int A, int B, int C, int D, int E, int F, int G, int H) {
    // x-distance for intersecting rectangle
    int x = min(G, C) - max(A, E);
    // y-distance for intersecting rectangle
    int y = min(D, H) - max(B, F);
    int area = x * y;
    if(x < 0 || y < 0)
        area = 0;
    return area;
}
```

