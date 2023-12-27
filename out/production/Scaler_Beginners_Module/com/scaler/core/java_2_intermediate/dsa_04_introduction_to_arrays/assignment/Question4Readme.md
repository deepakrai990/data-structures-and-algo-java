### Q4. Reverse the Array
#### Problem Description
```text
You are given a constant array A.

You are required to return another array which is the reversed 
form of the input array.
```
#### Problem Constraints
```text
1 <= A.size() <= 10000

1 <= A[i] <= 10000
```
#### Input Format
```text
First argument is a constant array A.
```
#### Output Format
```text
Return an integer array.
```
#### Example Input
```text
Input 1:
 A = [1,2,3,2,1]

Input 2:
 A = [1,1,10]
```
#### Example Output
```text
Output 1:
 [1,2,3,2,1] 

Output 2:
 [10,1,1] 
```
#### Example Explanation
```text
Explanation 1:
    Reversed form of input array is same as original array

Explanation 2:
    Clearly, Reverse of [1,1,10] is [10,1,1]
```
### Hints
* Hint 1
```text
Make an array and keep pushing elements in it one by one from the 
original array in the backward direction.
```
* Solution Approach
```text
Let N be the size of the input array.

First of all, initialize an output array of size equal to N.

Then, iterate over the input array given in the function.

Inside the loop make output[i] = input[N-i-1], where N is the 
size of the input array.

After that, just return the output array from the function.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] solve(final int[] A) {
        int n = A.length;
        int []ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = A[n - i - 1];
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //return a array of integers
	solve : function(A) {
	
        let n = A.length;
        let i=0, j=n-1;
        
        while(i<j) {
            let temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
        return A;
	}
};
```
* * Solution in C++
```cpp
vector<int> Solution::solve(const vector<int> &A) {
    int n = A.size();
    vector<int> ans;
    for(int i = 0; i < n; i++)ans.push_back(A[n-i-1]);
    return ans;
}
```

