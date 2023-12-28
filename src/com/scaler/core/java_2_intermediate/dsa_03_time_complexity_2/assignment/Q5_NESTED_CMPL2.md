### Q5. NESTED_CMPL2
#### Problem Description
```text
What is the time complexity of the following code :
```
<ul>
<li><a>C++</a></li>
<li><a>Java</a></li>
<li><a>Python</a></li>
</ul>
<pre>
int a = 0;
for (i = 0; i &lt; N; i++) {
    for (j = N; j &gt; i; j--) {
        a = a + i + j;
    }
}
</pre>
<pre>
int a = 0;
for (i = 0; i &lt; N; i++) {
    for (j = N; j &gt; i; j--) {
        a = a + i + j;
    }
}
</pre>
<pre>
a = 0
for i in range(N):
    for j in range(N):
        a = a + i + j
</pre>

#### Options
```text
1. O(N)
2. O(N*log(N))
3. O(N * Sqrt(N))
4. O(N*N)
```
* Solution Approach
```text
Count the number of times the loop runs.

When i = 0, it runs for N times.

When i = 1, it runs for N - 1 times …

When i = k, it runs for N - k times

So, total number of runs = N + (N - 1) + (N - 2) + … 1 + 0 = ???
```

* Complete Solution
```text
Total number of runs = N + (N - 1) + (N - 2) + ... 1 + 0

= N * (N + 1) / 2

= 1/2 * N^2 + 1/2 * N

O(N^2) times. 
```

