### Q3. Time Complexity-iii
#### Problem Description
```text
What is the time complexity of the following code snippet?
```
<ul>
<li><a>C++</a></li>
<li><a>Java</a></li>
<li><a>Python</a></li>
</ul>
<pre>
for(int i = 0; i &lt; n; i++) {
    for(int j = i - 1; j &gt;= 0; j++) {
        ans += i + j ;
    }
}
</pre>
<pre>
for(int i = 0; i &lt; n; i++) {
    for(int j = i - 1; j &gt;= 0; j++) {
        ans += i + j ;
    }
}
</pre>
<pre>
for i in range(n):
    j = i-1
    while(j &gt;= 0):
        ans += i + j 
        j += 1
</pre>

#### Options
```text
1. O(n)
2. O(n^2)
3. Code will run indefinitely
4. O(1)
5. None of the above
```
* Solution Approach
```text
Observe the second loop
```

* Complete Solution
```text
Since the end of the loop is set 0 and its start is i-1 and 
variable j is increased rather than decreasing , j will always 
be greater or equal to 0
```

