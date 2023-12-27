### Q4. Print 1 to A function
#### Problem Description
```text
You are given an integer A, print 1 to A using using recursion.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 10<sup>4</sup></p>
</div>

```text
1 <= A <= 10^4
```
#### Input Format
```text
First argument A is an integer.
```
#### Output Format
```text
Print A space-separated integers 1 to A.

Note: There should be exactly one space after each 
      integer. After printing all the integers, print a new line
```
#### Example Input
```text
Input 1:
 A = 10

Input 2:
 A = 5
```
#### Example Output
```text
Output 1:
 1 2 3 4 5 6 7 8 9 10 

Output 2:
 1 2 3 4 5 
```
#### Example Explanation
```text
Explanation 1:
    Print 1 to 10 space separated integers.
```
### Hints
* Hint 1
```text
Recursive call the function for all values from A
to 1.
```
* Solution Approach
```text
We write a recursive function.

The base case is when A = 0 when we return from
the function.

Otherwise, we call the recursive function for (A - 1)
and after that print A followed by space.

Outside the recursion we print new line.

Time Complexity : O(A)
Space Complexity : O(A)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public void print1toA(int A) {
        if (A == 0) {
            return;
        }
        print1toA(A - 1);
        System.out.print(A + " ");
    }

    public void solve(int A) {
        print1toA(A);
        System.out.print("\n");
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
void print1toA(int A){
    if(A == 0){
        return;
    }
    print1toA(A - 1);
    cout<<A<<" ";
}
void Solution::solve(int A) {
	print1toA(A);
	cout<<endl;
}
```

