### Q6. NESTED_CMPL3
#### Problem Description
```text
What is time complexity of following code :
```
<ul>
<li><a>C++</a></li>
<li><a>Java</a></li>
<li><a>Python</a></li>
</ul>
<pre>
int count = 0;
for (int i = N; i &gt; 0; i /= 2) {
    for (int j = 0; j &lt; i; j++) {
        count += 1;
    }
}
</pre>
<pre>
int count = 0;
for (int i = N; i &gt; 0; i /= 2) {
    for (int j = 0; j &lt; i; j++) {
        count += 1;
    }
}
</pre>
<pre>
count = 0
i = N
while i&gt;0:
    for j in range(i):
        count += 1
    i = i // 2
</pre>

#### Options
```text
1. O(N * N)
2. O(N * log N)
3. O(N * log(log(N)))
4. O(N)
5. O(N * Sqrt(N))
```

* Complete Solution
```text
In the first iteration, the j loop runs N times.

In the second iteration, the j loop runs N / 2 times. 

In the ith iteration, the j loop runs N / 2^i times. 

So, the total number of runs of loop = N + N / 2 + N / 4 + ... 1 

= **N * ( 1 + 1/2 + 1/4 + 1/8 + ... ) < 2 * N** 
```

