### Q7. Time Complexity - 9
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
int i = 0;
while(i*i &lt;= N){
   for(int j = 0; j &lt;= N; j++){
      for(int k = 0; k &lt;= N; k++,i++){
         //O(1) operation
      }
   }
   i++;
}

</pre>
<pre>
int i = 0;
while(i*i &lt;= N){
   for(int j = 0; j &lt;= N; j++){
      for(int k = 0; k &lt;= N; k++,i++){
         //O(1) operation
      }
   }
   i++;
}
</pre>
<pre>i = 0;
while i*i &lt;= N:
    for j in range(N+1):
        for k in range(N+1):
            i += 1
            //O(1) operation

    i += 1

</pre>

#### Options
```text
1. O(NlogN)
2. O(N^3)
3. O(N^2 sqrt(N))
4. O(N^2)
5. None of these
```
* Solution Approach
```text
Observe the increment of variable in the innermost loop and 
crosscheck it with the while loop condition
```
* Complete Solution
```text
The nested for loop will have time complexity of O(N^2) and as 
during the loop run it also increments the variable i greater 
sqrt(N) the while will stop after the nested loop stops. Hence 
final time complexity will be O(N^2)
```

