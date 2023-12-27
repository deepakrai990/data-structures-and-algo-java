### Q4. Time Complexity - 3B
#### Problem Description
```text
What will be the Time Complexity of the given code?
```
<ul>
<li><a>C++</a></li>
<li><a>Java</a></li>
<li><a>Python</a></li>
</ul>
<pre>
void solve() {
    int i = 1;
    while (i &lt; n) {
        int x = i;
        while (x--) {
            //O(1) operation
        }
        i++;
    }
}
</pre>
<pre>
public void solve() {
    int i = 1;
    while (i &lt; n) {
        int x = i;
        while (x--&gt; 0) {
            //O(1) operation
        }
        i++;
    }
}
</pre>
<pre>
def solve():
    i = 1
    while (i &lt; n):
        x = i
        while (x &gt; 0):
            #O(1) operation
            x -= 1
        i += 1
</pre>

#### Options
```text
1. O(n log n)
2. O(n)
3. O(n sqrt(n)
4. O(n^2)
5. None of the above
```
* Solution Approach
```text
Notice the number of operations taking place in the loops.
```

* Complete Solution
```text
The total number of operations taking place is the sum of 
first n natural numbers, which is equal to n * (n + 1) / 2.

Therefore, the time complexity is O(n2).
```

