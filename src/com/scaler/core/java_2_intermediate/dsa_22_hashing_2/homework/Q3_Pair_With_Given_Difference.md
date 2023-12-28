### Q3. Pair With Given Difference
#### Problem Description
```text
Given an one-dimensional unsorted array A containing N integers.

You are also given an integer B, find if there exists a 
pair of elements in the array whose difference is B.

Return 1 if any such pair exists else return 0.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    -10<sup>3</sup> &lt;= A[i] &lt;= 10<sup>3</sup><br>
    -10<sup>5</sup> &lt;= B &lt;= 10<sup>5</sup><br>
</div>

```text
1 <= N <= 10^5
-10^3 <= A[i] <= 10^3
-10^5 <= B <= 10^5
```
#### Input Format
```text
First argument is an integer array A of size N.

Second argument is an integer B.
```
#### Output Format
```text
Return 1 if any such pair exists else return 0.
```
#### Example Input
```text
Input 1:
 A = [5, 10, 3, 2, 50, 80]
 B = 78

Input 2:
 A = [-10, 20]
 B = 30
```
#### Example Output
```text
Output 1:
 1

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Pair (80, 2) gives a difference of 78.

Explanation 2:
    Pair (20, -10) gives a difference of 30 i.e 20 - (-10) => 20 + 10 => 30
```
### Hints
* Hint 1
```text
Create an empty hash table HT. Traverse the array, use array 
elements as hash keys and enter them in HT. Traverse the 
array again look for value B + A[i] in HT.
```
* Solution Approach
```text
Method 1: Brute Force
The simplest method is to run two loops, the outer loop picks 
the first element (smaller element) and the inner loop looks 
for the element picked by outer loop plus B.

Time complexity of this method is O(N^2). This wil not work 
lets us look on an optimized method.

Method 2: Sorting + Binary Search
We can use sorting and Binary Search to improve time 
complexity to O(NLogN).

The first step is to sort the array in ascending order.

Once the array is sorted, traverse the array from 
left to right, and for each element A[i], binary search 
for A[i] + B in A[i+1..n-1]. If the element is found, return 1.

Both first and second steps take O(NLogN). So overall 
complexity is O(NLogN).

Time Complexity : O(NlogN + NlogN)

Method 3: Sorting + Two Pointers
The second step of the above algorithm can be improved 
to O(N). The first step remain same.

The idea for second step:

Take two index variables i and j, initialize them 
as 0 and 1 respectively.

Now run a linear loop. If A[j] – A[i] is smaller than B, 
we need to look for greater A[j], so increment j.

If A[j] – A[i] is greater than B, we need to look for 
greater A[i], so increment i.

Time Complexity : O(NlogN + N)

Method 4: Hashing
Create an empty hash table HT. Traverse the array, use 
array elements as hash keys and enter them in HT.

Traverse the array again look for value B + A[i] in HT.
Time Complexity: O(N) if we use unordered_map
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < A.length ; i++){
            if(set.contains(A[i] + B) || set.contains(A[i] - B)){
                return 1;
            }
            set.add(A[i]);
        }
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
//Using Sorting  + Two Pointers
bool findPair(vector<int>&arr, int size, int n)  
{  
    // Initialize positions of two elements  
    int i = 0;  
    int j = 1;  
   sort(arr.begin(),arr.end());
    // Search for a pair  
    while (i < size && j < size)  
    {  
        if (i != j && arr[j] - arr[i] == n)  
        {
            return true;  
        }  
        else if (arr[j]-arr[i] < n)  
            j++;  
        else
            i++;  
    }  
    return false;  
}  
int Solution::solve(vector<int> &A, int B) {
    return findPair(A,A.size(),B);
}

//Another Solution Using Hashing
int Solution::solve(vector<int> &A, int B) {
    unordered_map<int,int>hashMap;
    for(int a:A)hashMap[a]++;
    int found=0;
    for(int a:A)
    {
     /*
     if B == 0 then then there must be
     two same elements so checking count of A[i]
     which must be greater than 1 */

      if(((B+a)==a) && hashMap[a]>1)
      {
        found=1;
        break;
      }
      else if((B+a)==a)continue;
      
      if(hashMap.find(B+a)!=hashMap.end())
      {
        found=1;
        break;
      }
    }
    return found;
}
```

