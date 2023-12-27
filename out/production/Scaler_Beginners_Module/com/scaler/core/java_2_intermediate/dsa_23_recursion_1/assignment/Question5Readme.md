### Q5. Print A to 1 function
#### Problem Description
```text
You are given an integer A, print A to 1 using using recursion.
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
Print A space-separated integers A to 1.

Note: There should be exactly one space after each 
      integer. Print a new line after printing the A integers
```
#### Example Input
```text
Input 1:
 10

Input 2:
 5
```
#### Example Output
```text
Output 1:
 10 9 8 7 6 5 4 3 2 1 

Output 2:
 5 4 3 2 1 
```
#### Example Explanation
```text
Explanation 1:
    Print 10 to 1 space separated integers.
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

Otherwise, we print A followed by a space and after that call 
the recursive function for (A - 1)

Outside the recursion we print new line.

Time Complexity : O(A)
Space Complexity : O(A)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public void printAto1(int A) {
        if (A == 0) {
            return;
        }
        System.out.print(A + " ");
        printAto1(A - 1);
    }

    public void solve(int A) {
        printAto1(A);
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
void printAto1(int A){
    if(A == 0){
        return;
    }
    cout<<A<<" ";
    printAto1(A - 1);
}
void Solution::solve(int A) {
	printAto1(A);
	cout<<endl;
}
```

