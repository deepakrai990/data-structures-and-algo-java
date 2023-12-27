### Q1. Square Root of Integer
#### Problem Description
```text
Given an integer A.

Compute and return the square root of A.

If A is not a perfect square, return floor(sqrt(A)).

DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.

NOTE: Do not use the sqrt function from the standard 
library. Users are expected to solve this in O(log(A)) time.
```
#### Problem Constraints
* <p>0 &lt;= A &lt;= 10<sup>10</sup></p>
```text
0 <= A <= 10^10
```
#### Input Format
```text
The first and only argument given is the integer A.
```
#### Output Format
```text
Return floor(sqrt(A))
```
#### Example Input
```text
Input 1:
 11

Input 2:
 9
```
#### Example Output
```text
Output 1:
 3

Output 2:
 3
```
#### Example Explanation
```text
Explanation:
 When A = 11 , square root of A = 3.316. It is not a perfect 
 square so we return the floor which is 3.
 
 When A = 9 which is a perfect square of 3, so we return 3.
```
### Hints
* Hint 1
```text
Think about the answer of this “Is a particular number r less 
than or equal to floor(sqrt(x))?”

The answer to the above problem as a function of r will look 
like [1,1,……1,0,0……0]. Can you use this fact to devise a solution now?
```
* Solution Approach
```text
Think in terms of binary search.

Let us say S is the answer.

We know that 0 <= S <= x.

Consider any random number r.

    *. If r * r <= x, S >= r , i.e. S would lie towards right of r

    *. If r * r > x, S < r. , i.e. S would lie towards left of r

Maybe try to run a binary search for S.
```
* Complete Solution
```java
public class Solution {
   public int sqrt(int A) {
      int low = 1, high = A, root = 0;
      while (low <= high) {
         int mid = (low + high) / 2;
         if (mid == A / mid && (A % mid == 0))
            return mid;
         if (mid <= A / mid) {
            root = mid;
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }
      return root;
   }
}
```