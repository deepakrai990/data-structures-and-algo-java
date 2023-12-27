### Q4. Largest Continuous Sequence Zero Sum
#### Problem Description
```text
Given an array A of N integers.

Find the largest continuous sequence in a array which sums to zero.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>6</sup></p>
    <p> -10<sup>7</sup> &lt;= A[i] &lt;= 10<sup>7</sup></p>
</div>

```text
1 <= N <= 10^6

-10^7 <= A[i] <= 107^
```
#### Input Format
```text
Single argument which is an integer array A.
```
#### Output Format
```text
Return an array denoting the longest continuous sequence with total sum of zero.

NOTE : If there are multiple correct answers, return the sequence which occurs first 
       in the array.
```
#### Example Input
```text
Input
 A = [1,2,-2,4,-4]
```
#### Example Output
```text
Output
 [2,-2,4,-4]
```
#### Example Explanation
```text
Explanation
    [2,-2,4,-4] is the longest sequence with total sum of zero.
```
### Hints
* Hint 1
```text
Lets try to reduce the problem to a much simpler problem.
Lets say we have another array sum where

  sum[i] = Sum of all elements from A[0] to A[i]
Note that in this array, sum of elements from A[i] to A[j] = Sum[j] - Sum[i-1]

We need to find j and i such that sum of elements from A[i] to A[j] = 0
 Or Sum[j] - Sum[i-1] = 0
 Or Sum[j] = Sum[i-1]
Now, the problem reduces to finding 2 indices i and j such that sum[i] = sum[j]
How can you solve the above problem ?
```
* Solution Approach
```text
Approach:

There are two steps:

    1. Create cumulative sum array where ith index in this array represents 
       total sum from 1 to ith index element.
    
    2. Iterate all elements of cumulative sum array and use hashing to find 
       two elements where value at ith index == value at jth index but i != j.
    
    3. IF element is not present in hash in fill hash table with current element.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(A == null) return rst;
        int len = 0;
        int sum = 0;
        int l = -1, r = -1;
        map.put(0, -1);
        for(int i = 0; i < A.size(); i++){
            sum += A.get(i);
            if(!map.containsKey(sum))
                map.put(sum, i);
            else{
                if(i - map.get(sum) > len){
                    l = map.get(sum) + 1;
                    r = i;
                    len = i - map.get(sum);
                }
            }
        }
        if(l >=0 && r >= 0){
            for(int i = l; i <= r; i++){
                rst.add(A.get(i));
            }
        }
        return rst;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
vector<int> Solution::lszero(vector<int> &sequence) {
    
    int N = sequence.size();
    vector<int> sum;
    if(N == 0)
            return sum; // empty vector

    sum.push_back(sequence[0]);

    for(int i = 1; i < N; ++i) {
        sum.push_back(sequence[i] + sum[i - 1]);
    }
    
    int start = 0;
    int end = 0;
    map<int, int> hash;
    for(int i = 0; i < N; ++i) {
        if(sum[i] == 0) {
            int temp_start = 0;
            int temp_end = i + 1;
            if(temp_end - temp_start >= end - start) {
                start = temp_start;
                end = temp_end;
            } 
        } else {
            if(hash.find(sum[i]) != hash.end()) {
                int temp_start = hash[sum[i]] + 1;
                int temp_end = i + 1;
                if(temp_end - temp_start > end - start) {
                    start = temp_start;
                    end = temp_end;                  
                } else if(temp_end - temp_start == end - start && temp_start < start) {
                    start = temp_start;
                    end = temp_end;
                }
            } else {
                hash[sum[i]] = i;
            }
        }
    }

    vector<int> ans;

    for(int i = start; i < end; ++i) {
        ans.push_back(sequence[i]);
    }

    return ans;
}
```

