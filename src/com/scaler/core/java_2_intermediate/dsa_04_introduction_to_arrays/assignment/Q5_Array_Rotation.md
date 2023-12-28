### Q5. Array Rotation
#### Problem Description
```text
Given an integer array A of size N and an integer B, you have 
to return the same array after rotating it B times 
towards the right.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;=10<sup>9</sup></p>
    <p>1 &lt;= B &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 10^5
1 <= A[i] <=10^9
1 <= B <= 10^9
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is the integer B.
```
#### Output Format
```text
Return the array A after rotating it B times to the right
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4]
 B = 2

Input 2:
 A = [2, 5, 6]
 B = 1
```
#### Example Output
```text
Output 1:
 [3, 4, 1, 2]

Output 2:
 [6, 2, 5]
```
#### Example Explanation
```text
Explanation 1:
    Rotate towards the 
    right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]

Explanation 2:
    Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]
```
### Hints
* Hint 1
```text
Can we reverse certain parts of an array to rotate it by B times?
```
* Solution Approach
```text
Let n be the length of the array.
Rotating an array by n and 2 * n times gives the same 
results, i.e., rotating i or i % n times is the same.

So, we update B to B % n.

When we rotate the array B times, B elements from the back end 
of the array come to the front and the rest of the elements 
from the front shift backward.

In this approach, we firstly reverse all the elements of the array. 

Then, reversing the first B elements followed by reversing 
the rest N - B elements gives us the required result.

Time Complexity : O(N)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    void reverse(int[] A, int start, int end) {
        int i, j;
        for (i = start, j = end; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    public int[] solve(int[] A, int B) {
        int n = A.length;
        B = B % n;
        reverse(A, 0, n - 1);
        reverse(A, 0, B - 1);
        reverse(A, B, n - 1);
        return A;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
void reverse(vector < int > & A, int start, int end) {
    int i, j;
    for (i = start, j = end; i < j; i++, j--) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
vector<int> Solution::solve(vector<int> &A, int B) {
	int N = A.size();
	B = B % N;
    reverse(A, 0, N - 1);
    reverse(A, 0, B - 1);
    reverse(A, B, N - 1);
	return A;
}
```

