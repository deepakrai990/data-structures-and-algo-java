### Q2. Kth Symbol - Easy
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>On the first row, we write a <code>0</code>. 
    Now in every subsequent row, we look at the previous 
    row and replace each occurrence of <code>0</code> 
    with <code>01</code>, and each occurrence of 
    <code>1</code> with <code>10</code>.</p>
    <p>Given row number <strong>A</strong> and index 
    <strong>B</strong>, return the 
    <strong>B<sup>th</sup></strong> indexed symbol in 
    row <strong>A</strong>. (The values of 
    <strong>B</strong> are 0-indexed.).
    </p>
</div>

```text
On the first row, we write a 0. Now in every 
subsequent row, we look at the previous row and 
replace each occurrence of 0 with 01, and 
each occurrence of 1 with 10.

Given row number A and index B, return the B^th indexed 
symbol in row A. (The values of B are 0-indexed.).
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 20</p>
    <p>0 &lt;= B &lt; 2<sup>A - 1</sup></p>
</div>

```text
1 <= A <= 20

0 <= B < 2^(A - 1)
```
#### Input Format
```text
First argument is an integer A.

Second argument is an integer B.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return an integer denoting the 
    <strong>B<sup>th</sup></strong> indexed symbol in 
    row <strong>A</strong>.</p>
</div>

```text
Return an integer denoting the B^th indexed symbol in row A.
```
#### Example Input
```text
Input 1:
 A = 3
 B = 0

Input 2:
 A = 4
 B = 4
```
#### Example Output
```text
Output 1:
 0

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Row 1: 0
    Row 2: 01
    Row 3: 0110

Explanation 2:
    Row 1: 0
    Row 2: 01
    Row 3: 0110
    Row 4: 01101001
```
### Hints
* Hint 1
```text
Look at the constraints.
We can generate all the A rows and then find
required integer.
```
* Solution Approach
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>We will try to generate each of the rows through recursion.
    The first row will have a single integer 0.
    The subsequent rows can be found by replacing 0 with 0 and 1 and 
    replacing 1 with 1 and 0.</p>
    Time Complexity : O(2<sup>A</sup>)<br>
    Space Complexity : O(2<sup>A</sup>)
</div>

```text
We will try to generate each of the rows through recursion.
The first row will have a single integer 0.
The subsequent rows can be found by replacing 0 with 0 and 1 and 
replacing 1 with 1 and 0.

Time Complexity : O(2^A)
Space Complexity : O(2^A)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    ArrayList<Integer> A_th_Row(int A) {
        if (A == 1) {
            ArrayList<Integer> v2 = new ArrayList<>();
            v2.add(0);
            return v2;
        }
        ArrayList<Integer> v1 = A_th_Row(A - 1);
        ArrayList<Integer> v2 = new ArrayList<>();
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i) == 0) {
                v2.add(0);
                v2.add(1);
            } else {
                v2.add(1);
                v2.add(0);
            }
        }
        return v2;
    }

    public int solve(int A, int B) {
        return A_th_Row(A).get(B);
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/

```
* * Solution in C++
```cpp
vector<int> A_th_Row(int A) {
    if(A == 1){
        return {0};   
    }
    vector<int>v1 = A_th_Row(A - 1);
    vector<int>v2;
    for(auto x : v1){
        if(x == 0){
            v2.push_back(0);
            v2.push_back(1);
        }
        else{
            v2.push_back(1);
            v2.push_back(0);
        }
    }
    return v2;
}
int Solution::solve(int A, int B) {
    vector<int> v = A_th_Row(A);
    return v[B];
}
```

