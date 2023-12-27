### Q1. Inversion count in an array
#### Problem Description

<p>
Given an array of integers <strong>A</strong>. 
If i &lt; j and A[i] &gt; A[j], then the pair (i, j) is 
called an inversion of A. Find the total number of 
inversions of A 
modulo (<strong>10<sup>9</sup> + 7</strong>).
</p>

```text
Given an array of integers A. If i < j and A[i] > A[j], then 
the pair (i, j) is called an inversion of A. Find the total 
number of inversions of A modulo (10^9 + 7).
```
#### Problem Constraints
* <p>1 &lt;= length of the array &lt;= 10<sup>5</sup></p>
* <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
```text
1 <= length of the array <= 10^5

1 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format

<p>Return the number of inversions of A modulo (10<sup>9</sup> + 7).</p>

```text
Return the number of inversions of A modulo (10^9 + 7).
```
#### Example Input
```text
Input 1:
 A = [1, 3, 2]

Input 2:
 A = [3, 4, 1, 2]
```
#### Example Output
```text
Output 1:
 1
Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]

Explanation 2:
    The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
    The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
    The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
    The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]
```
### Hints
* Hint 1
```text
Can we use some sorting algorithm to find the number of inversions?
```
* Solution Approach
```text
Naive Approach Traverse through the array from start to 
end Find the count of elements smaller than the current 
number up to that index for every element using another 
loop. Sum up the count of inversion for every index. Print 
the count of inversions.

Efficient Approach using Merge Sort

Suppose we know the number of inversions in the left half and 
the right half of the array, lets call them inv_l and inv_r.

Which inversions are not counted in inv_l+inv_r ? The elements 
in the left half which are greater than the elements in the 
right half. These are the inversions which are not counted.

Lets assume that both left half and right half are sorted. Can 
we count the number of inversions now?

We can just merge the two arrays and whenever we find 
that a[i] > a[j] (where i is the pointer of left half 
of the array and j is the pointer of the right half 
of the array) we simply increment the number of inversions.

The final answer will be inv_l + inv_r + number of 
inversions found during merge step.

Does this remind of a famous algorithm?

Yes, that's right. It is Merge Sort with a slight modification.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private int Mod = 1000 * 1000 * 1000 + 7;
    public int solve(int[] A) {
        return (int) mergeSort(A);
    }
    public long mergeSort(int[] A) {
        int[] temp = new int[A.length];
        return _mergeSort(A, temp, 0, A.length - 1) % Mod;
    }
    public long _mergeSort(int arr[], int temp[], int left, int right) {
        int mid;
        long inv_count = 0;
        if (right > left) {
            /* Divide the array into two parts and
            call _mergeSortAndCountInv()  
            for each of the parts */
            mid = (right + left) / 2;
            /* Inversion count will be sum of  
            inversions in left-part, right-part  
            and number of inversions in merging */
            inv_count += _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);
            /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count % Mod;
    }
    public long merge(int arr[], int temp[], int left, int mid, int right) {
        int i, j, k;
        long inv_count = 0;
        i = left; /* i is index for left subarray*/
        j = mid; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                inv_count = inv_count + (mid - i);
            }
        }
        /* Copy the remaining elements of left subarray  
                (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];
        /* Copy the remaining elements of right subarray  
                (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];
        /*Copy back the merged elements to original array*/
        for (i = left; i <= right; i++)
            arr[i] = temp[i];
        return inv_count % Mod;
    }
}
```
* * Solution in Javascript
```javascript
const MOD = 1e9 + 7;
class Bit {
    constructor(val) {
        this.bit = new Array(val + 10).fill(0);
        this.sz = val + 10;
    }
    add(idx, val) {
        while (idx < this.sz) {
            this.bit[idx] += val;
            idx += idx & -idx;
        }
    }
    pref(idx) {
        let ret = 0;
        while (idx > 0) {
            ret += this.bit[idx];
            idx -= idx & -idx;
        }
        return ret;
    }
    sum(a, b) {
        return this.pref(b) - this.pref(a - 1);
    }
}

module.exports = {
    solve: function (A) {
        let B = [...new Set(A)].sort((a, b) => a - b);
        let mp = new Map();
        let id = 1;
        B.forEach((ele) => mp.set(ele, id++));
        // using a fenwick tree
        let bt = new Bit(id + 1);
        let ans = 0;
        A.forEach((ele) => {
            ele = mp.get(ele);
            // gets the number of elements greater than ele
            ans += bt.sum(ele + 1, id);
            bt.add(ele, 1);
            ans %= MOD;
        });
        return ans;
    },
};
```
* * Solution in C++
```cpp
long long _mergeSort(int arr[], int temp[], int left, int right);
long long merge(int arr[], int temp[], int left, int mid, int right);
int hell = 1000000007;

/* This function sorts the input array and returns the  
number of inversions in the array */
int mergeSort(int arr[], int array_size) {
    int temp[array_size];
    return _mergeSort(arr, temp, 0, array_size - 1) % hell;
}

/* An auxiliary recursive function that sorts the input array and  
returns the number of inversions in the array. */
long long _mergeSort(int arr[], int temp[], int left, int right) {
    long long mid, inv_count = 0;
    if (right > left) {
        /* Divide the array into two parts and  
        call _mergeSortAndCountInv()  
        for each of the parts */
        mid = (right + left) / 2;
        /* Inversion count will be sum of  
        inversions in left-part, right-part  
        and number of inversions in merging */
        inv_count += _mergeSort(arr, temp, left, mid);
        inv_count += _mergeSort(arr, temp, mid + 1, right);
        /*Merge the two parts*/
        inv_count += merge(arr, temp, left, mid + 1, right);
    }
    return inv_count % hell;
}

/* This funt merges two sorted arrays  
and returns inversion count in the arrays.*/
long long merge(int arr[], int temp[], int left, int mid, int right) {
    int i, j, k;
    long long inv_count = 0;
    i = left; /* i is index for left subarray*/
    j = mid; /* j is index for right subarray*/
    k = left; /* k is index for resultant merged subarray*/
    while ((i <= mid - 1) && (j <= right)) {
        if (arr[i] <= arr[j])
            temp[k++] = arr[i++];
        else {
            temp[k++] = arr[j++];
            /* this is tricky -- see above  
            explanation/diagram for merge()*/
            inv_count = inv_count + (mid - i);
        }
    }
    /* Copy the remaining elements of left subarray  
            (if there are any) to temp*/
    while (i <= mid - 1)
        temp[k++] = arr[i++];
    /* Copy the remaining elements of right subarray  
            (if there are any) to temp*/
    while (j <= right)
        temp[k++] = arr[j++];
    /*Copy back the merged elements to original array*/
    for (i = left; i <= right; i++)
        arr[i] = temp[i];
    return inv_count % hell;
}

int Solution::solve(vector < int > & A) {
    int n = A.size();
    int a[n];
    for (int i = 0; i < n; i++)
        a[i] = A[i];
    return mergeSort(a, n);
}
```

