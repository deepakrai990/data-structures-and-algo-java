### Q6. Time Complexity - 10
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
for (int i = 3 ; i &lt; n / 3  ;  i += 3) {
    for(int j = 2 ; j &lt; n / 2 ; j += 2){
        // O(1) operation  
    }
}
</pre>
<pre>
for (int i = 3 ; i &lt; n / 3  ;  i += 3) {
    for(int j = 2 ; j &lt; n / 2 ; j += 2){
        // O(1) operation  
    }
}
</pre>
<pre>
for i in range(3, n/3, 3):
    for j in range(2, n/2, 2):
        # O(1) operation
</pre>

#### Options
```text
1. O(n)
2. O(n^3)
3. O(n^2)
4. O(n^(1/2))
5. None of these
```

* Solution Approach
```text
Try to compare it with the normal nested two loops and calculate 
the big-O time complexity
```
* Complete Solution
```text
Even though the first loop is increased by 3 and ends at n/3 ,and 
the inner loop is increased by 2 and end at n/2 , the big-O runtime 
doesn't consider constants. 

Hence the overall time complexity will be O(N^2)
```

