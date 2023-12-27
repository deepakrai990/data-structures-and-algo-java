### Q4. 3 Sum Zero
#### Problem Description
```text
Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0

Find all unique triplets in the array which gives the sum of zero.

Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The 
    solution set must not contain duplicate triplets.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>0 &lt;= N &lt;= 7000</p>
    <p>-10<sup>8</sup> &lt;= A[i] &lt;= 10<sup>8</sup></p>
</div>

```text
0 <= N <= 7000

-10^8 <= A[i] <= 10^8
```
#### Input Format
```text
Single argument representing a 1-D array A.
```
#### Output Format
```text
Output a 2-D vector where each row represent a unique triplet.
```
#### Example Input
```text
A = [-1,0,1,2,-1,4]
```
#### Example Output
```text
[ [-1,0,1],
  [-1,-1,2] ]
```
#### Example Explanation
```text
Explanation
    Out of all the possible triplets having total sum zero,only the above two triplets 
    are unique.
```
### Hints
* Hint 1
```text
The naive approach obviously is exploring all combinations of 3 integers using 3 loops.

Now, to look into improving, does it help if we sort the array?
```
* Hint 2
```text
When the array is sorted, try to fix the least integer by looping over it.

Let us say the least integer in the solution is arr[i].
Now we need to find a pair of integers j and k such that :

arr[j] + arr[k] is -arr[i].

To do that, let us try the 2 pointer approach.
If we fix the two pointers at the end ( that is, i+1 and end of array ),
we look at the sum.

    * If the sum is smaller than 0, we increase the first pointer to increase the sum.
    * If the sum is bigger than 0, we decrease the end pointer to reduce the sum.
```
* Solution Approach
```text
Getting a Time Limit exceeded or Output Limit exceeded?
Make sure you handle case of empty input [].
In C++/C, usually if you run a loop till array.size() - 2,
it can lead to the program running indefinitely as array.size() is unsigned int, and the subtraction just makes it wrap over to a big integer.

Make sure you are not processing the same triplets again.

Skip over the duplicates in the array.

    Try a input like :
    -1 -1 -1 -1 0 0 0 0 1 1 1 1
    Ideally, you should get only 2 pairs : {[-1 0 1], [0 0 0]}
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        if (A == null)
            return res;
        
        Collections.sort(A);
        int n = A.size();
        
        for (int low = 0; low < n - 2; low++) {
            
            int mid = low + 1;
            int high = n - 1;
            int sum = -A.get(low);
            
            if (low > 0 && A.get(low).intValue() == A.get(low - 1).intValue())
                continue;
            
            while (mid < high) {
                
                int num = A.get(mid) + A.get(high);
                
                if (num == sum) {
                    temp.add(A.get(low));
                    temp.add(A.get(mid));
                    temp.add(A.get(high));
                    res.add(new ArrayList(temp));
                    temp.clear();
                    
                    int prev = mid;
                    while (mid <= high && A.get(mid).intValue() == A.get(prev).intValue())
                        mid++;
                        
                } else if (num < sum) {
                    mid++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
class Solution {
    public:
        vector<vector<int> > threeSum(vector<int> &num) {
            sort(num.begin(), num.end());
            
            int sum = 0;
            vector<vector<int> > ans;
            int sz = num.size();
            // Fix the smallest number in the three integers
            for (int i = 0; i < sz - 2; i++) {
                // Lets make sure that we do not have duplicate triplets. 
                // We skip the duplicate elements as min integer in the triplet. 
                if (i > 0 && num[i] == num[i - 1]) {
                    continue;
                }
                // Now num[i] is the smallest number in the three integers in the solution
                int ptr1 = i + 1, ptr2 = num.size() - 1;
                while (ptr1 < ptr2) {
                    sum = num[i] + num[ptr1] + num[ptr2];
                    if (sum == 0) {
                        vector<int> tmp; 
                        tmp.push_back(num[i]);
                        tmp.push_back(num[ptr1]);
                        tmp.push_back(num[ptr2]);
                        ans.push_back(tmp);    
                    }
                    if (sum > 0) {
                        ptr2--;
                    } else if (sum < 0) {
                        ptr1++;
                    } else if (sum == 0) {
                        // In this case, we have a choice of increasing the first pointer, 
                        // or decreasing the last pointer. Lets go wiht increasing the first 
                        // pointer approach
                        // Note that we cannot have duplicate triplets. So we need to skip all 
                        // the occurrences of duplicates.
                        ptr1++;
                        while (ptr1 < ptr2 && num[ptr1] == num[ptr1 - 1]) {
                            ptr1++;
                        }
                    }
                }
            }
            return ans;
        }
};
```

