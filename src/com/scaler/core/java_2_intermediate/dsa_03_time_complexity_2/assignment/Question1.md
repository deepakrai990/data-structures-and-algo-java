### Q1. Time Complexity Easy 01
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
    int count =0;
    while(N){
        count++;
        N/=3;
    }
</pre>
        
<pre>
    int count =0;
    while(N &gt; 0){
        count++;
        N/=3;
    }
</pre>
        
<pre>
    count = 0
    while N &gt; 0:
        count += 1
        N = N // 3
</pre>

#### Options
```text
1. O(N)
2. O(N*N)
3. O(Nlog(N))
4. O(log(N)) {Base 3}
5. O(log(N)) {Base 2}
```

* Complete Solution
```text
Here, the N is reduced by factor of 1/3 in every iterations.
That means, N/3 N/(3^2)... 0

We have to find k such that,
N/(3^k) = 0
We will approx it to, N/(3^k) = 1
Or, N = 3^k
Taking log we will get k=logN where base is 3.
```

