### Q3. Search in Bitonic Array!
#### Problem Description
```text
Given a bitonic sequence A of N distinct elements, write a program to find a given 
element B in the bitonic sequence in O(logN) time.

NOTE:
    A Bitonic Sequence is a sequence of numbers which is first strictly increasing 
    then after a point strictly decreasing.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>3 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i], B &lt;= 10<sup>8</sup></p>
    <p>Given array always contain a bitonic point.</p>
    <p>Array A always contain distinct elements.</p>
</div>

```text
3 <= N <= 10^5

1 <= A[i], B <= 10^8

Given array always contain a bitonic point.

Array A always contain distinct elements.
```
#### Input Format
```text
First argument is an integer array A denoting the bitonic sequence.

Second argument is an integer B.
```
#### Output Format
```text
Return a single integer denoting the position (0 index based) of the element B in 
the array A if B doesn't exist in A return -1.
```
#### Example Input
```text
Input 1:
 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20

Input 2:
 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30
```
#### Example Output
```text
Output 1:
 3

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:
    B = 20 present in A at index 3

Explanation 2:
    B = 30 is not present in A
```
### Hints
* Hint 1
```text
First think of finding the bitonic point of the array (i.e the index of the maximum 
element of the array)

Try to use the above fact for finding a solution to the problem.
```
* Solution Approach
```text
A simple solution is to do linear search. Time complexity of this solution would be O(N).

An efficient solution is based on Binary Search. The idea is to find the bitonic point k which is the index of the maximum element of given sequence. If the element to be searched is greater than maximum element return -1, else search the element in both halves. Below is the step by step algorithm on how to do this.

Find the bitonic point in the given array, i.e the maximum element in the given bitonic array. This can be done in log(N) time by modifying the binary search algorithm. You can refer to this post on how to do this.
If the element to be searched is equal to the element at bitonic point then print the index of bitonic point.
If the element to be searched is greater than element at bitonic point then element does not exist in the array.
If the element to be searched is less than element at bitonic point then search for element in both half of the array using binary search.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int max = 0;
        int s = 0, e = n - 1;
        while (s <= e) {
            int mid = (e + s) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                max = mid;
                break;
            } else if (A[mid] < A[mid + 1]) {
                s = mid + 1;
            } else if (A[mid] < A[mid - 1]) {
                e = mid - 1;
            }
        }
        s = 0;
        e = max;
        while (s <= e) {
            int mid = (e + s) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                s = mid + 1;
            } else if (A[mid] > B) {
                e = mid - 1;
            }
        }
        s = max;
        e = n - 1;
        while (s <= e) {
            int mid = (e + s) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                e = mid - 1;
            } else if (A[mid] > B) {
                s = mid + 1;
            }
        }
        return -1;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
// Function for binary search in ascending part
int ascendingBinarySearch(vector < int > & arr, int low,
  int high, int key) {
  while (low <= high) {
    int mid = low + (high - low) / 2;
    if (arr[mid] == key)
      return mid;
    if (arr[mid] > key)
      high = mid - 1;
    else
      low = mid + 1;
  }
  return -1;
}

// Function for binary search in descending part of array
int descendingBinarySearch(vector < int > & arr, int low,
  int high, int key) {
  while (low <= high) {
    int mid = low + (high - low) / 2;
    if (arr[mid] == key)
      return mid;
    if (arr[mid] < key)
      high = mid - 1;
    else
      low = mid + 1;
  }
  return -1;
}

// finding bitonic point
int findBitonicPoint(vector < int > & arr, int n, int l, int r) {
  int mid;
  mid = (r + l) / 2;
  if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
    return mid;
  } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
    return findBitonicPoint(arr, n, mid, r);
  } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
    return findBitonicPoint(arr, n, l, mid);
  }
}

// Function to search key in bitonic array
int searchBitonic(vector < int > & arr, int n, int key, int index) {
  if (key > arr[index])
    return -1;

  else if (key == arr[index])
    return index;

  else {
    int temp = ascendingBinarySearch(arr, 0, index - 1, key);
    if (temp != -1) {
      return temp;
    }

    // Search in right of k
    return descendingBinarySearch(arr, index + 1, n - 1, key);
  }
}
int solveQ(vector < int > & arr, int b) {
  int index = findBitonicPoint(arr, arr.size(), 0, arr.size() - 1);
  int x = searchBitonic(arr, arr.size(), b, index);
  return x;
}
int Solution::solve(vector < int > & A, int B) {
  return solveQ(A, B);
}
```

