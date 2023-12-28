### Q4. Time Complexity Loops 1
#### Problem Description

<ul>
<li><a>C++</a></li>
<li><a>Java</a></li>
<li><a>Python</a></li>
</ul>
<pre>
void fun(int n) {
    for (int i = 1; i * i &lt;= n; i++) {
        for (int j = 1; j * j &lt;= i; j += i) {
            //O(1) operation
        }
    }
}
</pre>
<pre>
public static void fun(int n) {
    int i, j;
    for (i = 1; i * i &lt;= n; i++) {
        for (j = 1; j * j &lt;= i; j += i) {
            //O(1) operation
        }
    }
}
</pre>
<pre>
def fun():
    i = 1
    while(i * i &lt;= n):
        j = 1
        while(j * j &lt;= i):
            # O(1) operation
            j += i
        i += 1
</pre>

#### Options
```text
1. O(n)
2. O(√n)
3. O(n√n)
4. O(√n*log(√n))
```

* Solution Approach
```text
The inner loop will not run for too long.
```
* Complete Solution
```text
The outer loop wil run √n times. The inner loop will run 
only for j = 1 since 1 + i > √i. Thus, the 
time complexity is O(√n).
```

