### Q1. NESTED_CMPL
#### Problem Description
```text
What is the time, space complexity of following code :
```
<ul>
<li><a>C++</a></li>
<li><a>Java</a></li>
<li><a>Python</a></li>
</ul>
<pre>
int a = 0, b = 0;    
for (i = 0; i &lt; N; i++) {
    for (j = 0; j &lt; N; j++) {
        a = a + j;
    }
}
for (k = 0; k &lt; N; k++) {
    b = b + k;
} 
</pre>

<pre>
int a = 0, b = 0;    
for (i = 0; i &lt; N; i++) {
    for (j = 0; j &lt; N; j++) {
        a = a + j;
    }
}
for (k = 0; k &lt; N; k++) {
    b = b + k;
}
</pre>

<pre>
a = 0
b = 0
for i in range(N):
    for j in range(N):
        a = a + j
for k in range(N):
    b = b + k
</pre>

#### Options
```text
1. O(N * N) time, O(1) space
2. O(N) time, O(N) space
3. O(N) time, O(1) space
4. O(N * N) time, O(N) space
5. O(N * N * N) time, O(1) space
```

* Solution Approach
```text
Notice how the nested loop behaves. The j loop iterates 
for N times and the j loop itself is run N times.

So, the total number of runs would be N + N + …. N times
```
* Complete Solution
```text
The first set of nested loops is O(N^2) and the second loop is O(N). 

This is O(max(N^2,N)) which is O(N^2). 
```

