### Q2. Alternating Subarrays Easy
#### Problem Description
```text
You are given an integer array A of length N comprising 
of 0's & 1's, and an integer B.

You have to tell all the indices of array A that can act as a 
center of 2 * B + 1 length 0-1 alternating subarray.

A 0-1 alternating array is an array containing only 0's & 1's, and 
having no adjacent 0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] 
and [1] are 0-1 alternating, 
while [1, 1] and [0, 1, 0, 0, 1] are not.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>1 &lt;= N &lt;= 10<sup>3</sup></p>
    <p>A[i] equals to 0 or 1.</p>
    <p>0 &lt;= B &lt;= (N - 1) / 2</p>
</div>

```text
1 <= N <= 10^3
A[i] equals to 0 or 1.
0 <= B <= (N - 1) / 2
```
#### Input Format
```text
First argument is an integer array A.

Second argument is an integer B.
```
#### Output Format
```text
Return an integer array containing indices(0-based) in 
sorted order. If no such index exists, return an 
empty integer array.
```
#### Example Input
```text
Input 1:
 A = [1, 0, 1, 0, 1]
 B = 1 

Input 2:
 A = [0, 0, 0, 1, 1, 0, 1]
 B = 0 
```
#### Example Output
```text
Output 1:
 [1, 2, 3]

Output 2:
 [0, 1, 2, 3, 4, 5, 6]
```
#### Example Explanation
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>Explanation 1:</p>
    <pre> Index 1 acts as a centre of alternating sequence: 
    <strong>[A<sub>0</sub>, A<sub>1</sub>, A<sub>2</sub>]</strong>
    Index 2 acts as a centre of alternating sequence: 
    <strong>[A<sub>1</sub>, A<sub>2</sub>, A<sub>3</sub>]</strong>
    Index 3 acts as a centre of alternating sequence: 
    <strong>[A<sub>2</sub>, A<sub>3</sub>, A<sub>4</sub>]</strong> </pre>
    <p>Explanation 2:</p>
    <pre> Each index in the array acts as the center of 
    alternating sequences of lengths 1.</pre>
</div>

```text
Explanation 1:
     Index 1 acts as a centre of alternating sequence: [A0, A1, A2]
     Index 2 acts as a centre of alternating sequence: [A1, A2, A3]
     Index 3 acts as a centre of alternating sequence: [A2, A3, A4] 

Explanation 2:
     Each index in the array acts as the center of alternating 
     sequences of lengths 1.
```

### Hints
* Hint 1
```text
Since, the length of the subarray is fixed, can you find a brute force approach?
```
* Solution Approach
```text
Since, the length of the given required subarray is fixed, and 
the constraints allow an O(N ^ 2) approach.

We can simply brute force for each subarray for length 2 * B + 1.

We will loop from each starting point of every possible 
subarray, and check if the adjacent elements are unequal.

We can keep a flag variable to keep track of the status 
throughout the subarray.

If the condition is true, then we will append to a list 
that we will return.

Refer to the complete solution for more implementation details.
```
* Complete Solution
* * Solution in Java
```java
class Solution {
    public int[] solve(int[] A, int B) {
        ArrayList<Integer> l1 = new ArrayList<>();
        int n = A.length;
        int len = 2 * B + 1;
        for (int i = 0; i < n - len + 1; i++) {
            int curr = -1;
            int flag = 1;
            for (int j = i; j < i + len; j++) {
                if (A[j] == curr) {
                    flag = 0;
                    break;
                }
                curr = A[j];
            }
            if (flag == 1) {
                l1.add(i + B);
            }
        }
        int[] ret = new int[l1.size()];
        for (int i = 0; i < l1.size(); i++) {
            ret[i] = l1.get(i);
        }
        return ret;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
vector < int > Solution::solve(vector < int > & A, int B) {
    assert(A.size() >= 1 && A.size() <= 1000);
    for (auto & x: A) assert(x >= 0 && x <= 1);
    assert(B >= 0 && B <= ((A.size() - 1) / 2));
    vector < int > l1;
    int n = A.size();
    int len = 2 * B + 1;
    for (int i = 0; i < n - len + 1; i++) {
        int curr = -1;
        int flag = 1;
        for (int j = i; j < i + len; j++) {
            if (A[j] == curr) {
                flag = 0;
                break;
            }
            curr = A[j];
        }
        if (flag == 1) {
            l1.push_back(i + B);
        }
    }
    return l1;
}
```

