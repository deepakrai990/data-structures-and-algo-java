### Q5. Time Complexity - M4
#### Problem Description
```text
Find the Time Complexity of the following function solve :
```
<ul>
<li><a>C++</a></li>
<li><a>Java</a></li>
<li><a>Python</a></li>
</ul>
<pre>
void solve(int N) {
    for(int i = 0; i &lt; pow(2, N); i++) {
        int j = i;
        while(j &gt; 0){
            j -= 1;
        }
    }
}
</pre>
<pre>
public void solve(int N) {
    for(int i = 0; i &lt; Math.pow(2,N); i++) {
        int j = i;
        while(j &gt; 0){
            j -= 1;
        }
    }
}
</pre>
<pre>
def solve(N):
    for i in range(2 ** N):
        j = i
        while j &gt; 0:
            j -= 1
</pre>

#### Options
```text
1. O(N * N)
2. O(2^N)
3. O(N * (2^N))
4. O(3^N)
5. O(4^N)
```

* Complete Solution
```text
The outer loops runs from 1 to 2^ N.
The inner loop runs from i to 0.
So, worst case TC will be O((2^N)^2) = O(4^N).
```

