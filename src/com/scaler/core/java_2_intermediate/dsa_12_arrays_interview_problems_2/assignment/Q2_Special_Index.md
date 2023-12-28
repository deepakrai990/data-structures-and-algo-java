### Q2. Special Index

#### Problem Description
```text
Given an array, arr[] of size N, the task is to find the count 
of array indices such that removing an element from these indices 
makes the sum of even-indexed and odd-indexed array elements equal.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= n &lt;= 10<sup>5</sup><br>
    -10<sup>5</sup> &lt;= A[i] &lt;= 10<sup>5</sup>
</div>

```text
1 <= n <= 10^5
-10^5 <= A[i] <= 10^5
```
#### Input Format
```text
First argument contains an array A of integers of size N
```
#### Output Format
```text
Return the count of array indices such that removing an element 
from these indices makes the sum of even-indexed and odd-indexed 
array elements equal.
```
#### Example Input
```text
Input 1:
 A=[2, 1, 6, 4]

Input 2:
 A=[1, 1, 1]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } 
    such that, arr[0] + arr[2] = arr[1]. 
    
    Therefore, the required output is 1. 

Explanation 2:
    Removing arr[0] from the given array modifies arr[] to { 1, 1 } 
    such that arr[0] = arr[1] 
    
    Removing arr[1] from the given array modifies arr[] to { 1, 1 } 
    such that arr[0] = arr[1] 
    
    Removing arr[2] from the given array modifies arr[] to { 1, 1 } 
    such that arr[0] = arr[1] 
    
    Therefore, the required output is 3.
```
### Hints
* Hint 1
```text
The simplest approach to solve this problem is to traverse the array 
and for each array element, check if removing the element from the 
array makes the sum of even-indexed and odd-indexed array 
elements equal or not. 

If found to be true, then increment the count. Finally, print the count.
```
* Solution Approach
```text
Based on the observation that removing any element from the given 
array makes even indices of succeeding elements as odd and odd 
indices of the succeeding elements as even.

Follow the steps below to solve the problem:

Initialize two variables, say evenSum and oddSum, to store the 
sum of odd-indexed and even-indexed elements of the 
given array respectively.

Traverse the array using variable i.

Remove every ith element of the array and update the sum of the 
remaining even-indexed elements and the odd-indexed elements 
based on the above observation. Check if the sums are equal or not.

If found to be true, then increment the count.

Finally, print the count obtained. Check out the complete 
solution for more clarity.

Time complexity : O(n)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
 
    private int cntIndexesToMakeBalance(int arr[], int n)
    {
        if (n == 1) {
            return 1;
        }
     
        if (n == 2)
            return 0;
     
        int sumEven = 0;
        int sumOdd = 0;
     
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sumEven += arr[i];
            }
            else {
                sumOdd += arr[i];
            }
        }
     
        int currOdd = 0;
        int currEven = arr[0];
        int res = 0;
        int newEvenSum = 0;
        int newOddSum = 0;
     
        for (int i = 1; i < n - 1; i++) {
            if (i % 2 == 1) {
                currOdd += arr[i];
                newEvenSum = currEven + sumOdd
                             - currOdd;
                newOddSum = currOdd + sumEven
                            - currEven - arr[i];
            }
            else {
                currEven += arr[i];
                newOddSum = currOdd + sumEven
                            - currEven;
                newEvenSum = currEven + sumOdd
                             - currOdd - arr[i];
            }
            if (newEvenSum == newOddSum) {
                res++;
            }
        }
        if (sumOdd == sumEven - arr[0]) {
            res++;
        }
        if (n % 2 == 1) {
            if (sumOdd == sumEven - arr[n - 1]) {
                res++;
            }
        }
        else {
            if (sumEven == sumOdd - arr[n - 1]) {
                res++;
            }
        }
        return res;
    }
 
    public int solve(int[] A) {
        int n = A.length;
        return cntIndexesToMakeBalance(A, n);
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int cntIndexesToMakeBalance(int arr[], int n)
{
 
    // If size of the array is 1
    if (n == 1) {
        return 1;
    }
 
    // If size of the array is 2
    if (n == 2)
        return 0;
 
    // Stores sum of even-indexed
    // elements of the given array
    int sumEven = 0;
 
    // Stores sum of odd-indexed
    // elements of the given array
    int sumOdd = 0;
 
    // Traverse the array
    for (int i = 0; i < n; i++) {
 
        // If i is an even number
        if (i % 2 == 0) {
 
            // Update sumEven
            sumEven += arr[i];
        }
 
        // If i is an odd number
        else {
 
            // Update sumOdd
            sumOdd += arr[i];
        }
    }
 
    // Stores sum of even-indexed
    // array elements till i-th index
    int currOdd = 0;
 
    // Stores sum of odd-indexed
    // array elements till i-th index
    int currEven = arr[0];
 
    // Stores count of indices whose
    // removal makes sum of odd and
    // even indexed elements equal
    int res = 0;
 
    // Stores sum of even-indexed elements
    // after removing the i-th element
    int newEvenSum = 0;
 
    // Stores sum of odd-indexed elements
    // after removing the i-th element
    int newOddSum = 0;
 
    // Traverse the array
    for (int i = 1; i < n - 1; i++) {
 
        // If i is an odd number
        if (i % 2) {
 
            // Update currOdd
            currOdd += arr[i];
 
            // Update newEvenSum
            newEvenSum = currEven + sumOdd
                         - currOdd;
 
            // Update newOddSum
            newOddSum = currOdd + sumEven
                        - currEven - arr[i];
        }
 
        // If i is an even number
        else {
 
            // Update currEven
            currEven += arr[i];
 
            // Update newOddSum
            newOddSum = currOdd + sumEven
                        - currEven;
 
            // Update newEvenSum
            newEvenSum = currEven + sumOdd
                         - currOdd - arr[i];
        }
 
        // If newEvenSum is equal to newOddSum
        if (newEvenSum == newOddSum) {
 
            // Increase the count
            res++;
        }
    }
 
    // If sum of even-indexed and odd-indexed
    // elements is equal by removing the last element
    if (sumOdd == sumEven - arr[0]) {
 
        // Increase the count
        res++;
    }
 
    // If length of the array
    // is an odd number
    if (n % 2 == 1) {
 
        // If sum of even-indexed and odd-indexed
        // elements is equal by removing the last element
        if (sumOdd == sumEven - arr[n - 1]) {
 
            // Increase the count
            res++;
        }
    }
 
    // If length of the array
    // is an even number
    else {
 
        // If sum of even-indexed and odd-indexed
        // elements is equal by removing the last element
        if (sumEven == sumOdd - arr[n - 1]) {
 
            // Increase the count
            res++;
        }
    }
 
    return res;
}
int Solution::solve(vector<int> &A) {
    int n=A.size();
    int arr[n];
    for(int i=0;i<n;i++) arr[i]=A[i];
    return cntIndexesToMakeBalance(arr,n);
}

```

