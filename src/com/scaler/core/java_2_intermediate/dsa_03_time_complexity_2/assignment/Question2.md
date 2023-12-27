### Q2. Time Complexity Easy 02
#### Problem Description
```text
What is the Time Complexity of following snippet ?
```

<ul>
    <li>C++</li>
    <li>Java</li>
    <li>Python</li>
</ul>
<pre>
    for (i = 0; i &lt; N; i++) { 
      for (j = i; j &lt; N; j++) { 
         break; 
      }
    }
</pre>
<pre>
    for (i = 0; i &lt; N; i++) { 
      for (j = i; j &lt; N; j++) { 
         break; 
      }
    }
</pre>
<pre>
    for i in range(N):
        for j in range(i, N):
            break
</pre>

#### Options
```text
1. O(N*N)
2. O(N*log(N))
3. O(N)
4. O(log(N))
5. None of the above
```

* Complete Solution
```text
The inner loop is not running completely. So complexity will 
depend on the outer one.

Here for every i the inner loop will run for only iteration. So the 
complexity is the number of times outer loop will run.

That is N so complexity is O(N).
```

