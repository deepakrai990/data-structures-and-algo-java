### Q1. Merge Intervals
#### Problem Description
```text
Given a set of non-overlapping intervals, insert 
a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially 
sorted according to their start times.
```
#### Problem Constraints
* <p>0 &lt;= <strong>|intervals|</strong> &lt;= 10<sup>5</sup> </p>
```text
0 <= |intervals| <= 10^5
```
#### Input Format
```text
First argument is the vector of intervals

second argument is the new interval to be merged
```
#### Output Format
```text
Return the vector of intervals after merging
```
#### Example Input
```text
Input 1:
 Given intervals [1, 3], [6, 9] insert and merge [2, 5] .

Input 2:
 Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
```
#### Example Output
```text
Output 1:
 [ [1, 5], [6, 9] ]

Output 2:
 [ [1, 9] ]
```
#### Example Explanation
```text
Explanation 1:
 (2,5) does not completely merge the given intervals

Explanation 2:
 (2,6) completely merges the given intervals
```
### Hints
* Hint 1
```text
This problem has a lot of corner cases that need to 
be handled correctly.

Let us first talk about the approach.

Given all the intervals, you need to figure out the 
sequence of intervals that intersect with the 
given new interval.

Lets see how we check if interval 1 (a,b) intersects 
with interval 2 (c,d):

Overlap case :

    a---------------------b                      OR       a------b
                c-------------------d                c------------------d
Non-overlap case:

    a--------------------b   c------------------d

Note that if max(a,c) > min(b,d), then the intervals 
do not overlap. Otherwise, they overlap.

Once we figure out the intervals ( interval[i] 
to the interval[j] ) which overlap with the 
new interval, note that we can replace all 
the overlapping intervals with one interval, 
which would be

(min(interval[i].start, newInterval.start), max(interval[j].end, newInterval.end)).

Do make sure you cover the other corner cases.
```
* Solution Approach
```text
Have you covered the following corner cases :

1) Size of interval array as 0.

2) newInterval being an interval preceding all intervals in the array.
    Given interval (3,6),(8,10), insert and merge (1,2)

3) newInterval being an interval succeeding all intervals in the array.
    Given interval (1,2), (3,6), insert and merge (8,10)

4) newInterval not overlapping with any interval and falling in between 2 intervals in the array.
    Given interval (1,2), (8,10) insert and merge (3,6) 

5) newInterval covering all given intervals.
    Given interval (3, 5), (7, 9) insert and merge (1, 10)

```
* Complete Solution
* * Solution in Java
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        int start = newInterval.start;
        int end = newInterval.end;
        int startIndex = -1;
        int endIndex = -1;
        for (Interval in : intervals) {
            if (start >= in.start && start <= in.end)
                startIndex = i;
            if (end >= in.start && end <= in.end)
                endIndex = i;
            i++;
        }
        // endpoints of new interval doesn't lie inside any other interval
        if (startIndex == -1 && endIndex == -1) {
            startIndex = 0;
            for (i = 0; i < intervals.size(); i++) {
                if (start > intervals.get(i).end) {
                    startIndex = i + 1;
                }
            }
            endIndex = intervals.size() - 1;
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (end < intervals.get(i).start) {
                    endIndex = i - 1;
                }
            }
            // Intervals between startIndex and endIndex lies completely inside new interval
            for (i = startIndex; i <= endIndex; i++) {
                intervals.remove(startIndex);
            }
            intervals.add(startIndex, newInterval);
            return intervals;
        }
        if (startIndex == -1) {
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (start <= intervals.get(i).start)
                    startIndex = i;
            }
        }
        if (endIndex == -1) {
            for (i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).end)
                    endIndex = i;
            }
        }
        start = Math.min(intervals.get(startIndex).start, start);
        end = Math.max(intervals.get(endIndex).end, end);
        intervals.get(startIndex).start = start;
        intervals.get(startIndex).end = end;
        for (i = startIndex + 1; i <= endIndex; i++) {
            intervals.remove(startIndex + 1);
        }
        return intervals;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    /**
     * Interval: [start, end]
     * 
     * param A: intervals, a list of Intervals
     * return :a list of Intervals
     */
    solve: function (intervals, new_interval) {
        new_interval.sort((a, b)=> a - b);
        // inserts the new_interval to intevals
        intervals.push(new_interval);
        intervals.sort((a, b) => {
            if(a[0] == b[0])return -a[1] + b[1];
            return a[0] - b[0];
        });
        let ret = [], n = intervals.length;
        // merges all overlapping intervals
        for(let i = 0; i < intervals.length; i++){
            let ed = intervals[i][1];
            let j = i;
            while(j + 1 < n && intervals[j + 1][0] <= ed)j++, ed = Math.max(ed, intervals[j][1]);
            intervals[i][1] = ed;
            ret.push(intervals[i]);
            i = j;
        };
        return ret;
    },
};
```
* * Solution in C++
```cpp
/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
bool doesIntersect(Interval a, Interval b) {
    if (min(a.end, b.end) < max(a.start, b.start))
        return false;
    return true;
}
vector < Interval > Solution::insert(vector < Interval > & intervals, Interval newInterval) {
    int sz = intervals.size();
    vector < Interval > result;
    // check corner cases
    // Case : Empty intervals array
    if (sz == 0) {
        result.push_back(newInterval);
        return result;
    }
    // Case : newInterval comes at the beginning or at the end without overlap 
    if (newInterval.start > intervals[sz - 1].end || newInterval.end < intervals[0].start) {
        if (newInterval.end < intervals[0].start) {
            result.push_back(newInterval);
        }
        for (int i = 0; i < sz; i++) {
            result.push_back(intervals[i]);
        }
        if (newInterval.start > intervals[sz - 1].end) {
            result.push_back(newInterval);
        }
        return result;
    }
    for (int i = 0; i < sz; i++) {
        bool intersect = doesIntersect(intervals[i], newInterval);
        if (!intersect) {
            result.push_back(intervals[i]);
            // check if newInterval lies between intervals[i] and intervals[i+1]
            if (i < sz - 1 && newInterval.start > intervals[i].end && newInterval.end < intervals[i + 1].start) {
                result.push_back(newInterval);
            }
            continue;
        }
        // Now we know the interval overlaps. Lets find out how many intervals overlap. 
        int st = i;
        while (i < sz && intersect) {
            i++;
            if (i == sz) intersect = false;
            else {
                intersect = doesIntersect(intervals[i], newInterval);
            }
        }
        i--;
        // Now all intervals from st to i overlap. 
        Interval toInsert(min(newInterval.start, intervals[st].start), max(newInterval.end, intervals[i].end));
        result.push_back(toInsert);
    }
    return result;
}
```

