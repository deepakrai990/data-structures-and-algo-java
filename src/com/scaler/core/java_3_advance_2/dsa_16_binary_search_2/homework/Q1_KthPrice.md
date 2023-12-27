### Q1. KthPrice
#### Problem Description
```text
Given the price list at which tickets for a flight were purchased, figure out the kth 
smallest price for the flight. kth smallest price is the minimum possible n such that 
there are at least k price elements in the price list with value <= n. In other words, 
if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).

NOTE You are not allowed to modify the price list ( The price list is read only ). 
Try to do it using constant extra space.
```
#### Problem Constraints
```text
1 <= number of elements in the price list <= 1000000
1 <= k <= number of elements in the price list
```
#### Input Format
```text

```
#### Output Format
```text

```
#### Example Input
```text
A : [2 1 4 3 2]
k : 3
```
#### Example Output
```text
2
```
#### Example Explanation
```text

```
### Hints
* Hint 1
```text
Think binary search. Can you search for the answer?
```
* Solution Approach
```text
Think binary search. Can you search for the answer?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A, int B) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : A) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = (low + ((high - low) >> 1));
            int count = findCount(A, mid);
            if (count < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    private static int findCount(int[] A, int val) {
        int count = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] <= val) {
                count++;
            }
        }
        return count;
    }
}

```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
int Solution::solve(const vector<int> &A, int k) {

	// Binary search for the answer.
	int ans = -1;
	int start = A[0], end = A[0];
	for (int i = 1; i < A.size(); i++) {
		start = min(start, A[i]);
		end = max(end, A[i]);
	}
	int mid, numSmaller, i;
	while (start <= end) {
		mid = (start + end) / 2;
		numSmaller = 0;
		for (i = 0; i < A.size(); i++) if (A[i] <= mid) numSmaller++;
		if (numSmaller >= k) {
			end = mid - 1;
			ans = mid;
		}
		else {
			start = mid + 1;
		}
	}
	return ans;

}
```

