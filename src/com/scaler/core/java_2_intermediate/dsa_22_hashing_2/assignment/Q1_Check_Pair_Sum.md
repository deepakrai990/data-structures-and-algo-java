### Q1. Check Pair Sum
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    Given an Array of integers<b> B</b>, and a 
    target sum <b>A</b>.
    Check if there exists a pair (i,j) such that 
    <b>B<sub>i</sub> + B<sub>j</sub> = A</b> and <b>i!=j</b>.
</div>

```text
Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1&lt;= Length of array <strong>B</strong> &lt;= 10<sup>3</sup><br>
    0&lt;= <strong>B<sub>i</sub></strong> &lt;=10<sup>9</sup><br>
    0&lt;= <strong>A</strong> &lt;=10<sup>9</sup>
</div>

```text
1<= Length of array B <= 10^3
0<= Bi <=10^9
0<= A <=10^9
```
#### Input Format
```text
First argument A is the Target sum, and second argument is the array B
```
#### Output Format
```text
Return an integer value 1 if there exists such pair, else return 0.
```
#### Example Input
```text
Input 1:
 A = 8   B = [3, 5, 1, 2, 1, 2]

Input 2:
 A = 21   B = [9, 10, 7, 10, 9, 1, 5, 1, 5]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
In Example 1:
It is possible to obtain sum 8 using 3 and 5.
```
### Hints
* Hint 1
```text
Try sorting the array, and see if you can think of some approach.
```
* Solution Approach
```text
Sort the given array, now we can apply two pointer based 
approach to solve this problem.

Simply maintain two pointers forward and end.Now traverse 
the array using these pointers, let the sum of 
elements under these pointers be Cur_sum.

* if Cur_sum == A , then return true.

* if Cur_sum > A , then decrease the end pointer.

* if Cur_sum < A , then increment the forward pointer.

Approach using sets

We can traverse the array B from left to right, inserting 
the elements of the array into a set.

Now for an element, we check if A - B[i] is already
present in the set or not.

Time Complexity : O(N)
Space Complexity : O(N)
where N is the size of the array B
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int[] B) {
        HashSet < Integer > set = new HashSet < Integer > ();
        for(int i = 0 ; i < B.length ; i++){
            if(set.contains(A - B[i])){
                return 1;
            }
            set.add(B[i]);
        }
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(int A, vector<int> &B) {
  sort(B.begin(), B.end());
  int i = 0, j = B.size() - 1;
  bool ans = 0;
  while (i < j)
  {
    if (B[i] + B[j] == A)
    {
      ans = true;
      break;
    }
    else if (B[i] + B[j] > A)
      j--;
    else
      i++;
  }
  return ans;
}

//Set solution
int Solution::solve(int A, vector<int> &B) {
    set<int> s;
    for(int i = 0 ; i < B.size() ; i++){
        if(s.find(A - B[i]) != s.end()){
            return 1;
        }
        s.insert(B[i]);
    }
    return 0;
}
```

