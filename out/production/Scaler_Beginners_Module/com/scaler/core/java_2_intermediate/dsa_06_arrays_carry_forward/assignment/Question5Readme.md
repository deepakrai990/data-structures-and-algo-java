### Q5. Closest MinMax
#### Problem Description
```text
Given an array A, find the size of the smallest subarray such that 
it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.
```
#### Problem Constraints
```text
1 <= |A| <= 2000
```
#### Input Format
```text
First and only argument is vector A
```
#### Output Format
```text
Return the length of the smallest subarray which has at least one 
occurrence of minimum and maximum element of the array
```
#### Example Input
```text
Input 1:
 A = [1, 3]

Input 2:
 A = [2]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Only choice is to take both elements.

Explanation 2:
    Take the whole array.
```
### Hints
* Hint 1
```text
One simple thing can be to generate all possible subarray and then 
compute the ans, but can we do better?

If we know the last occurrence of the min and max element in a 
particular subarray under consideration, can we do something?
```
* Solution Approach
```text
This problem can be solved in a simple O(N) complexity.

We can implement a sliding window kind of algorithm using 
two pointers. We can slide over the array and keep track of 
every last occurrence of the minimum and maximum 
element of the array.

In order to find the start point, we can simply remember the 
last occurrences of a minimum and a maximum value, 
respectively. And for each min-max pair, we check the length 
of the subarray that encloses them and then update out 
overall based on that.

Time Complexity : O(n)
Space Complexity(extra) : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {

        int min_ele = Integer.MAX_VALUE, max_ele = Integer.MIN_VALUE;   // min and max value of the array
        int min_Index = -1, max_Index = -1; // index of the last element having value equal to min_ele and max_ele

        int ans = Integer.MAX_VALUE;
        for (int x : A) {
            min_ele = Math.min(min_ele, x);
            max_ele = Math.max(max_ele, x);
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == min_ele) min_Index = Math.max(min_Index, i);
            if (A[i] == max_ele) max_Index = Math.max(max_Index, i);

            if (min_Index != -1 && max_Index != -1) {
                int len = Math.abs(max_Index - min_Index) + 1;
                ans = Math.min(ans, len);
            }
        }

        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    solve: function (A) {
        let mx = Math.max(...A), mn = Math.min(...A), ans = A.length;
        // mx and mn stores the max and min value of the array
        let max_index = -1e9, min_index = -1e9 / 2;
        // index of the last element having value equal to mx and mn
        for (let i = 0; i < A.length; i++) {
            if (A[i] == mx) {
                max_index = i;
            }
            if (A[i] == mn) {
                min_index = i;
            }
            ans = Math.min(ans, Math.abs(min_index - max_index) + 1);
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
typedef int ll;
int Solution::solve(vector<int> &A) {
        int mn = *min_element(A.begin(), A.end()); //min value of the array
        int mx = *max_element(A.begin(), A.end()); //max value of the array
        int inf = 1000000000;
        int last_min = -inf; //index of the last element having value equal to mn
        int last_max = - inf / 2; //index of the last element having value equal to mx
        int result = inf;
        
        for (int i = 0; i < int(A.size()); i += 1) {
            if (A[i] == mn) {
                last_min = i;
            }
    
            if (A[i] == mx) {
                last_max = i;
            }
    
            result = min(result, abs(last_min - last_max) + 1); 
        }
        return result;
}
```

