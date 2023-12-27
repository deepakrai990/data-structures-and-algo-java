### QQ3. Minimum Swaps 2
#### Problem Description
```text
Given an array of integers A of size N that is 
a permutation of [0, 1, 2, ..., (N-1)]. It is 
allowed to swap any two 
elements (not necessarily consecutive).

Find the minimum number of swaps required to 
sort the array in ascending order.
```
#### Problem Constraints
```text
1 <= N <= 100000
0 <= A[i] < N
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return the minimum number of swaps.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 0]
Input 2:
 A = [2, 0, 1, 3]
```
#### Example Output
```text
Output 1:
 4
Output 2:
 2
```
#### Example Explanation
```text
Explanation 1: 
 If you swap (1, 2) -> (2, 3) -> (4, 0) -> (3, 0). 
 You will get a sorted array.
 You cannot sort it with lesser swaps.

Explanation 2:
 You cannot sort it with lesser than 2 swaps.
```
### Hints
* Hint 1
```text
Can we perform a sorting algorithm on the array 
and count the number of swaps that happen 
in the process?

Will this give the minimum number of swaps? (No)
```
* Solution Approach
```text
Suppose we have array A=[A0, A1, A2… ]

Now, let’s keep iterating over this array, and 
if Ai != i, We swap it with index Ai (that’s where 
Ai belongs). If you work it out, you can always 
see some cycle will form.

Example:

    1. [4, 0, 1, 3, 2]
        swap_index(0,4) -> swap_index(0,2) -> swap_index(0,1) (3 swaps)
    2. [2, 0, 1, 4, 3]
        swap_index(0,2) -> swap_index(0,1) (2 swaps)
        swap_index(3,4) (1 swaps)

Answers would be the sum of { individual length of cycle - 1}

Remember to use some flags to not visit the same 
elements again and again
```
* Complete Solution
```java
public class Solution {
    public int solve(ArrayList<Integer> A) {
        int ans = 0;
        for(int i = 0 ; i < A.size() ; i++ ){
            while(A.get(i) != i){
                ans++;
                // swap A[i] with A[A[i]]
                Collections.swap(A, i, A.get(i));
            }
        }
        return ans;
    }
}
```
```javascript
module.exports = { 
 //param A : array of integers
 //return an integer
	solve : function(A){
        let ans = 0;
        for(let i = 0; i < A.length; i++){
            while(A[i] != i){
                ans++;
                // swap A[i] with A[A[i]]
                let id = A[i];
                [A[i] , A[id]] = [A[id], A[i]];
            }
        }
        return ans;
	}
};
```
```cpp
int Solution::solve(vector<int> &A) {
    int ans = 0;
    for(int i = 0 ; i < A.size() ; i++ ){
        while(A[i] != i){
            ans++;
            // swap A[i] with A[A[i]]
            swap(A[i], A[A[i]]);
        }
    }
    return ans;
}
```

