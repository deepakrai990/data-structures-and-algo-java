### Q5. Subarray Sum Equals K
#### Problem Description
```text
Given an array of integers A and an integer B.

Find the total number of subarrays having sum equals to B.
```
#### Problem Constraints
```text
1 <= length of the array <= 50000
-1000 <= A[i] <= 1000 
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is integer B.
```
#### Output Format
```text
Return the total number of subarrays having sum equals to B.
```
#### Example Input
```text
Input 1:
 A = [1, 0, 1]
 B = 1

Input 2:
 A = [0, 0, 0]
 B = 0
```
#### Example Output
```text
Output 1:
 4

Output 2:
 6
```
#### Example Explanation
```text
Explanation 1:
    [1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.
```
### Hints
* Hint 1
```text
If C stores the cumulative sum of then we can get sum 
of any subarray[l,r] = C[r]- C[l-1]

So we need all subarrays having sum equal to B
C[r] - C[l-1] = B

Refraining this equation C[r] - B = C[l-1] 
try to think how can you get number of subarray 
having sum B from this equation.
```
* Solution Approach
```text
Approach- 1 (Brute Force)
The simplest method is to consider every possible subarray 
of the given nums array, find the sum of the elements 
of each of those subarrays and check for the equality of 
the sum obtained with the given kk. Whenever the sum 
equals kk, we can increment the count used to store 
the required result.
Time complexity : O(n^3)
Space complexity : O(1)

Approach- 2 (using cumulative sum)
Instead of determining the sum of elements every time for 
every new subarray considered, we can make use of a cumulative 
sum array , sum. Then, in order to calculate the sum of 
elements lying between two indices, we can subtract the 
cumulative sum corresponding to the two indices to obtain 
the sum directly, instead of iterating over the subarray 
to obtain the sum.

In this implementation, we make use of a cumulative sum 
array, sumsum, such that sum[i] is used to store the cumulative 
sum of numsnums array up to the element corresponding 
to the (i-1)^{th} index. Thus, to determine the sum of 
elements for the subarray nums[i:j], we can directly 
use sum[j+1] - sum[i].

Time complexity : O(n^2)
Space complexity : O(n)

Approach- 3 (without space)
Instead of considering all the start and end points 
and then finding the sum for each subarray corresponding to 
those points, we can directly find the sum on the go while 
considering different end points. i.e. We can choose a 
particular start point and while iterating over the end 
points, we can add the element corresponding to the end 
point to the sum formed till now. Whenever the sum equals 
the required kk value, we can update the count value. We 
do so while iterating over all the end indices possible 
for every start index. Whenever, we update the start index, 
we need to reset the sum value to 0.
Time complexity : O(n^2)
Space complexity : O(n)

Approach- 4 (Using Hashmap)
The idea behind this approach is as follows: If the 
cumulative sum(represented by sum[i] for sum up 
to i^{th} index) up to two indices is the same, the sum 
of the elements lying in between those indices is 
zero. Extending the same thought further, if the cumulative 
sum up to two indices, say i and j is at a difference 
of k i.e. if sum[i] - sum[j] = k, the sum of elements 
lying between indices i and j is k.

Based on these thoughts, we make use of a hashmap map 
which is used to store the cumulative sum up to all 
the indices possible along with the number of times 
the same sum occurs. We store the data in the 
form: (sum_i, no. of occurrences of sum_i). We traverse 
over the array nums and keep on finding the 
cumulative sum. Every time we encounter a new sum, we 
make a new entry in the hashmap corresponding to that 
sum. If the same sum occurs again, we increment the 
count corresponding to that sum in the hashmap. Further, 
for every sum encountered, we also determine the number 
of times the sum sum-ksum−k has occurred already, since 
it will determine the number of times a subarray with 
sum k has occurred up to the current index. We increment 
the count by the same amount.

After the complete array has been traversed, the count 
gives the required result.
Time complexity : O(n)
Space complexity : O(n)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        Map<Integer, Integer> prevSum = new HashMap<Integer, Integer>();
        prevSum.put(0, 1);
        int currSum = 0, ans = 0;
        for(int i = 0 ; i < A.length ; i++){
            currSum += A[i];
            if(prevSum.containsKey(currSum - B)){
                ans += prevSum.get(currSum - B);
            }
            prevSum.put(currSum, prevSum.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A, int B) {
    unordered_map<long long,int> mp;
    mp[0]=1;
    long long sum=0;
    int ans=0;
    for(auto &it:A){
        sum+=it;
        ans+=mp[sum-B];
        ++mp[sum];
    }
    return ans;
}
```

