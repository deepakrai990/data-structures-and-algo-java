### Q4. Distribute candies
#### Problem Description
```text
Akash wants to distribute candies on his birthday. There are A people and he has 
two types of candies. B candies of the first type and C candies of the second type.

He wants to distribute candies in such a way that no person has candies of both 
types and each person has at least one candy.

Let X denotes the minimum candies among all people after distribution of candies.

Find the maximum X.
```
#### Problem Constraints
```text
2<=A<=B+C
1<=B<=10^9
1<=C<=10^9
```
#### Input Format
```text
First argument is an integer A denoting number of people.
Second argument is an integer B denoting number of candies of first type.
Third argument is an integer C denoting number of candies of second type.
```
#### Output Format
```text
Return an interger denoting the maximum X.
```
#### Example Input
```text
Input
 A=4 B=4 C=5
```
#### Example Output
```text
Output
 2
```
#### Example Explanation
```text
Explanation
    We can distribute candies such that 2 persons gets candies of first type [2,2] 
    and 2 persons gets candies of first type [3,2].
    
    So the maximum X will be 2.
```
### Hints
* Hint 1
```text
Since we have to maximize the minimum number of candies among people. We can check 
for each number X from 1 to B + C that at least all person have X number of candies. 
Find the maximum X.
```
* Solution Approach
```text
Since constraints are high, we can’t check for each number from 1 to B+C. 
We can think of more optimized solution that is binary search. 

If for some X, all person have at least X candies than we don’t need to check 
for values less than X.

We will find the maximum X.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B, int C) {
        int start = 1;
        int end = B + C;
        int ans = 0;
        while (start <= end) {
            int possibleCandies = end - (end - start) / 2;

            int distribution1 = B / possibleCandies;
            int distribution2 = C / possibleCandies;

            if (distribution1 + distribution2 >= A) {
                ans = possibleCandies;
                start = possibleCandies + 1;
            } else {
                end = possibleCandies - 1;
            }
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
bool check(int n,int a,int b,int x)
{
  int temp=a/x+ b/x;
  if(temp>=n)
  {
    return true;
  }
  return false;
}

int Solution::solve(int A, int B, int C) {
    int lo=1,hi=B+C;
      int ans=0;
      while(lo<=hi)
      {
        int mid=(lo+hi)/2;
        if(check(A,B,C,mid))
        {
          ans=mid;
          lo=mid+1;
        }
        else
        {
          hi=mid-1;
        }
      }
      return ans;

}
```

