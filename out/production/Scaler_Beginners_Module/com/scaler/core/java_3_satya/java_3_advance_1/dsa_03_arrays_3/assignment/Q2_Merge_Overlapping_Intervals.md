### Q2. Merge Overlapping Intervals
#### Problem Description
```text
Given a collection of intervals, merge all 
overlapping intervals.
```
#### Problem Constraints
```text
1 <= Total number of intervals <= 100000.
```
#### Input Format
```text
First argument is a list of intervals.
```
#### Output Format
```text
Return the sorted list of intervals after merging 
all the overlapping intervals.
```
#### Example Input
```text
Input 1:
 [1,3],[2,6],[8,10],[15,18]
```
#### Example Output
```text
Output 1:
 [1,6],[8,10],[15,18]
```
#### Example Explanation
```text
Explanation 1:
 Merge intervals [1,3] and [2,6] -> [1,6].
 so, the required answer after merging is [1,6],[8,10],[15,18].
 No more overlapping intervals present.
```
### Hints
* Hint 1
```text
First, try to figure out cases for two intervals to be merged.

Also, what can you do in order to simulate the process easier?
```
* Solution Approach
```text
Given all the intervals, you need to figure out the sequence 
of intervals which intersect.

Lets see how we check if interval 1 (a,b) intersects with 
interval 2 (c,d):

Overlap case :

a---------------------b          OR             a------b
            c-------------------d           c------------------d
Non-overlap case :

a--------------------b   c------------------d

If max(a,c) > min(b,d), then the intervals do not overlap. 
Otherwise, they overlap.

Do you think it will be easier to solve if you could sort 
the intervals based on the starting point?

First lets sort the array based on the starting point , if 
starting points are equal then based on ending point.

We can maintain two variables cur_start and cur_end 
where cur_start is the left most point of the current 
segment and cur_end is rightmost point of the current segment.
Set cur_start to the starting point of the first element 
and cur_end to the ending point of the first element.

Now we iterate from 1 to n-1 and for every i we check 
the following
if A[i].left <= cur_end

This means i’th interval overlaps with the current 
interval, so we can add this to the current interval

else

This means the i’th interval doesnt overlap with the 
current interval, therefore we can add the current 
interval to our answer and make a new interval i.e. set 
cur_start=A[i].start and cur_end=A[i].end

Lastly dont forget to add the current interval to our answer.
```
* Complete Solution
```java
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Sorting the intervals first based on start point and then based on end point.
        Collections.sort(intervals, new IntervalComp());
        
        //res is the ArrayList that we will return
        ArrayList<Interval> res;
        
        Interval inter;
        int n = intervals.size();
        res = new ArrayList<>();
        
        for (int i = 0; i < n;) {
            // making a new segment
            inter = new Interval(intervals.get(i).start, intervals.get(i).end);
            Interval next;
            i++;
            while (i < n) {
                next = intervals.get(i);
                // Checking if i-th element falls in the current segment
                if (overlap(inter, next)) {
                    // adding i-th element to the current segment
                    inter.end = Math.max(inter.end, next.end);
                    i++;
                } else {
                    break;
                }
            }
            // adding current segment to our answer.
            res.add(inter);
        }
        return res;
    }
    private boolean overlap(Interval int1, Interval int2) {
        if (int1.end >= int2.start && int1.start <= int2.end)
            return true;
        return false;
    }
    
    private class IntervalComp implements Comparator<Interval> {
        @Override
        public int compare(Interval interval1, Interval interval2) {
            int cmp =  Integer.compare(interval1.start, interval2.start);
            if (cmp != 0)
                return cmp;
            cmp = Integer.compare(interval1.end, interval2.end);
            return cmp;
        }
    }
}
```

```javascript
module.exports = { 
    /**
     * Interval: [start, end]
     * 
     * param A: intervals, a list of Intervals
     * return :a list of Intervals
     */
	merge : function(A){
        // Sorting the intervals first based on start point and then based on end point
        A.sort((a, b) => {
            if(a[0] == b[0])return -a[1] + b[1];
            return a[0] - b[0];
        });
        
        //ret is the array that we will return
        let ret = [], n = A.length;
        
        for(let i = 0; i < A.length; i++){
            // making a new segment
            let ed = A[i][1];
            let j = i;
            // Checking if (j+1)-th element falls in the current segment
            while(j + 1 < n && A[j + 1][0] <= ed){
                j++; 
                // adding j-th element to the current segment
                ed = Math.max(ed, A[j][1]);
            }
            A[i][1] = ed;
            // adding current segment to our answer.
            ret.push(A[i]);
            i = j;
        };
        
        return ret;
	}
};
```

```cpp
vector < Interval > Solution::merge(vector < Interval > & A) {
    // Sorting the vector A first based on start point and then based on end point.

    sort(A.begin(), A.end(), [](Interval a, Interval b) {
        if (a.start != b.start)
            return (a.start < b.start);
        else
            return (a.end < b.end);
    });

    // ans is the vector that we will return
    vector < Interval > ans;

    // Current Segment
    int cur_start = A[0].start, cur_end = A[0].end;

    for (int i = 1; i < A.size(); i++) {
        // Checking if i'th element falls in the current segment
        if (A[i].start <= cur_end) {
            // adding A[i] to the current segment
            cur_end = max(cur_end, A[i].end);
        } else {
            // adding current segment to our answer.
            Interval temp(cur_start, cur_end);
            ans.push_back(temp);

            // making a new segment
            cur_start = A[i].start;
            cur_end = A[i].end;
        }
    }
    Interval temp(cur_start, cur_end);
    ans.push_back(temp);
    return ans;
}
```

