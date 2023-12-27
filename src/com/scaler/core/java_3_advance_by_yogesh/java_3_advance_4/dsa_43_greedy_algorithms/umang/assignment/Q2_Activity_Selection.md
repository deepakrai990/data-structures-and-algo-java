### Q2. Activity Selection
#### Problem Description
```text
Given two integer arrays A and B of size N.

There are N activities where A[i] denotes the start time of the i^th activity 
and B[i] denotes the finish time of the ith activity.

Your task is to select the maximum number of activities that can be performed 
by a single person, assuming that a person can only work on a single activity at a time.
```
#### Problem Constraints
```text
1 <= N <= 100000
0 <= A[i] <= B[i] <= 2*10^9 
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is the integer array B.
```
#### Output Format
```text
Return the maximum number of activities that can be performed by a single person.
```
#### Example Input
```text
Input 1:
 A = [5, 1, 3, 0, 5, 8]
 B = [9, 2, 4, 6, 7, 9]
   
Input 2:
 A = [17, 8, 14, 24, 10, 8, 1, 30]
 B = [18, 45, 24, 27, 18, 10, 38, 35]
```
#### Example Output
```text
Output 1:
 4

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    Activities 2, 3, 5 and 6 can be selected (1- based indexing).
```
### Hints
* Hint 1
```text

```
* Solution Approach
```text

```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    class Activity {
        int start;
        int finish;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    public int solve(int[] A, int[] B) {
        int n = A.length;
        Activity[] arr = new Activity[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Activity(A[i], B[i]);
        }
        Arrays.sort(arr, new Comparator<Activity>() {
            public int compare(Activity a, Activity b) {
                if (a.finish < b.finish) {
                    return -1;
                } else if (a.finish > b.finish) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int i = 0;
        int count = 1;
        for (int j = 1; j < n; j++) {
            if (arr[j].start >= arr[i].finish) {
                count++;
                i = j;
            }
        }
        return count;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A, vector<int> &B) {
    vector<pair<int,int> >ans;
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> q;
    for(int i=0;i<A.size();i++)
        q.push(make_pair(B[i],A[i]));
    auto it = q.top();
    int start = it.second;
    int end = it.first;
    q.pop();
    ans.push_back(make_pair(start,end));
    while(!q.empty()){
        auto itr = q.top();
        q.pop();
        if(itr.second >= end){
            start = itr.second;
            end = itr.first;
            ans.push_back(make_pair(start,end));
        }
    }
    return (int)(ans.size());
}
```

