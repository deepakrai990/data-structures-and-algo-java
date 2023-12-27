### Q2. Multiple left rotations of the array
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given an array of integers <strong>A</strong> and multiple 
    values in <strong>B</strong>, which represents the number of 
    times array A needs to be left rotated.</p>
    <p>Find the rotated array for each value and return the 
    result in the form of a matrix where i<sup>th</sup> row 
    represents the rotated array for the i<sup>th</sup> value in B.</p>
</div>

```text
Given an array of integers A and multiple values in B, which 
represents the number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in 
the from of a matrix where i'th row represents the rotated array 
for the i'th value in B.
```
#### Problem Constraints
```text
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000
```
#### Input Format
```text
The first argument given is the integer array A.

The second argument given is the integer array B.
```
#### Output Format
```text
Return the resultant matrix.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = [2, 3]

Input 2:
 A = [5, 17, 100, 11]
 B = [1]
```
#### Example Output
```text
Output 1:
 [ [3, 4, 5, 1, 2]
   [4, 5, 1, 2, 3] ]

Output 2:    
 [ [17, 100, 11, 5] ]
```
#### Example Explanation
```text
    for input 1 -> B[0] = 2 which requires 2 times left rotations
    
    1: [2, 3, 4, 5, 1]
    
    2: [3, 4, 5, 1, 2]
    
    B[1] = 3 which requires 3 times left rotation
    
    1: [2, 3, 4, 5, 1]
    
    2: [3, 4, 5, 1, 2]
    
    2: [4, 5, 1, 2, 4]
```
### Hints
* Hint 1
```text
Try to reduce the number of rotations below arrays size and then 
perform rotations.
```
* Solution Approach
```text
If we are required to do K left rotations, we can append the 
first K elements of the array to the back and delete and 
delete them from the front

If K is greater than the size of the array, we can simply perform 
modulo on it with array size as after exact rotation of array’s 
size times the array return to its original state
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = a.size();
        for (int x : b) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) temp.add(a.get((i + x) % n));
            ans.add(temp);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : array of integers
    //return a array of array of integers
    solve: function (A, B) {

        let ans = [];
        let m = B.length;
        let n = A.length;
        for (let i = 0; i < m; i++) {
            let index = B[i] % n;
            let temp = [];
	        
            for (let j = index; j < n; j++) temp.push(A[j]);
            for (let j = 0; j < index; j++) temp.push(A[j]);
            ans.push(temp);
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
vector<vector<int> > Solution::solve(vector<int> &A, vector<int> &B) {
    vector<vector<int>> ans;
    for(int i = 0; i < B.size(); ++i){
        
        vector< int > temp;
        int ind = B[i]%A.size() ;
        for(int j = ind; j < A.size(); ++j)temp.push_back(A[j]);
        for(int j = 0 ; j < ind; ++j)temp.push_back(A[j]);
        ans.push_back(temp);
    }
    return ans;
}
```

