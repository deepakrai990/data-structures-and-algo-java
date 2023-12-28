### Q5. Time Complexity - 8
#### Problem Description
```text
What is the time complexity of the following code snippet?
```
<pre>
    int sum = 0;
    for(int i = 0; i &lt;= N; i ++) {
       for(int j = i; j &lt;= N &amp;&amp; j &gt; i; j++) {
          sum += i;
       }
    }
</pre>
#### Options
```text
1. O(N^2)
2. O(N)
3. O(N log N)
4. None of these
```

* Complete Solution
```text
Observe the inner loop condition.

Since the inner loop condition is the j should be greater 
than i and as j is initialised with i , the inner loop will 
stop then and there.

Hence O(N) time complexity
```

