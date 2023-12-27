### Q2. Next Permutation
#### Problem Description
```text
Implement the next permutation, which rearranges numbers 
into the numerically next greater permutation of numbers 
for a given array A of size N.

If such arrangement is not possible, it must be 
rearranged as the lowest possible order, i.e., sorted 
in ascending order.

NOTE:

    * The replacement must be in-place, do not allocate 
        extra memory.
    * DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use 
        of Library functions will disqualify your submission 
        retroactively and will give you penalty points.
```
#### Problem Constraints
* <p> 1 &lt;= N &lt;= 5 * 10<sup>5</sup></p>
* <p> 1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
```text
1 <= N <= 5 * 10^5

1 <= A[i] <= 10^9
```
#### Input Format
```text
The first and the only argument of input has an 
array of integers, A.
```
#### Output Format
```text
Return an array of integers, representing the next 
permutation of the given array.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3]

Input 2:
 A = [3, 2, 1]
```
#### Example Output
```text
Output 1:
 [1, 3, 2]

Output 2:
 [1, 2, 3]
```
#### Example Explanation
```text
Explanation 1:
 Next permutation of [1, 2, 3] will be [1, 3, 2].

Explanation 2:
 No arrangement is possible such that the number are 
 arranged into the numerically next greater 
 permutation of numbers.
 So will rearranges it in the lowest possible order.
```
### Hints
* Hint 1
```text
You can try out a few test cases to see what the pattern 
is or what exactly is the flow of numbers from the initial 
sequence to the final sequence.
```
* Solution Approach
```text
It might help to write down the next permutation on paper 
to see how and when the sequence changes.

You’ll realize the following pattern :

The suffix which gets affected is in descending 
order before the change.

A swap with the smaller element happens, and then 
we reverse the affected suffix.

    1 2 3 -> 1 3 2   // Suffix being just the 3. 

    1 2 3 6 5 4  -> 1 2 4 3 5 6 // Suffix being 6 5 4 in this case. 
```
* Complete Solution
```java
public class Solution {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
	    boolean status;
	    status = nextPerm(A);
	    if (!status)
	        Collections.sort(A);
	    return A;
	}
	
	public boolean nextPerm(ArrayList<Integer> A) {
	    int i = 0;
	    int n = A.size();
	    for (i = n - 2; i >= 0; i--) {
	        if (A.get(i) < A.get(i + 1))
	            break;
	    }
	    // the array is in descending order
	    if (i == -1)
	        return false;
	   
	    int j = n - 1;
	    for (; j >= i; j--) {
	        if (A.get(j) > A.get(i))
	            break;
	    }
	    // swap with the smallest number in the suffix
	    swap(A, i, j);
	    // reversing the suffix
	    i++;
	    int steps = (n - i + 1) / 2;
	    for (int k = 0; k < steps; k++) {
	        swap(A, i + k, n - k - 1);
	    }
	    return true;
	}
	public void swap(ArrayList<Integer> A, int i, int j) {
	    int temp = A.get(i);
	    A.set(i, A.get(j));
	    A.set(j, temp);
	}
}
```

```javascript
module.exports = { 
	nextPermutation : function(A){
	    let i,j, n = A.length;
        for(i = n - 2; i >= 0 ; i--)
            if(A[i] < A[i + 1])
                break;
    
        // the array is in descending order
        if (i == -1) {
            for(j = 0; j < n / 2; j++){
                let temp = A[j];
                A[j] = A[n - j - 1];
                A[n - j - 1] = temp;
            }
            return A;
        }
    
        for(j = n - 1; j > i; j--)
            if(A[j] > A[i])
                break;
        
        // swap with the smallest number in the suffix
        let temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        
        // reversing the suffix
        j = n - 1;
        i++;
        while(i < j){
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

```cpp
vector<int> Solution::nextPermutation(vector<int> &A) {
    int len = A.size();
    int i, j;
    for(i = len - 2; i >= 0 ; i--)
        if(A[i] < A[i + 1]) 
            break;
    
    // the array is in descending order
    if (i == -1) {
        reverse(A.begin(), A.end());
        return A;
    }

    for(j = len - 1; j > i; j--)
        if(A[j] > A[i]) 
            break;
    
    // swap with the smallest number in the suffix
    swap(A[i], A[j]);
    
    // reversing the suffix
    reverse(A.begin() + i + 1, A.end());
    return A;
}
```

