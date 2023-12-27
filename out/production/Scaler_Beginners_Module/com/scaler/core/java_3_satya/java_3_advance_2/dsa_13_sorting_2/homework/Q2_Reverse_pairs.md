### Q2. Reverse pairs
#### Problem Description
```text
Given an array of integers A, we call (i, j) an important 
reverse pair if i < j and A[i] > 2*A[j].

Return the number of important reverse pairs in the given array A.
```
#### Problem Constraints
* <p>1 &lt;= length of the array &lt;= 10<sup>5</sup></p>
* <p> -2 * 10<sup>9</sup> &lt;= A[i] &lt;= 2 * 10<sup>9</sup> </p>
```text
1 <= length of the array <= 10^5

-2 * 10^9 <= A[i] <= 2 * 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return the number of important reverse pairs in the given array A.
```
#### Example Input
```text
Input 1:
 A = [1, 3, 2, 3, 1]

Input 2:
 A = [4, 1, 2]
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
    There are two pairs which are important reverse i.e (3, 1) and (3, 1).

Explanation 2:
    There is only one pair i.e (4, 1).
```
### Hints
* Hint 1
```text
Can you use Merge Sort to count the number of important reverse pairs?
```
* Solution Approach
```text
We can use two loops and calculate the number of pairs that satisfy 
the condition, but the time complexity will be O(N^2), which will 
not work in the worst case.

So we can think of a better solution, i.e., using merge sort.

We will do a usual merge sort, but before calling the merge 
function, we will calculate the number of pairs using 
two pointers, considering that the two arrays are 
sorted individually.

Likewise, we will do this till our mergesort ends, i.e., the 
array becomes sorted.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        return mergesort_and_count(A, 0, n - 1);
    }
    public void merge(int a[], int start, int mid, int end) {
        int n1 = (mid - start + 1);
        int n2 = (end - mid);
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = a[start + i];
        for (int j = 0; j < n2; j++)
            R[j] = a[mid + 1 + j];
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if (j >= n2 || (i < n1 && L[i] <= R[j]))
                a[k] = L[i++];
            else
                a[k] = R[j++];
        }
    }
    public int mergesort_and_count(int a[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            // divide the array into two half and sort them
            int count = mergesort_and_count(a, start, mid) + mergesort_and_count(a, mid + 1, end);
            // count the number of pairs
            int j = mid + 1;
            for (int i = start; i <= mid; i++) {
                while (j <= end && 1l * a[i] > a[j] * 2l)
                    j++;
                count += j - (mid + 1);
            }
            merge(a, start, mid, end);
            return count;
        } else
            return 0;
    }
}
```
* * Solution in Javascript
```javascript
function merge(start, mid, end, A) {
    let a = [];
    let b = [];
    let one = start;
    let two = mid + 1;
    while (one <= mid) a.push(A[one++]);
    while (two <= end) b.push(A[two++]);

    one = two = 0;
    for (let id = start; id <= end; id++) {
        if (two >= b.length || a[one] < b[two]) A[id] = a[one++];
        else A[id] = b[two++];
    }
}

function mergeSort(start, end, A) {
    if (start == end) return 0;
    let mid = (start + end) >> 1;

    // divide the array into two half and sort them
    let ans = 0;
    ans += mergeSort(start, mid, A);
    ans += mergeSort(mid + 1, end, A);
    
    // count the number of pairs
    let j = mid;
    for (let i = start; i <= mid; i++) {
        while (j + 1 <= end && A[j + 1] * 2 < A[i]) j++;
        ans += j - (mid + 1) + 1;
    }
    merge(start, mid, end, A);
    return ans;
}
module.exports = {
    solve: function (A) {
        return mergeSort(0, A.length - 1, A);
    },
};
```
* * Solution in C++
```cpp
void merge(vector < int > & a, int start, int mid, int end) {
    int n1 = (mid - start + 1);
    int n2 = (end - mid);
    int L[n1], R[n2];
    for (int i = 0; i < n1; i++)
        L[i] = a[start + i];
    for (int j = 0; j < n2; j++)
        R[j] = a[mid + 1 + j];
    int i = 0, j = 0;
    for (int k = start; k <= end; k++) {
        if (j >= n2 || (i < n1 && L[i] <= R[j]))
            a[k] = L[i++];
        else
            a[k] = R[j++];
    }
}

int mergesort_and_count(vector < int > & a, int start, int end) {
    if (start < end) {
        int mid = (start + end) / 2;
        // divide the array into two half and sort them
        int count = mergesort_and_count(a, start, mid) + mergesort_and_count(a, mid + 1, end);
        // count the number of pairs
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && a[i] > a[j] * 2L)
                j++;
            count += j - (mid + 1);
        }
        merge(a, start, mid, end);
        return count;
    } else
        return 0;
}

int Solution::solve(vector < int > & A) {
    int n = A.size();
    return mergesort_and_count(A, 0, n - 1);
}
```
