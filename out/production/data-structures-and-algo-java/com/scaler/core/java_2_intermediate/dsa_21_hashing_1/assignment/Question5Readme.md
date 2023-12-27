### Q5. Time Complexity - 6 - II
#### Problem Description
```text
What is the time complexity of the following:
```
<ul>
    <li>C++</li>
    <li>Java</li>
    <li>Python</li>
</ul>
<pre>
unordered_set s;
for (int j = 0; j &lt; n; j++) {
    s.insert(j);
}
</pre>
<pre>
HashSet&lt;Integer&gt; s = new HashSet&lt;Integer&gt;();
for (int j = 0; j &lt; n; j++)
    s.add(j);
</pre>
<pre>
s = set()
for j in range(n):
    s.add(j)
</pre>

#### Options
```text
1. O(n)
2. O(log n)
3. O(n log n)
4. O(n^2)
5. None of the above
```

* Solution Approach
```text
What is the time complexity of insertion of an element in 
an unordered set?
```
* Complete Solution
```text
The time complexity of insertion of an element in an 
unordered set is O(1).

Repeating this operation for N times gives us a 
time complexity of O(N)
```
