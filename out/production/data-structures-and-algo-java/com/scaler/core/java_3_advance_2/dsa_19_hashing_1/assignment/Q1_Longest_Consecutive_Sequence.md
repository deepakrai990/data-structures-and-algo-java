### Q1. Longest Consecutive Sequence
#### Problem Description
```text
Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from array A.
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>6</sup></p>
* <p>-10<sup>6</sup> &lt;= A[i] &lt;= 10<sup>6</sup></p>
```text
1 <= N <= 10^6

-10^6 <= A[i] <= 10^6
```
#### Input Format
```text
First argument is an integer array A of size N.
```
#### Output Format
```text
Return an integer denoting the length of the longest set of 
consecutive elements from the array A.
```
#### Example Input
```text
Input 1:
 A = [100, 4, 200, 1, 3, 2]

Input 2:
 A = [2, 1]
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
    The set of consecutive elements will be [1, 2, 3, 4].

Explanation 2:
    The set of consecutive elements will be [1, 2].
```
### Hints
* Hint 1
```text
Can we use Hashing to solve this problem?
```
* Solution Approach
```text
One solution is to sort the elements and then find the longest 
subarray with consecutive elements. But this will take O(NlogN).

An efficient way is to use hashing.

First, create an empty hash, and for each element, we insert and update 
the hash table and maxCount.

We only insert the element which is not yet inserted.
Calculate the lcount, i.e., the longest consecutive element till 
the current element - 1.

Calculate the rcount, i.e., the longest consecutive element from 
the current element + 1.

Update hMap[ele] (current element) = lcount + 1 + rcount.

Also, update the maxCount.
```
* Complete Solution
* * Solution in Java
```java
public class Solution{
    public int longestConsecutive(final List<Integer> A) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int maxCount = 0;
        for (int ele : A) {
            if (!mp.containsKey(ele)) {
                int lCount = 0;
                int rCount = 0;
                // lCount stores longest consecutive element till the current element - 1
                if (mp.containsKey(ele - 1)) {
                    lCount = mp.get(ele - 1);
                }
                // rCount stores longest consecutive element from the current element + 1
                if (mp.containsKey(ele + 1)) {
                    rCount = mp.get(ele + 1);
                }
                mp.put(ele, lCount + 1 + rCount);
                if(mp.containsKey(ele - lCount))
                    mp.put(ele - lCount, mp.get(ele));
                else
                    mp.put(ele - lCount, mp.get(ele));
                if(mp.containsKey(ele + rCount))
                    mp.put(ele + rCount, mp.get(ele));
                else
                    mp.put(ele + rCount, mp.get(ele));
                if (maxCount < lCount + 1 + rCount) 
                    maxCount = lCount + 1 + rCount;
            }
        }
        return maxCount;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //return an integer
	longestConsecutive : function(A){
        let mp = new Map();
        let maxCount = 0;
        for (let ele of A) {
            if (!mp.has(ele)) {
                let lCount = 0;
                let rCount = 0;
                // lCount stores longest consecutive element till the current element - 1
                if (mp.has(ele - 1)) {
                    lCount = mp.get(ele - 1);
                }
                // rCount stores longest consecutive element from the current element + 1
                if (mp.has(ele + 1)) {
                    rCount = mp.get(ele + 1);
                }
                mp.set(ele, lCount + 1 + rCount);
                if(mp.has(ele - lCount)){
                    mp.set(ele - lCount, mp.get(ele));
                }
                else{
                    mp.set(ele - lCount, mp.get(ele));
                }
                if(mp.has(ele + rCount)){
                    mp.set(ele + rCount, mp.get(ele));
                }
                else{
                    mp.set(ele + rCount, mp.get(ele));
                }
                if (maxCount < lCount + 1 + rCount){
                    maxCount = lCount + 1 + rCount;
                } 
            }
        }
        return maxCount;
	}
};
```
* * Solution in C++
```cpp
int Solution::longestConsecutive(const vector < int > & A) {
    unordered_map < int, int > hMap;
    int maxCount = 0;
    for (auto ele: A) {
        if (hMap.find(ele) == hMap.end()) {
            int lCount = 0;
            int rCount = 0;
            // lCount stores longest consecutive element till the current element - 1
            if (hMap.find(ele - 1) != hMap.end()) {
                lCount = hMap[ele - 1];
            }
            // rCount stores longest consecutive element from the current element + 1
            if (hMap.find(ele + 1) != hMap.end()) {
                rCount = hMap[ele + 1];
            }
            hMap[ele] = lCount + 1 + rCount;
            hMap[ele - lCount] = hMap[ele];
            hMap[ele + rCount] = hMap[ele];
            if (maxCount < lCount + 1 + rCount) 
                maxCount = lCount + 1 + rCount;
        }
    }
    return maxCount;
}
```

