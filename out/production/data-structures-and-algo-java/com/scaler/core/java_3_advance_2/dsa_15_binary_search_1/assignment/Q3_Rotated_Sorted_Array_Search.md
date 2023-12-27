Rotated Sorted Array Search
#### Problem Description
```text
Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in 
the array, return its index otherwise, return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 1000000</p>
* <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
* <p>all elements in A are distinct.</p>
```text
1 <= N <= 1000000

1 <= A[i] <= 10^9

all elements in A are distinct.
```
#### Input Format
```text
The first argument given is the integer array A.

The second argument given is the integer B.
```
#### Output Format
```text
Return index of B in array A, otherwise return -1
```
#### Example Input
```text
Input 1:
 A = [4, 5, 6, 7, 0, 1, 2, 3]
 B = 4 

Input 2:
 A : [ 9, 10, 3, 5, 6, 8 ]
 B : 5
```
#### Example Output
```text
Output 1:
 0 

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
 Target 4 is found at index 0 in A. 

Explanation 2:
 Target 5 is found at index 3 in A.
```
### Hints
* Hint 1
```text
Think of a modified version of the binary search.

If the pivot is known, the binary search becomes trivial 
as the array to either side of the pivot is sorted.

Can you somehow search for the pivot in your binary search?
```
* Solution Approach
```text
A naive solution is a linear search.

To improve, let us break our approach into two steps. First, 
we find the pivot (the index of minimum in the array).

Once we know the pivot, to search for x, we can do a conventional 
binary search in the left and right parts of the pivot in the array.

Now, let us look at how binary search can be applied in this scenario 
to find the minimum.

There are 2 cases:

1)
          mid

           |

   6 7 8 9 1 2 3 4 5  

arr[mid] > arr[end]

The min lies in (mid, end]

Mid is excluded from the range because arr[mid] > arr[end]

2)
         mid

          | 

  6 7 8 9 1 2 3 4 5

arr[mid] < arr[end]

The min lies in [start, mid]

3) Note: If there are duplicates, making either decision might be 
difficult, and hence linear search might be required.

               mid

                |

1 1 1 1 2 0 1 1 1 1 1 1 1 1 1 1 1 

arr[mid] = arr[end]

Indecisive. We would need to explore the whole array.
```
* Complete Solution
```java
public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> A, int B) {
	    int mid;
	    int start, end;
	    int count;
	    int num;
	    int n = A.size();
	    count = n;
	    // find the index of minimum element
	    int pivot = getMinElementIndex(A);
	    // Now we can binary search in two parts 0 - pivot and pivot to n-2
	    start = pivot;
	    end = n - 1;
	    int res = binarySearch(A, start, end, B);
	    if (res == -1) {
	        start = 0;
	        end = pivot - 1;
	        res = binarySearch(A, start, end, B);
	    }
	    return res;
	}
	
	public int binarySearch(final List<Integer> A, int start, int end, int B) {
	    int count = end - start + 1;
	    int num, mid;
	    while (count > 0) {
	        mid = start + (end - start) / 2;
	        num = A.get(mid);
	        if (B == num)
	            return mid;
	        if (B < num)
	            end = mid - 1;
	        else
	            start = mid + 1;
	        count /= 2;
	    }
        return -1;
	}
	public int getMinElementIndex(final List<Integer> A) {
	    int first, last, start, end;
	    int count, num, n;
	    int mid;
	    int next, prev;
	    n = A.size();
	    count = n;
	    first = A.get(0);
	    last = A.get(n - 1);
	    start = 0;
	    end = n - 1;
	    while (count > 0) {
	        mid = start + (end - start) / 2;
	        num = A.get(mid);
	        next = A.get((mid + 1) % n);
	        prev = A.get((mid - 1 + n) % n);
	        if (num < prev && num < next) {
	            return mid;
	        }
	        if (num > first && num > last)
	            start = mid + 1;
	        else 
	            end = mid - 1;
	        count /= 2;
        }
	    return -1;
	}
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //param B : integer
 //return an integer
	search : function(A, B){
        let l = 0;
        let r = A.length - 1;
        while (l <= r) {
            let mid = Math.floor((l + r) / 2);
            if (A[mid] === B) {
                return mid;
            }
            if (A[0] > B) {
                if (A[0] > A[mid]) {
                    if (A[mid] < B) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    l = mid + 1;
                }
            } else {
                if (A[0] <= A[mid]) {
                    if (A[mid] < B) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
	}
};
```

* * Solution in C++
```cpp
int Solution::search(const vector < int > & A, int B) {
  int n = A.size();
  int low = 0, high = n - 1;
  while (low <= high) {
    int mid = low + (high - low) / 2;
    if (A[mid] == B)
      return mid;
    else if (A[0] <= A[mid]) { //i.e. left part is sorted
      if (A[0] <= B && B < A[mid])
        high = mid - 1; //B lies on left part
      else low = mid + 1;
    } else { //right part is sorted
      if (A[mid] < B && B <= A[n - 1])
        low = mid + 1; //B lies on right part
      else high = mid - 1;
    }
  }
  return -1;
}
```
